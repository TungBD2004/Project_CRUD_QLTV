package com.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookLoanDetailKey implements Serializable {
    @Column(name = "bookloanid")
    Integer bookLoanId;

    @Column(name = "bookid")
    Integer bookId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookLoanId() {
        return bookLoanId;
    }

    public void setBookLoanId(Integer bookLoanId) {
        this.bookLoanId = bookLoanId;
    }
}
