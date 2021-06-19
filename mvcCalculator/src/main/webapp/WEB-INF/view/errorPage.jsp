<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p style="color:red;">
<%=request.getAttribute("error") %>
<jsp:include page="loginPage.jsp"></jsp:include>
</p>
</body>
</html>