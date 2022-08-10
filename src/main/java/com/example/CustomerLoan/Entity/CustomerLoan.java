package com.example.CustomerLoan.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomerLoan")
public class CustomerLoan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="l_id")
	private Long l_id;
	
	@Column(name="customer_id")
	private Long customerId;
	
	@Column(name="loan_quantity")
	private Long loanQuantity;
	
	public CustomerLoan(){}
	
	public CustomerLoan(Long customerId, Long loanQuantity) {
		this.customerId = customerId;
		this.loanQuantity = loanQuantity;
	}
	
	public Long getCustomerId() {
		return this.customerId;
	}
	
	public void setCustomerId(Long customerId){
		this.customerId = customerId;
	}
	
	public Long getCustomerLoan() {
		return this.loanQuantity;
	}
	
	public void setCustomerLoan(Long loanQuantity) {
		this.loanQuantity = loanQuantity;
	}
	
	@Override
	public String toString() {
		return "CustomerLoan{"+"l_id="+this.l_id+", customerId="+this.customerId+", loanQuantity="+this.loanQuantity+"}";
	}
}
