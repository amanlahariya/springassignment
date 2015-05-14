<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<div align="center">
		<form action="search" method="post">
			<table>

				

					<ul>

						<tr>
							<td>Employee ID:</td>
							<td><input type="text" name="employeeId"
								 /></td>
						</tr>
						<tr>
							<td>Employee Name:</td>
							<td><input type="text" name="employeeName"
								/></td>
						</tr>

						<tr>
							<td>Department:</td>
							<td><select name="department">
                                      <option></option>
									<c:forEach var="entry" items="${deptlist}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>
						<tr>
							<td>Technology :</td>
							<td><select name="technology">
									<option></option>
									<c:forEach var="entry" items="${techlist}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>


						<tr>
							<td>Manager :</td>
							<td><select name="manager">
									<option></option>
									<c:forEach var="entry" items="${managerlist}">
										<option value="${entry.value}">${entry.value}</option>

									</c:forEach>

							</select></td>
						</tr>




						<tr>
							<td></td>
							<td><input type="submit"
								name="submit" value="Search"><a href="add">Add employee</a></td>
						</tr>
						
					</ul>
				
			</table>
		</form>
		<a href="https://www.facebook.com/amanlahariya08">©Aman Lahariya</a>

	</div>
</body>
</html>