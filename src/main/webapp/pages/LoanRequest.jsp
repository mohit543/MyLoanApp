<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
${errorMessage}
</div>


	<div class="container">
		<div class="row">
			<div class="col-md-10">
				<h1>Welcome to the Mohit Mortgage</h1>
				<h2>Loan Application Form</h2>
				<p>Please complete our quick and easy form below to start your
					application.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-10">
				<h3>Personal Information</h3>
				
		<form action="/MyLoanApp/loanRequest" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>

			<tr>
				<td>Date of birth:</td>
				<td><input type="date" name="dateOfBirth"></td>
			</tr>
			<tr>
				<td>SSN:</td>
				<td><input type="password" name="ssn"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="addressLine1"></td>
				<td><input type="text" name = "addressLine2"></td>
			</tr>

			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"></td>
			</tr>
			<tr>
				<td>Zipcode:</td>
				<td><input type="text" name="postalCode"></td>
			</tr>
			<tr>
				<td>Phone Number:</td>
				<td><input type="text" name="phoneNumber"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
            <tr>
				<td>loan Amount:</td>
				<td><input type="number" name="loanAmount" value='${request.parm.loanAmount}'></td>
			</tr>
			<tr>
				<td>Annual Salary:</td>
				<td><input type="number" name="annualSalary"></td>
			</tr>

			<tr>
				<td colspan="1" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>
	

</body>
</html>