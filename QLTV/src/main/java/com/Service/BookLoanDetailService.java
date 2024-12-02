package com.Service;

import com.Entity.BookLoanDetail;
import com.Repository.BookLoanDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanDetailService {
    @Autowired
    private BookLoanDetailRepository bookLoanDetailRepository;

    public void createBookLoanDetail(BookLoanDetail bookLoanDetail) {
        bookLoanDetailRepository.save(bookLoanDetail);
    }
}
