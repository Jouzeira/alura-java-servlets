<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkNovaEmpresa"/>
<c:url value="/entrada" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<form action="${linkEntrada}" method="post">
	
        Nome: <input type="text" name="nome" />
        <br/>
        Data Abertura: <input type="text" name="data" />
        <br/>
        <input type="hidden" name="acao" value="novaEmpresa" />
        
        <input type="submit" />

    </form>
</body>
</html>