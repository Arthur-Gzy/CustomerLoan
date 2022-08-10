package com.example.CustomerLoan.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.CustomerLoan.Dto.CustomerLoanDto;
import com.example.CustomerLoan.Entity.CustomerLoan;
import com.example.CustomerLoan.Repository.CustomerLoanRepository;
import com.example.CustomerLoan.Service.CustomerLoanService;

@Service
public class CustomerLoanServiceImpl implements CustomerLoanService{
	
	@Autowired
	CustomerLoanRepository customerLoanRepository;

	@Override
	public CustomerLoan getLoanByCustomerId(Long customerId) {
		List<CustomerLoan> customerLoan = customerLoanRepository.getCustomerLoanById(customerId);
		//Long id = -1L;
		if(customerLoan != null) {
			for(CustomerLoan customer: customerLoan) {
				Long id = customer.getCustomerId();
				if(customerId == id) {
					return customer;
				}
			}
		}
			return null;
	}

	@Override
	public List<CustomerLoan> getAllLoans() {
		List<CustomerLoan> customerLoans = new ArrayList<>();
		customerLoanRepository.findAll().forEach(loan -> customerLoans.add(loan));
		return customerLoans;
	}
	
	@Override
	public void addCustomerLoan(CustomerLoanDto customerLoanDto) {
		CustomerLoan customerLoan = new CustomerLoan();
		customerLoan.setCustomerId(customerLoanDto.getCustomerId());
		customerLoan.setCustomerLoan(customerLoanDto.getLoanQuantity());
		customerLoanRepository.save(customerLoan);
	}

}
