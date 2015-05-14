<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Department</th>
				<th>Technology</th>
				<th>Manager</th>
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
							</tr>

						</c:forEach>
					</ul>
					

				</c:if>
		</table>
		Successfully updated<a href="home">Go to home</a>
		<a href="https://www.facebook.com/amanlahariya08">©Aman Lahariya</a>
	</div>
</body>
</html>