package com.example.CustomerLoan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.CustomerLoan.Service.CustomerLoanService;
import com.example.CustomerLoan.Dto.CustomerLoanDto;
import com.example.CustomerLoan.Entity.CustomerLoan;


@RestController
public class CustomerLoanController {
	
	@Autowired
	CustomerLoanService customerLoanService;
	
	@GetMapping(value="/getloanbyid/{c_id}")
	public ResponseEntity<CustomerLoan> getLoanByCustomerId(@PathVariable("c_id") Long customerId){
		CustomerLoan customerLoan = customerLoanService.getLoanByCustomerId(customerId);
		if(customerLoan == null) {
			return new ResponseEntity<CustomerLoan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CustomerLoan>(customerLoan, HttpStatus.OK);
	}
	
	@GetMapping(value="/getloans")
	public List<CustomerLoan> getAllCustomerLoans(){
		return customerLoanService.getAllLoans();
	}
	
	@PostMapping(value="/addcustomerloan")
	public String addCustomerLoan(@RequestBody CustomerLoanDto customerLoanDto) {
		customerLoanService.addCustomerLoan(customerLoanDto);
		return "Customer Loan Added To Database!";
	}
	
	@PutMapping(value="/deleteloan/{id}")
	public ResponseEntity<CustomerLoan> deleteLoanByCustomerId(@PathVariable("id") Long id){
		customerLoanService.deleteLoanByCustomerId(id);
		CustomerLoan customerLoan = customerLoanService.getLoanByCustomerId(id);
		return new ResponseEntity<CustomerLoan>(customerLoan, HttpStatus.OK);
	}
	
	@PutMapping(value="/customer/{id}/setloan/{loan}")
	public ResponseEntity<CustomerLoan> setLoanByCustomerId(@PathVariable("id") Long id, @PathVariable("loan") Long newLoan){
		customerLoanService.setLoanByCustomerId(id, newLoan);
		CustomerLoan customerLoan = customerLoanService.getLoanByCustomerId(id);
		return new ResponseEntity<CustomerLoan>(customerLoan, HttpStatus.OK);
	}

}
