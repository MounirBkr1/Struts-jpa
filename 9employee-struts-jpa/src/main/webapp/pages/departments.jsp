<%@page import="ma.course.web.form.DepartmentForm"%>
<%@page import="ma.course.domain.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des départements</title>
</head>
<body>
<table border ="1" width="500" align="center">
<tr bgcolor="00FF7F">
<th>Id</th>
<th>Nom</th>
<th>Détails</th>
</tr>
<jsp:useBean id="departments" beanName="departments" scope="request" 
             type="java.util.List<ma.course.web.form.DepartmentForm>"/>
<%
for(DepartmentForm department : departments){%>
	<tr>	
		<td><%=department.getId() %></td>
		<td><%=department.getName() %></td>
		<td>
			<s:url action="Employee" includeParams="get" var="employeeUrl">
		        <s:param name="employee.department.id"><%=department.getId() %></s:param>
		    </s:url>
		    <s:a href="%{#employeeUrl}">Détails</s:a>
		</td>
	</tr>
<%
}
%>
</table>
<br/><br/>
<a href="<%=getServletContext().getContextPath()%>">Accueil</a>
</body>
</html>