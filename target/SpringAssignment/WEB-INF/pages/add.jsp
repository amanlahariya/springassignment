<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<form action="addact" method="post">
			<table>

				<c:set var="deptmap" value="${lists[0]}" scope="page" />
				<c:set var="techmap" value="${lists[1]}" scope="page" />
				<c:set var="managermap" value="${lists[2]}" scope="page" />
				<c:set var="projmap" value="${lists[3]}" scope="page" />
				<c:if test="${not empty lists}">

					<ul>

						<tr>
							<td>Employee ID:</td>
							<td><input type="text" name="employeeId"
								value="${listValue.employeeId}" /></td>
						</tr>
						<tr>
							<td>Employee Name:</td>
							<td><input type="text" name="employeeName"
								value="${listValue.employeeName}" /></td>
						</tr>

						<tr>
							<td>Department:</td>
							<td><select name="department">

									<c:forEach var="entry" items="${deptmap}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>
						<tr>
							<td>Technology :</td>
							<td><select name="technology">

									<c:forEach var="entry" items="${techmap}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>

						<tr>
							<td>Project :</td>
							<td><select name="project">

									<c:forEach var="entry" items="${projmap}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>

						<tr>
							<td>Manager :</td>
							<td><select name="manager">

									<c:forEach var="entry" items="${managermap}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>




						<tr>
							<td></td>
							<td><a href="home">Go Back</a><input type="submit"
								name="submit" value="Submit"></td>
						</tr>
						
					</ul>
				</c:if>
			</table>
		</form>
		<a href="https://www.facebook.com/amanlahariya08">©Aman Lahariya</a>

	</div>
</body>
</html>