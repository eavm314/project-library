package com.upb.projectLibrary.loan.services;

import com.upb.projectLibrary.catalog.models.Book;
import com.upb.projectLibrary.loan.models.Loan;

import java.util.List;

public interface ILoanService {
    List<Loan> getAllLoans();
    List<Loan> getLoansByUser(String userId);
    Loan createLoan(Loan loan);
    Loan updateLoan(Loan loan);
}
