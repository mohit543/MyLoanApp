package com.imcs.trng.service;

import com.imcs.trng.model.Customer;

public class LoanBusinessServiceImpl implements LoanBusinessService {

	@Override
	public String loanRequest(Customer customer) {
		if(customer.getAnnualSalary() > 50000)
		{
			return "your loan has approved";
		}
		else
		{
			return "Your loan has rejected at this time";
		}
	}

	

}
