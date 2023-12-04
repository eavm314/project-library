package com.upb.projectLibrary.loan.repositories;

import com.upb.projectLibrary.loan.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILoanRepository extends JpaRepository<LoanEntity, Integer> {
    List<LoanEntity> findByUserId(String userId);
    LoanEntity findOneByUserIdAndBookId(String userId, String bookId);
}
