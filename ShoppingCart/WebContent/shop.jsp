<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop</title>
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
 if(username == null) 
	 response.sendRedirect("login.jsp"); 
%>
<h1>Shopping Cart !</h1>
	<table>
		<form action="AddToCart" method="post">

			<th>Item Name</th>
			<th>Price</th>
			<th>Add to Cart</th>
			<tr>
				<td>Item1</td>
				<td>rs20</td>
				<td><input type="hidden" name="name" value="Item1">
					<input type="hidden" name="price" value="20"><input
					type="submit" value="Add to cart"></td>
			</tr>
		</form>
		<form action="AddToCart" method="post">
			<tr>
				<td>Item2</td>
				<td>rs40</td>
				<td><input type="hidden" name="name" value="Item2">
					<input type="hidden" name="price" value="40"><input
					type="submit" value="Add to cart"></td>
			</tr>
		</form>
		<form action="AddToCart" method="post">
			<tr>
				<td>Item3</td>
				<td>rs10</td>
				<td><input type="hidden" name="name" value="Item3">
					<input type="hidden" name="price" value="10"><input
					type="submit" value="Add to cart"></td>
			</tr>

		</form>
		<form action="AddToCart" method="post">
			<tr>
			<td>Item4</td>
			<td>rs20</td>
			<td><input type="hidden" name="name" value="Item4">
				<input type="hidden" name="price" value="20"><input
				type="submit" value="Add to cart"></td>
		</tr>
		</form>
		
		<form action="AddToCart" method="post">
			<tr>
				<td>Item5</td>
				<td>rs40</td>
				<td><input type="hidden" name="name" value="Item5">
					<input type="hidden" name="price" value="40"><input
					type="submit" value="Add to cart"></td>
			</tr>
		</form>
		
		<form action="AddToCart" method="post">
			<tr>
				<td>Item6</td>
				<td>rs10</td>
				<td><input type="hidden" name="name" value="Item6">
					<input type="hidden" name="price" value="10"><input
					type="submit" value="Add to cart"></td>
			</tr>

		</form>
	</table>
	<form method="post" action="/LogoutServlet">
		<input type="submit" value="LOGOUT">
	</form>
</body>
</html>