package com.Controller;

import com.Entity.BookLoan;
import com.Entity.Reader;
import com.Service.BookLoanService;
import com.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookLoanController {
    @Autowired
    private BookLoanService bookLoanService;
    @Autowired
    private ReaderService readerService;

    @GetMapping(value = "/api/bookloans/{id}")
    public BookLoan getBookLoansById(@PathVariable Integer id) {
        BookLoan result = new BookLoan();
        try {
            result = bookLoanService.findBookLoanById(id);
            return result;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @PostMapping(value = "/api/bookloans")
    public ResponseEntity<String> addBookLoan(@RequestBody String id) {
        try {
            Reader reader = readerService.findReaderById(Integer.parseInt(id));
            bookLoanService.createBookLoan(reader);
            return ResponseEntity.ok("Tao thanh cong bookloan moi co readerid la " + id);
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


}
