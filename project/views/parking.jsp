<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h1 style="text-align:center">Please Enter the parking Details</h1>
<div class="container min-vh-100 d-flex justify-content-center align-items-center">
<br>
<form action="/proceesvehicleform" method="POST">
	<div class="form-group mb-3">
		<label>Vehicle No:</label>
		<input type="text"  class="form-control" name="vehicle_no">
	</div>	
	<div class="form-group mb-3">	
		<label>Owner's Name:</label>
		<input type="text"  class="form-control" name="owner_name">		
	</div>
	<div class="form-group mb-3">	
		Date and time <br>
		<label>From:</label>
		<input type="date" class="form-control" name="date_from">
		<input type="time" class="form-control" name="from_time">
	</div>
	<div class="form-group mb-3">		
		<label>To:</label>
		<input type="date" class="form-control" name="date_to">
		<input type="time" class="form-control" name="to_time">
	</div>
	
	<div>
		<input type="submit"  class="btn btn-primary form-control"/>
	</div>
</form>
</div>	
</body>
</html>