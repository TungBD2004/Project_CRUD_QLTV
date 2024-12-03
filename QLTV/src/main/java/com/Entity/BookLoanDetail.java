package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "bookloandetail")
public class BookLoanDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookloanid")
    BookLoan bookloan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookid")
    Book book;

    @Column(name = "quantity")
    int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookLoan getBookloan() {
        return bookloan;
    }

    public void setBookloan(BookLoan bookloan) {
        this.bookloan = bookloan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
