package com.Controller;

import com.Entity.BookLoan;
import com.Entity.Reader;
import com.Model.DTO.BookLoanDTO;
import com.Model.Mapper.Mapper;
import com.Repository.ReaderRepository;
import com.Service.BookLoanService;
import com.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookLoanController {
    @Autowired
    private BookLoanService bookLoanService;
    @Autowired
    private Mapper mapper;

    @GetMapping(value = "/api/bookloans/{id}")
    public BookLoanDTO getBookLoansById(@PathVariable Integer id) {
        try {
            BookLoanDTO dto = bookLoanService.findBookLoanById(id);
            return dto;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @PostMapping(value = "/api/bookloans")
    public ResponseEntity<String> addBookLoan(@RequestParam Map<String, Object> params) {
        try {
            bookLoanService.createBookLoan(params);
            return ResponseEntity.ok("Tao thanh cong bookloan ");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/api/bookloans/{id}")
    public ResponseEntity<String> deleteBookLoan(@PathVariable Integer id) {
        try {
            bookLoanService.deleteBookLoanById(id);
            return ResponseEntity.ok("Da xoa thanh cong id " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/api/bookloans")
    public ResponseEntity<String> updateBookLoan(@RequestParam Map<String, Object> params) {
        try {
            bookLoanService.updateBookLoanById(params);
            return ResponseEntity.ok("Cap nhat thanh cong bookloan ");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
