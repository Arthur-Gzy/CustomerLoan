package com.example.CustomerLoan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.CustomerLoan.Entity.CustomerLoan;

@Repository
public interface CustomerLoanRepository extends JpaRepository<CustomerLoan, Long>{

	@Query(value="SELECT cl FROM CustomerLoan cl WHERE cl.customerId = :cid")
	List<CustomerLoan> getCustomerLoanById(@Param("cid") Long cid);
	
	@Query(value="SELECT cl FROM CustomerLoan cl")
	List<CustomerLoan> getAllCustomerLoans();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE CustomerLoan cl SET cl.loanQuantity = 0 WHERE cl.customerId = :cid")
	void deleteCustomerLoanById(@Param("cid") Long id);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE CustomerLoan cl SET cl.loanQuantity = :newLoan WHERE cl.customerId = :cid")
	void setCustomerLoanById(@Param("cid") Long id, @Param("newLoan") Long newLoan);
}
