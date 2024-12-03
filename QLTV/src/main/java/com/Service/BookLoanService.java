package com.Service;

import com.Entity.Book;
import com.Model.DTO.BookLoanDTO;
import com.Model.Mapper.Mapper;
import com.Repository.BookLoanRepository;
import com.Entity.BookLoan;
import com.Entity.Reader;
import com.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookLoanService {
    @Autowired
    private BookLoanRepository bookLoanRepository;
    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private Mapper mapper;

    public BookLoanDTO findBookLoanById(Integer id) {
        if (!bookLoanRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong co id ");
        }
        if (!readerRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong co readerid ");
        }
        BookLoan bookLoans = bookLoanRepository.findById(id).get();
        return mapper.toBookLoanDTO(bookLoans);
    }


    public void createBookLoan(Map<String, Object> params) {
        BookLoan bookLoan = new BookLoan();
        Reader reader = new Reader();
        Integer readerid;
        if (params.containsKey("readerid")) {
            readerid = Integer.parseInt((String) params.get("readerid"));
            if (!readerRepository.existsById(readerid)) {
                throw new IllegalArgumentException("Khong co readerid ");
            }
        }
        readerid = Integer.parseInt((String) params.get("readerid"));
        reader = readerRepository.findById(readerid).get();
        bookLoan.setReader(reader);
        bookLoanRepository.save(bookLoan);
    }

    public void deleteBookLoanById(Integer id) {
        if (!bookLoanRepository.existsById(id)) {
            throw new IllegalArgumentException("Chua ton tai phieu muon co id " + id);
        }
        bookLoanRepository.deleteById(id);
    }


    public void updateBookLoanById(Map<String, Object> params) {
        BookLoan bookLoan = new BookLoan();
        Reader reader = new Reader();
        if (params.containsKey("id")) {
            bookLoan.setId(Integer.parseInt((String) params.get("id")));
        }
        if (!bookLoanRepository.existsById(bookLoan.getId())) {
            throw new IllegalArgumentException("Chua ton tai phieu muon co id ");
        }
        Integer readerid;
        if (params.containsKey("readerid")) {
            readerid = Integer.parseInt((String) params.get("readerid"));
            if (!readerRepository.existsById(readerid)) {
                throw new IllegalArgumentException("Khong co readerid ");
            }
        }
        readerid = Integer.parseInt((String) params.get("readerid"));
        reader = readerRepository.findById(readerid).get();
        bookLoan.setReader(reader);
        bookLoanRepository.save(bookLoan);
    }
}
