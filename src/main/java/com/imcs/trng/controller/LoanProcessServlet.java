package com.imcs.trng.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.imcs.trng.model.Customer;
import com.imcs.trng.service.LoanBusinessService;
import com.imcs.trng.service.LoanBusinessServiceImpl;

/**
 * Servlet implementation class LoanProcessServlet
 */
public class LoanProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoanBusinessService loanBusinessService = new LoanBusinessServiceImpl();

	public LoanProcessServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorMessage = validateCustomer(request);
		if (StringUtils.isNoneBlank(errorMessage)) {
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/LoanRequest.jsp");
			rd.forward(request, response);
			return;
		}

		Customer customer = createCustomer(request);

		String loanResponse = loanBusinessService.loanRequest(customer);

		request.setAttribute("loanResponse", loanResponse);

		RequestDispatcher rd = request.getRequestDispatcher("/pages/LoanResponse.jsp");
		rd.forward(request, response);
		return;
	}

	Customer createCustomer(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
		String ssn = request.getParameter("ssn");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String postalCode = request.getParameter("postalCode");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		Float loanAmount = Float.parseFloat(request.getParameter("loanAmount"));
		Float annualSalary = Float.parseFloat(request.getParameter("annualSalary"));

		return new Customer(firstName, lastName, dateOfBirth, ssn, addressLine1, addressLine2, city, state, country,
				postalCode, phoneNumber, email, loanAmount, annualSalary);

	}

	private String validateCustomer(HttpServletRequest request) {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String ssn = request.getParameter("ssn");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String postalCode = request.getParameter("postalCode");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String loanAmount = request.getParameter("loanAmount");
		String annualSalary = request.getParameter("annualSalary");

		if (StringUtils.isBlank(firstName)) {
			return "FirstName is required";
		}
		if (StringUtils.isBlank(lastName)) {
			return "Last Name is required";
		}
		if (StringUtils.isBlank(dateOfBirth)) {
			return "Birthdate is required";
		}
		if (StringUtils.isBlank(ssn)) {
			return "SSN is must";
		}
		if (StringUtils.isBlank(addressLine1)) {
			return "AddressLine1 is required";
		}
		if (StringUtils.isBlank(addressLine2)) {
			return "AddressLine2 is required";
		}
		if (StringUtils.isBlank(city)) {
			return "City Name is required";
		}
		if (StringUtils.isBlank(state)) {
			return "Please select the state";
		}
		if (StringUtils.isBlank(country)) {
			return "Please choose the country";
		}
		if (StringUtils.isBlank(postalCode)) {
			return "Zipcode is required";
		}
		if (StringUtils.isBlank(email)) {
			return "email is required";
		}
		if (StringUtils.isBlank(phoneNumber)) {
			return "Phone Number is required";
		}
		if (StringUtils.isBlank(loanAmount)) {
			return "Loan Amount is must";
		}
		if (StringUtils.isBlank(annualSalary)) {
			return "Annual Salart is must";
		}

		return null;
	}

}
