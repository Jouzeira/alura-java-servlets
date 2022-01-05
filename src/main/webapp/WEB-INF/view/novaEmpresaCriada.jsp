<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>

</head>
<body>

	<c:import url="logout-parcial.jsp" />

	<c:if test="${not empty empresa }">
	
			Empresa <%out.println(nomeEmpresa);%> cadastrada com sucesso!
		</br>
			Empresa <%= nomeEmpresa %> cadastrada com sucesso!
		</br>
			Empresa ${ empresa } cadastrada com sucesso!
	
	</c:if>
	<c:if test="${empty empresa }">
		Nenhuma empresa cadastrada!
		<br />
		<c:forEach var="i" begin="1" end="10" step="2">
	       ${i} <br />
	     </c:forEach>
	</c:if>
</body>
</html>