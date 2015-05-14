<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<form action="editact" method="post">
			<table>
				

					<ul>
						<c:forEach items="${elist}" var="el">
							<tr>
								<td>Employee ID:</td>
								<td><input type="text" name="employeeId"
									value="${el.employeeId}" /><input type="hidden" name="oldeid" value="${EmpId}"></td>
							</tr>
							<tr>
								<td>Employee Name:</td>
								<td><input type="text" name="employeeName"
									value="${el.employeeName}" /></td>
							</tr>

							<tr>
								<td>Department:</td>
								<td><select name="department">
										<option value="${el.department}" selected>${el.department}</option>
										<c:forEach var="entry" items="${deptlist}">
											<option value="${entry.value}">${entry.value}</option>

										</c:forEach>

								</select></td>
							</tr>
							<tr>
								<td>Technology :</td>
								<td><select name="technology">
										<option value="${el.technology}" selected>${el.technology}</option>
										<c:forEach var="entry" items="${techlist}">
											<option value="${entry.value}">${entry.value}</option>

										</c:forEach>

								</select></td>
							</tr>

							<tr>
								<td>Manager :</td>
								<td><select name="manager">
										<option value="${el.manager}" selected>${el.manager}</option>
										<c:forEach var="entry" items="${managerlist}">
											<option value="${entry.value}">${entry.value}</option>

										</c:forEach>

								</select></td>
							</tr>



						<tr>
							<td></td>
							<td><input
								type="submit" name="submit" value="Submit"></td>
						</tr>
						</c:forEach>
						

					</ul>
				
			</table>
		</form>
		<a href="https://www.facebook.com/amanlahariya08">©Aman Lahariya</a>

	</div>
</body>
</html>