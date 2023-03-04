<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><h1>Result </h1></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h1> The parking details :</h1>
<br>
<table border="2">
<tr>
<td> Vehicle NO</td>
<td> Owner's Name</td>
<td> From:Date </td>
<td> From:Time</td>
<td> To:Date </td>
<td> To:Time </td>
</tr>
<tr> 
<td>${vehicle.vehicle_no }</td>
<td>${vehicle.amount }</td>
<td>${vehicle.date_from }</td>
<td>${vehicle.from_time }</td>
<td>${vehicle.date_from }</td>
<td>${vehicle.to_time }</td>
<td>${vehicle.owner_name }</td>
</table>
<a href="/home">Home</a> 
</body>
</html>