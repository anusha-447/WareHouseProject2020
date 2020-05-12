<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="UserMenu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
</HEAD>
<meta charset="ISO-8859-1">
<title>Sale Order</title>
</head>
<body>
	<div class="container">
		<div class="card">
			<div
				class="card-header bg-primary text-center text-white text-uppercase">
				<h3>Welcome to Sale Order Register Page</h3>
			</div>
			<div class="card-body">
				<form:form action="" method="POST" modelAttribute="saleOrder">
					<div class="row">
						<div class="col-4">

							<label for="sorderCode">ORDER CODE</label>
						</div>
						<div class="col-4">
							<form:input path="sorderCode" class="form-control" />
						</div>
						<div class="col-4">
							<span id="codeError"></span>
						</div>
						<div class="col-4">
							<label for=RefNumber>REFERENCE NUMBER</label>
						</div>
						<div class="col-4">
							<form:input path="RefNumber" class="form-control" />
						</div>
						<div class="col-4">
							<span id="refError"></span>
						</div>
						<div class="col-4">
							<label for="stockMode">STACK MODE</label>
						</div>
						<div class="col-4">
							<form:radiobutton path="stockMode" id="stock1" value="GRADE" />
							GRADE
							<form:radiobutton path="stockMode" id="stock2" value="MARGIN" />
							MARGIN

						</div>
						<div class="col-4">
							<span id="modeError"></span>
						</div>
						<div class="col-4">
							<label for="stockSource">STACK SOURCE</label>
						</div>
						<div class="col-4">
							<form:input path="stockSource" class="form-control" />
						</div>
						<div class="col-4">
							<span id="stackError"></span>
						</div>
						<div class="col-4">
							<label for="defaultStatus">DEFAULT STATUS</label>
						</div>
						<div class="col-4">
							<form:input path="defaultStatus" class="form-control" />
						</div>
						<div class="col-4">
							<span id="statusError"></span>
						</div>
						<div class="col-4">
							<label for="sdescription">DESCRIPTION</label>
						</div>
						<div class="col-4">
							<form:input path="sdescription" class="form-control" />
						</div>
						<div class="col-4">
							<span id="desError"></span>
						</div>
					</div>
					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" id="register"
								class="btn btn-success" />
						</div>
					</div>
				</form:form>
			</div>

			<script>
				$(document)
						.ready(
								function() {

									//1. Hide Error section
									$("#desError").hide();
									$("#statusError").hide();
									$("#stackerror").hide();
									$("#modeError").hide();
									$("#refError").hide();
									$("#codeError").hide();

									//2. Define flag for error section
									var desError = false;
									var statusError = false;
									var stackerror = false;
									var modeError = false;
									var refError = false;
									var codeError = false;

									//3. Link with action/event
									$("#desError").keyup(function() {
										validate_des();
									});
									$("#statusError").keyup(function() {
										validate_status();
									});
									$("#refError").keyup(function() {
										alert("yes")
										validate_refNum();
									});
									$("#codeError").keyup(function() {
										validate_orderCode();
									});
									$("#modeError").keyup(function() {
										validate_stackmode();
									});
									$('input[type="radio"][name="stockMode"]')
											.change(function() {
												validate_stackmode();

											});
									function validate_userType() {
										var val = $('input[type="radio"][name="stockMode"]:checked').length;
										//if one radio button is selected then length=1 else length is zero
										if (val == 0) {
											$("#modeError").show();
											$("#modeError")
													.html(
															"Please choose <b>stack mode</b>");
											$("#modeError").css("color", "red");
											modeError = false;
										} else {
											$("#modeError").hide();
											modeError = true;
										}
										return modeError;
									}
									//radio button validation based on length

									//4. drfine one validation function
									function validate_stackmode() {

										var val = $("#modeError").val();
										if (val == '') {
											$("#modeError").show();
											$("#modeError").html(
													"Enter <b>stack mode</b>")
											$("#modeError").css("color", "red");
											desError = false;
										} else {
											$("#modeError").hide();
											modeError = true;
										}
										return modeError;
									}
									function validate_des() {

										var val = $("#desError").val();
										if (val == '') {
											$("#desError").show();
											$("#desError").html(
													"Enter <b>description</b>")
											$("#desError").css("color", "red");
											desError = false;
										} else {
											$("#desError").hide();
											desError = true;
										}
										return desError;
									}

									function validate_status() {

										var val = $("#statusError").val();
										if (val == '') {

											$("#statusError").show();
											$("#statusError")
													.html(
															"Enter <b>default status</b>")
											$("#statusError").css("color",
													"red");
											statusError = false;
										} else {
											$("#statusError").hide();
											statusError = true;
										}
										return statusError;
									}
									function validate_refNum() {
										alert("yes3")
										var val = $("#refError").val();
										if (val == '') {

											$("#refError").show();
											$("#refError")
													.html(
															"Enter <b>reference number</b>")
											$("#refError").css("color", "red");
											statusError = false;
										} else {
											$("#refError").hide();
											refError = true;
										}
										return refError;
									}
									function validate_des() {

										var val = $("#desError").val();
										if (val == '') {
											$("#desError").show();
											$("#desError").html(
													"Enter <b>description</b>")
											$("#desError").css("color", "red");
											desError = false;
										} else {
											$("#desError").hide();
											desError = true;
										}
										return desError;
									}

									function validate_orderCode() {

										var val = $("#codeError").val();
										if (val == '') {

											$("#codeError").show();
											$("#codeError").html(
													"Enter <b>order code</b>")
											$("#codeError").css("color", "red");
											codeError = false;
										} else {
											$("#codeError").hide();
											codeError = true;
										}
										return codeError;
									}
									// on click submit button
									$("#register").click(
											function() {
												//on click submit button
												//a. reset flags to false
												desError = false;
												statusError = false;
												refError = false;
												codeError = false;
												modeError = false;
												//b. call all validate function
												validate_des();
												validate_status();
												validate_refNum();
												validate_orderCode();
												validate_stackmode()
												//c. check if all are true then submit else dont
												if (desError && statusError
														&& refError
														&& codeError
														&& modeError) {
													return true;
												} else
													return false;
											});
								});
			</script>
		</div>
	</div>


</body>
</html>