package com.Repository;

import com.Repository.Entity.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {
    @Query(value = "select * from bookloan where id=:id", nativeQuery = true)
    BookLoan findBookLoanById(@Param("id") int id);
}