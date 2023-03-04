<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<h1> The parking details :</h1>
<br>
<table class="table table-striped">
<thead>
<tr class="table-primary">
<td class="table-success"> Vehicle NO</td>
<td class="table-success"> Amount Paid</td>
<td class="table-success"> From:Date </td>
<td class="table-success"> From:Time</td>
<td class="table-success"> To:Date </td>
<td class="table-success"> To:Time </td>
<td class="table-success"> Owner's Name</td>
</tr>
</thead>
<c:forEach items="${vlist }" var="vehicle">
<tr> 
<td class="table-primary">${vehicle.vehicle_no }</td>
<td class="table-primary">${vehicle.amount }</td>
<td class="table-primary">${vehicle.date_from }</td>
<td class="table-primary">${vehicle.from_time }</td>
<td class="table-primary">${vehicle.date_to }</td>
<td class="table-primary">${vehicle.to_time }</td>
<td class="table-primary">${vehicle.owner_name }</td>
<td td class="table-primary">
<a href="searchvehicle/${vehicle.vehicle_no}">EDIT</a> 
<a href="deletevehicle/${vehicle.vehicle_no}">DELETE</a> 
</td>
</c:forEach>
</table>


</body>
</html>