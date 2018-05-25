<%@page pageEncoding="UTF-8"%>  
<%@ page import="model.Equipamento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Equipamentos</title>
	</head>
	<body>
		<h3><a href="index.jsp">Home</a></h3>
		<% Equipamento eq = (Equipamento) request.getAttribute("equipamento"); %>
		Equipamento com ID:<% out.print(" "+eq.getId()); %> cadastrado
	</body>
</html>