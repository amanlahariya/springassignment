<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript">
	function show_alert() {
		alert("xxxxxx");
	}
</script>
</head>
<body>
	<div align="center">
		<table border="2">
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Department</th>
				<th>Technology</th>
				<th>Manager</th>
				<th colspan="3">Action</th>
			<tr>
				<c:if test="${not empty lists}">

					<ul>
						<c:forEach var="listValue" items="${lists}">
							<tr>
								<td>${listValue.employeeId}</td>
								<td>${listValue.employeeName}</td>
								<td>${listValue.department}</td>
								<td>${listValue.technology}</td>
								<td>${listValue.manager}</td>
								<td><a href="view?id=${listValue.employeeId}">View</a></td>
								<td><a href="edit?id=${listValue.employeeId}">Edit</a></td>
								<td><a href="delete?id=${listValue.employeeId}"
									onclick="return confirm('Are you sure you want to delete?');">Delete</a></td>
							</tr>

						</c:forEach>
					</ul>
				
				</c:if>
		</table>
		<a href="https://www.facebook.com/amanlahariya08">©Aman Lahariya</a>
	</div>
</body>
</html>