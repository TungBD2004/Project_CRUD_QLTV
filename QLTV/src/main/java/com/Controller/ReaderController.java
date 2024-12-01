package com.Controller;

import com.Entity.Reader;
import com.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @GetMapping(value = "/api/readers/{id}")
    public Reader getReadersById(@PathVariable Integer id) {
        Reader result = new Reader();
        try {
            result = readerService.findReaderById(id);
            return result;
        } catch (IllegalArgumentException e) {
            return null;
        }

    }

    @DeleteMapping(value = "/api/readers/{id}")
    public ResponseEntity<String> deleteReaderById(@PathVariable Integer id) {
        try {
            readerService.deleteReaderById(id);
            return ResponseEntity.ok("Da xoa doc gia co id la " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(value = "/api/readers")
    public void addReader(@RequestBody Reader readers) {
        readerService.createReader(readers);
    }

    @PutMapping(value = "/api/readers/{id}")
    public ResponseEntity<String> updateReader(@PathVariable Integer id, @RequestParam Map<String, Object> params) {
        try {
            readerService.updateReaderById(id, params);
            return ResponseEntity.ok("Cap nhat thanh cong doc gia co id la " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
