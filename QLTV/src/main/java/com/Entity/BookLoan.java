package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "bookloan")
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "readerid")
    private Reader reader;

    /*@ManyToMany()
    @JoinTable(name = "bookloandetail",
    joinColumns = @JoinColumn(name = "bookloanid",nullable = false),
    inverseJoinColumns = @JoinColumn(name = "bookid",nullable = false))
    private List<Book> Books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> Books) {
        this.Books = Books;
    }*/

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
