package com.Controller;

import com.Entity.Reader;
import com.Model.DTO.ReaderDTO;
import com.Model.Mapper.Mapper;
import com.Service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ReaderController {
    @Autowired
    private ReaderService readerService;
    @Autowired
    Mapper mapper;
    @GetMapping(value = "/api/readers/{id}")
    public ReaderDTO getReadersById(@PathVariable Integer id) {
        ReaderDTO dto = new ReaderDTO();
        try {
            dto  = readerService.findReaderById(id);
            return dto;
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
    public void addReader(@RequestBody @RequestParam Map<String, Object> params) {
        readerService.createReader(params);
    }

    @PutMapping(value = "/api/readers/")
    public ResponseEntity<String> updateReader( @RequestParam Map<String, Object> params) {
        try {
            readerService.updateReaderById(params);
            return ResponseEntity.ok("Cap nhat thanh cong doc gia " );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
