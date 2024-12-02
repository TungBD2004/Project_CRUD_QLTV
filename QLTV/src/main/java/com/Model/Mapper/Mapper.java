package com.Model.Mapper;

import com.Entity.BookLoanDetail;
import com.Model.DTO.BookDTO;
import com.Model.DTO.BookLoanDTO;
import com.Model.DTO.BookLoanDetailDTO;
import com.Model.DTO.ReaderDTO;
import com.Entity.Book;
import com.Entity.BookLoan;
import com.Entity.Reader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Autowired
    private ModelMapper modelMapper;

    public ReaderDTO toReaderDTO(Reader item) {
        ReaderDTO readerDTO = modelMapper.map(item, ReaderDTO.class);
        return readerDTO;
    }

    public BookDTO toBookDTO(Book item) {
        BookDTO bookDTO = modelMapper.map(item, BookDTO.class);
        return bookDTO;
    }

    public BookLoanDTO toBookLoanDTO(BookLoan item) {
        BookLoanDTO bookLoanDTO = modelMapper.map(item, BookLoanDTO.class);
        return bookLoanDTO;
    }
    public BookLoanDetailDTO toBookLoanDetailDTO(BookLoanDetail item) {
        BookLoanDetailDTO bookLoanDetailDTO = modelMapper.map(item, BookLoanDetailDTO.class);
        return bookLoanDetailDTO;
    }
}
