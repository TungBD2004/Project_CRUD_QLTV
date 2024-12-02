package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "bookloandetail")
public class BookLoanDetail {
    @EmbeddedId
    BookLoanDetailKey id;

    @ManyToOne
    @MapsId("bookLoanId")
    @JoinColumn(name = "bookloanid")
    BookLoan bookloan;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "bookid")
    Book book;

    @Column(name = "quantity")
    int quantity;

    public BookLoanDetailKey getId() {
        return id;
    }

    public void setId(BookLoanDetailKey id) {
        this.id = id;
    }

    public BookLoan getBookloan() {
        return bookloan;
    }

    public void setBookloan(BookLoan bookloan) {
        this.bookloan = bookloan;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
