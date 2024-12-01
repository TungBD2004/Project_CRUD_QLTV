package com.Model.Mapper;

import com.Model.DTO.BookDTO;
import com.Model.DTO.BookLoanDTO;
import com.Model.DTO.ReaderDTO;
import com.Repository.Entity.Book;
import com.Repository.Entity.BookLoan;
import com.Repository.Entity.Reader;
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
}
