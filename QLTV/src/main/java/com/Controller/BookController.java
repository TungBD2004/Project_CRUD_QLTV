package com.Controller;

import com.Entity.Book;
import com.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@RestController
@Transactional
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/api/books/{id}")
    public Book getBookById(@PathVariable int id) {
        Book result = new Book();
        try {
            result = bookService.findBookById(id);
            return result;
        } catch (IllegalArgumentException e) {
            return null;
        }

    }

    @DeleteMapping(value = "/api/books/{id}")
    public ResponseEntity<String> deleteReaderById(@PathVariable Integer id) {
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.ok("Da xoa sach co id la " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/api/books")
    public void addReader(@RequestBody Book book) {
        bookService.createReader(book);
    }

    @PutMapping(value = "/api/books/{id}")
    public ResponseEntity<String> updateReader(@PathVariable Integer id, @RequestParam Map<String, Object> params) {
        try {
            bookService.updateBookById(id, params);
            return ResponseEntity.ok("Cap nhat thanh cong sach co id la " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
