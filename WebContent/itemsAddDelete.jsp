<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>leave Master Entry - Struts2 Hibernate Example</title>
</head>
<body>

	<h1>Add / Delete / List leave</h1>
	<s:actionerror />

	<s:form action="add" method="post">
		<s:textfield name="leave.NAME" label="Name" />
		<s:textfield name="leave.Type_of_leave" label="Type" />
		<s:textfield name="leave.From_date" label="From" />
		<s:textfield name="leave.To_date" label="To" />
		<s:textfield name="leave.Status" label="Status" />

		<s:submit value="Add leave" align="center" />
	</s:form>

	<s:form action="list" method="post">
		<s:submit value="List leaves" align="center" />
	</s:form>

	<h2>leaves in Master</h2>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>From</th>
			<th>To</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<s:iterator value="leaveList" var="leaves">
			<tr>
				<td><s:property value="Id"/></td>
				<td><s:property value="NAME"/></td>
				<td><s:property value="Type_of_leave"/></td>
				<td><s:property value="From_date"/></td>
				<td><s:property value="To_date"/></td>
				<td><s:property value="Status"/></td>
				<td><a href="delete?id=<s:property value="Id"/>">delete</a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>