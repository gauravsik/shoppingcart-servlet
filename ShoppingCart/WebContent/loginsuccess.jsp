<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body>
<%
String username = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("username"))
		username = cookie.getValue();
}
}
 if(username == null) response.sendRedirect("login.jsp"); 
 else
	 out.println("Hello " + username);
%>
<form method="post" action="shop.jsp">
<input type="submit"  value="CONTINUE">
</form>
</body>
</html>