package com.example.CustomerLoan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CustomerLoan.Entity.CustomerLoan;

@Repository
public interface CustomerLoanRepository extends JpaRepository<CustomerLoan, Long>{

	@Query(value="SELECT cl FROM CustomerLoan cl WHERE cl.customerId = :cid")
	List<CustomerLoan> getCustomerLoanById(@Param("cid") Long cid);
	
	@Query(value="SELECT * FROM customer_loan cl", nativeQuery=true)
	List<CustomerLoan> getAllCustomerLoans();
}
