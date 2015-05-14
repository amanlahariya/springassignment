<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<table border="1">

			<c:if test="${not empty lists}">

				<ul>
					<c:forEach var="listValue" items="${lists}">
						<tr>
							<td>Employee Id:</td>
							<td>${listValue.employeeId}</td>
						</tr>
						<tr>
							<td>Employee Name:</td>
							<td>${listValue.employeeName}</td>
						</tr>
						<tr>
							<td>Employee Department:</td>
							<td>${listValue.department}</td>
						</tr>
						<tr>
							<td>Employee Technology:</td>
							<td>${listValue.technology}</td>
						</tr>
						<tr>
							<td>Employee's Manager:</td>
							<td>${listValue.manager}</td>
						</tr>

					</c:forEach>
				</ul>

			</c:if>
		</table>
		<a href="home">Go to home</a>
		<a href="https://www.facebook.com/amanlahariya08">©Aman Lahariya</a>
	</div>
</body>
</html>