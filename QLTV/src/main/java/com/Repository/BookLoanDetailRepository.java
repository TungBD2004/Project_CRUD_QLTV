package com.Repository;

import com.Entity.BookLoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanDetailRepository extends JpaRepository<BookLoanDetail, Integer> {
}
