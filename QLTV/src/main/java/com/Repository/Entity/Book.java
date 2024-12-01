package com.Repository.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

   /* @ManyToMany(mappedBy = "Books")
    private List<BookLoan> BookLoans = new ArrayList<BookLoan>();*/

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

    /*public List<BookLoan> getBookLoans() {
        return BookLoans;
    }

    public void setBookLoans(List<BookLoan> BookLoans) {
        this.BookLoans = BookLoans;
    }*/
}
