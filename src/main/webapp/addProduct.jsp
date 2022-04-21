<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Product</title>
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
			<div class="wrap-login100 p-l-110 p-r-110 p-t-25 p-b-33">
				<form class="login100-form validate-form flex-sb flex-w"
					action="./AddProduct?action=show" method="post">
					<h2>Fill in the details to add a new product</h2>
					<div class="w-full p-t-25">
						<a href='ReadAddProduct?action=update' class="txt2 bo1"> Update an existing
							product </a>
					</div>


					<input class="input100" type="hidden" name="deviceId"> <span
						class="focus-input100"></span>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> Device Name </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Fullname is required">
						<input class="input100" type="text" name="deviceName"> <span
							class="focus-input100"></span>
					</div>

					<div class="p-t-31 p-b-9">
						<span class="txt1">Model</span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Model is required">
						<input class="input100" type="text" name="model"> <span
							class="focus-input100"></span>
					</div>

					<div class="p-t-31 p-b-9">
						<span class="txt1">Price </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Price is required">
						<input class="input100" type="text" name="price"> <span
							class="focus-input100"></span>
					</div>

					<div class="p-t-31 p-b-9">
						<span class="txt1"> Description </span>
					</div>
					<div class="wrap-input100 validate-input"
						data-validate="Description is required">
						<input class="input100" type="text" name="description"> <span
							class="focus-input100"></span>
					</div>

					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">Add Product</button>
					</div>




				</form>
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