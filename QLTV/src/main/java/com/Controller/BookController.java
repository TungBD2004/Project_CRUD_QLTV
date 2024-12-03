package com.Controller;

import com.Entity.Book;
import com.Model.DTO.BookDTO;
import com.Model.Mapper.Mapper;
import com.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private Mapper mapper;

    @GetMapping(value = "/api/books/{id}")
    public BookDTO getBookById(@PathVariable int id) {
        try {
            BookDTO bookDTO = new BookDTO();
            return bookService.findBookById(id);
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
    public void addReader(@RequestParam Map<String, Object> params) {
        bookService.createReader(params);
    }

    @PutMapping(value = "/api/books")
    public ResponseEntity<String> updateReader(@RequestParam Map<String, Object> params) {
        try {
            bookService.updateBookById(params);
            return ResponseEntity.ok("Cap nhat thanh cong sach  ");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
