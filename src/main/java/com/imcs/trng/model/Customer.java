package com.imcs.trng.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String ssn;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String phoneNumber;
	private String email;
	private float loanAmount;
	private float annualSalary;	

}
