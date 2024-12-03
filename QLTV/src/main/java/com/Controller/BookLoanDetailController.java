package com.Controller;

import com.Entity.BookLoanDetail;
import com.Model.DTO.BookLoanDTO;
import com.Model.DTO.BookLoanDetailDTO;
import com.Service.BookLoanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BookLoanDetailController {
    @Autowired
    private BookLoanDetailService bookLoanDetailService;

    @PostMapping(value = "/api/bookloandetails")
    public ResponseEntity<String> addBookLoanDetail(@RequestParam Map<String, Object> params) {
        try {
            bookLoanDetailService.createBookLoanDetail(params);
            return ResponseEntity.ok("Da tao thanh cong ");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(value = "/api/bookloandetails/{id}")
    public BookLoanDetailDTO getBookLoanDetail(@PathVariable int id) {
        try {
            BookLoanDetailDTO dto = bookLoanDetailService.findBookLoanDetailById(id);
            return dto;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @DeleteMapping(value = "/api/bookloandetails/{id}")
    public ResponseEntity<String> deleteBookLoanDetail(@PathVariable int id) {
        try {
            bookLoanDetailService.deleteBookLoanDetailById(id);
            return ResponseEntity.ok("Da xoa thanh cong ");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/api/bookloandetails")
    public ResponseEntity<String> updateBookLoanDetail(@RequestParam Map<String, Object> params) {
        try {
            bookLoanDetailService.updateBookLoanDetail(params);
            return ResponseEntity.ok("Da cap nhat thanh cong ");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
