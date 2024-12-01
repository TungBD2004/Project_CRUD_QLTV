package com.Service;

import com.Model.Mapper.Mapper;
import com.Repository.BookRepository;
import com.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Mapper bookMapper;

    public Book findBookById(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai sach " + id);
        }
        Book books = bookRepository.findById(id).get();
        return books;
    }

    public void deleteBookById(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai sach " + id);
        }
        bookRepository.deleteById(id);
    }

    public void createReader(Book books) {
        bookRepository.save(books);
    }

    public void updateBookById(Integer id, Map<String, Object> params) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai sach co id " + id);
        }
        Book books = bookRepository.findById(id).get();
        if (params.containsKey("name")) {
            books.setName((String) params.get("name"));
        }
        if (params.containsKey("quantity")) {
            books.setQuantity(Integer.parseInt((String) params.get("quantity")));
        }
    }
}
