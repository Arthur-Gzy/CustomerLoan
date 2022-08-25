package com.example.CustomerLoan.Service;

import java.util.List;

import com.example.CustomerLoan.Dto.CustomerLoanDto;
import com.example.CustomerLoan.Entity.CustomerLoan;

public interface CustomerLoanService {
	CustomerLoan getLoanByCustomerId(Long id);
	List<CustomerLoan> getAllLoans();
	void addCustomerLoan(CustomerLoanDto customerLoanDto);
	void deleteLoanByCustomerId(Long id);
	void setLoanByCustomerId(Long id, Long newLoan);
}
