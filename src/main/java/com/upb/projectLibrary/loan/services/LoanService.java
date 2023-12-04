package com.upb.projectLibrary.loan.services;

import com.upb.projectLibrary.loan.entities.LoanEntity;
import com.upb.projectLibrary.loan.models.Loan;
import com.upb.projectLibrary.loan.repositories.ILoanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService implements ILoanService {
    @Autowired
    private ILoanRepository loanRepostory;


    @Override
    public List<Loan> getAllLoans() {
        List<LoanEntity> loanEntities = this.loanRepostory.findAll();
        List<Loan> loanList = loanEntities
                .stream().map(loanEntity -> {
                    Loan loan = new Loan();
                    BeanUtils.copyProperties(loanEntity, loan);
                    return loan;
                }).collect(Collectors.toList());

        return loanList;
    }

    @Override
    public List<Loan> getLoansByUser(String userId) {
        List<LoanEntity> loanEntities = this.loanRepostory.findByUserId(userId);
        List<Loan> loanList = loanEntities
                .stream().map(loanEntity -> {
                    Loan loan = new Loan();
                    BeanUtils.copyProperties(loanEntity, loan);
                    return loan;
                }).collect(Collectors.toList());

        return loanList;
    }

    @Override
    public Loan createLoan(Loan loan) {
        LoanEntity entity = new LoanEntity();
        BeanUtils.copyProperties(loan, entity);
        loanRepostory.save(entity);
        // Optional<EmployeeEntity> employee1 = employeeRepository.findById("12313");
        return loan;
    }

    @Override
    public Loan updateLoan(Loan loan) {
        LoanEntity loanEntity = this.loanRepostory.findOneByUserIdAndBookId(loan.getUserId(), loan.getBookId());
        if (loanEntity == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este prestamo no existe");
        }

        BeanUtils.copyProperties(loan, loanEntity);
        loanRepostory.save(loanEntity);

        return loan;
    }
}
