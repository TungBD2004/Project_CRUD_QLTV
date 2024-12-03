package com.Service;

import com.Entity.Book;
import com.Entity.BookLoan;
import com.Entity.BookLoanDetail;
import com.Model.DTO.BookLoanDetailDTO;
import com.Model.Mapper.Mapper;
import com.Repository.BookLoanDetailRepository;
import com.Repository.BookLoanRepository;
import com.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookLoanDetailService {
    @Autowired
    private BookLoanDetailRepository bookLoanDetailRepository;
    @Autowired
    private BookLoanRepository bookLoanRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private Mapper mapper;

    public void createBookLoanDetail(Map<String, Object> params) {
        BookLoanDetail bookLoanDetail = new BookLoanDetail();
        Book book = new Book();
        BookLoan bookLoan = new BookLoan();
        Integer bookLoanId;
        Integer bookId;
        if (params.containsKey("bookloanid")) {
            bookLoanId = Integer.parseInt(params.get("bookloanid").toString());
            if (!bookLoanRepository.existsById(bookLoanId)) {
                throw new IllegalArgumentException("Khong ton tai bookloan");
            }
            bookLoan = bookLoanRepository.findById(bookLoanId).get();
        }
        if (params.containsKey("bookid")) {
            bookId = Integer.parseInt(params.get("bookid").toString());
            if (!bookRepository.existsById(bookId)) {
                throw new IllegalArgumentException("Khong ton tai sach");
            }
            book = bookRepository.findById(bookId).get();
        }

        bookLoanDetail.setBook(book);
        bookLoanDetail.setBookloan(bookLoan);
        if (params.containsKey("quantity")) {
            bookLoanDetail.setQuantity(Integer.parseInt(params.get("quantity").toString()));
        }
        bookLoanDetailRepository.save(bookLoanDetail);
    }

    public BookLoanDetailDTO findBookLoanDetailById(Integer id) {
        if (!bookLoanDetailRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai id");
        }
        BookLoanDetail bookLoanDetail = bookLoanDetailRepository.findById(id).get();
        return mapper.toBookLoanDetailDTO(bookLoanDetail);
    }

    public void deleteBookLoanDetailById(Integer id) {
        if (!bookLoanDetailRepository.existsById(id)) {
            throw new IllegalArgumentException("Khong ton tai id");
        }
        bookLoanDetailRepository.deleteById(id);
    }

    public void updateBookLoanDetail(Map<String, Object> params) {
        BookLoanDetail bookLoanDetail = new BookLoanDetail();
        Book book = new Book();
        BookLoan bookLoan = new BookLoan();
        Integer bookLoanId;
        Integer bookId;
        if (params.containsKey("id")) {
            bookLoanDetail.setId(Integer.parseInt((String) params.get("id")));
        }
        if (!bookLoanDetailRepository.existsById(bookLoanDetail.getId())) {
            throw new IllegalArgumentException("Chua ton tai detail co id ");
        }
        if (params.containsKey("bookloanid")) {
            bookLoanId = Integer.parseInt(params.get("bookloanid").toString());
            if (!bookLoanRepository.existsById(bookLoanId)) {
                throw new IllegalArgumentException("Khong ton tai bookloan");
            }
            bookLoan = bookLoanRepository.findById(bookLoanId).get();
        }
        if (params.containsKey("bookid")) {
            bookId = Integer.parseInt(params.get("bookid").toString());
            if (!bookRepository.existsById(bookId)) {
                throw new IllegalArgumentException("Khong ton tai sach");
            }
            book = bookRepository.findById(bookId).get();
        }
        bookLoanDetail.setBook(book);
        bookLoanDetail.setBookloan(bookLoan);
        if (params.containsKey("quantity")) {
            bookLoanDetail.setQuantity(Integer.parseInt(params.get("quantity").toString()));
        }
        bookLoanDetailRepository.save(bookLoanDetail);
    }

}
