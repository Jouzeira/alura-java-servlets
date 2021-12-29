<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/alteraEmpresa" var="linkAlteraEmpresa"/>
<c:url value="/entrada" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkEntrada}" method="post">
	
        Nome: <input type="text" name="nome" value="${empresa.nome}"/>
        <br/>
        Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
        <br/>
        <input type="hidden" name="id" value="${empresa.id}" />
        <input type="hidden" name="acao" value="alteraEmpresa" />
        <input type="submit" />

    </form>
</body>
</html>