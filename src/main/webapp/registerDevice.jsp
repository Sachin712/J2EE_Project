<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register Device</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">

			<div class="wrap-login100 p-l-25 p-r-25 p-t-20 p-b-33">
				<div class="container">
					<div class="row">
						<div class="col h2">Register Device</div>
						<div class="col">
							<form action="entry.jsp">
								<div class="container">
									<button type="submit" class="btn btn-dark float-right">Logout</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<form class="login100-form validate-form flex-sb flex-w"
					action="./RegisterDevice" method="post">

					<div class="p-t-31 p-b-9">
						<span class="txt1"> Serial ID </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Serial ID is required">
						<input class="input100" type="text" name="deviceId"> <span
							class="focus-input100"></span>
					</div>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> Login ID (username)</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Login ID is required">
						<input class="input100" type="text" name="loginId"
							value="${param.username}"> <span class="focus-input100"></span>
					</div>

					<div class="p-t-13 p-b-9">
						<span class="txt1"> Product Name </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Product Name is required">
						<select class="input100" name="deviceName">
							<c:forEach items="${listDevice}" var="device">
								<option value="${device.deviceName}">${device.deviceName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> Purchase Date </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Purchase Date is required">
						<input class="input100" type="date" name="purchaseDate"> <span
							class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">Register Device</button>
					</div>


				</form>
				<div class="p-t-31 p-b-9">
					<span class="txt1"><a
						href="./ReadDevice?username=${param.username}" class="link-dark">See
							all Registered Devices</a></span>
				</div>
			</div>

		</div>

	</div>

	<div id="dropDownSelect1"></div>
	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>