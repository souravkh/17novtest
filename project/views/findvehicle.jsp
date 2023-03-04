<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><h2> Enter the Vehicle details you want to find</h2></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container min-vh-100 d-flex justify-content-center align-items-center">
<br>
<form action="/findvehicleform" method="POST">
	<div class="form-group mb-3">
		<label>Vehicle No:</label>
		<input type="text"  class="form-control" name="vehicle_no">
	</div>	
	<div>
		<input type="submit"  class="btn btn-primary form-control"/>
	</div>
</form>
</div>		
</body>
</html>