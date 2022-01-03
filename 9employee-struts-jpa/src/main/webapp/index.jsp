<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des employés</title>
</head>
<body>

	<s:url action="Department" var="departmentUrl"/>
    <s:a href="%{#departmentUrl}">Liste des départements</s:a>
</body>
</html>