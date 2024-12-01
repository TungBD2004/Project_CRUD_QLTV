package com.Service;

import com.Model.DTO.BookLoanDTO;
import com.Model.Mapper.Mapper;
import com.Repository.BookLoanRepository;
import com.Repository.Entity.BookLoan;
import com.Repository.Entity.Reader;
import com.Repository.ReaderRepository;
import org.apache.catalina.util.Introspection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookLoanService {
    @Autowired
    private BookLoanRepository bookLoanRepository;
    @Autowired
    private ReaderRepository readerRepository;

    public BookLoan findBookLoanById(Integer id) {
        if (!bookLoanRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong co id ");
        }
        BookLoan bookLoans = bookLoanRepository.findById(id).get();
        return bookLoans;
    }


    public void createBookLoan(Reader reader) {
        BookLoan bookLoan = new BookLoan();
        bookLoan.setReader(reader);
        bookLoanRepository.save(bookLoan);
    }

    public void deleteBookLoanById(Integer id) {
        if (!bookLoanRepository.existsById(id)) {
            throw new IllegalArgumentException("Chua ton tai phieu muon co id " + id);
        }
        bookLoanRepository.deleteById(id);
    }

    public void updateBookLoanById(Integer id, Map<String, Object> params) {
        if (!bookLoanRepository.existsById(id)) {
            throw new IllegalArgumentException("Chua ton tai phieu muon co id " + id);
        }
        BookLoan bookLoans = bookLoanRepository.findById(id).get();
        if (params.containsKey("readerid")) {
            Reader reader = readerRepository.findById(Integer.parseInt(params.get("readerid").toString())).get();
            bookLoans.setReader(reader);
        }
    }
}
