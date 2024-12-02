package com.Service;

import com.Model.DTO.BookDTO;
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
    private Mapper mapper;

    public BookDTO findBookById(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai sach " + id);
        }
        Book books = bookRepository.findById(id).get();
        return mapper.toBookDTO(books);
    }

    public void deleteBookById(Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai sach " + id);
        }
        bookRepository.deleteById(id);
    }

    public void createReader(Map<String, Object> params) {
        Book book = new Book();
        if (params.containsKey("name")) {
            book.setName((String) params.get("name"));
        }
        if (params.containsKey("quantity")) {
            book.setQuantity(Integer.parseInt((String) params.get("quantity")));
        }
        bookRepository.save(book);
    }

    public void updateBookById( Map<String, Object> params) {
        Book books = new Book();
        if (params.containsKey("id")) {
            books.setId(Integer.parseInt((String) params.get("id")));
        }
        if (!bookRepository.existsById(books.getId())) {
            throw new IllegalArgumentException("Khong ton tai sach " );
        }

        if (params.containsKey("name")) {
            books.setName((String) params.get("name"));
        }
        if (params.containsKey("quantity")) {
            books.setQuantity(Integer.parseInt((String) params.get("quantity")));
        }
        bookRepository.save(books);
    }
}
