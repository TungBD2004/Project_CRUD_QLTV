package com.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(mappedBy = "Books")
    private List<BookLoan> BookLoans = new ArrayList<BookLoan>();

    @OneToMany(mappedBy = "book")
    Set<BookLoanDetail> bookLoanDetails;

    public Set<BookLoanDetail> getBookLoanDetails() {
        return bookLoanDetails;
    }

    public void setBookLoanDetails(Set<BookLoanDetail> bookLoanDetails) {
        this.bookLoanDetails = bookLoanDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BookLoan> getBookLoans() {
        return BookLoans;
    }

    public void setBookLoans(List<BookLoan> BookLoans) {
        this.BookLoans = BookLoans;
    }
}
