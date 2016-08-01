package com.bitwise.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        HttpSession session = request.getSession();
	        Cart shoppingCart;
	        shoppingCart = (Cart) session.getAttribute("Cart");
	        if(shoppingCart == null){
	          shoppingCart = new Cart();
	          session.setAttribute("Cart", shoppingCart);
	        }
	        String name = request.getParameter("name");
	        Integer price = Integer.parseInt(request.getParameter("price"));
	        shoppingCart.addToCart(name, price);
	        session.setAttribute("Cart", shoppingCart);
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>result</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Item successfully added to cart </h1>");
	            out.println("<form action='shop.jsp'>Add more Item to cart<br><input type='submit' value='Add More'></form>");
	            out.println("<hr>");
	            out.println("<h2>Cart</h2>");
	            HashMap<String, Integer> items = shoppingCart.getCartItems();
	             
	           for(String key: items.keySet()){
	                out.println("<form action='DeleteFromCart' method='post'>"
	                		+ "<input type='hidden'"+ " name='name' value='"+key+"'>"
	                				+ "<tr>"
	                				+ "<td>"+key+""
	                				+ "</td>"
	                				+ "<td>"
	                				+"rs"+items.get(key)+""
	                				+ "</td>"
	                				+ "<td>"
	                				+ "<input type='submit' value='Delete'>"
	                				+ "</td>"
	                				+ "</tr>"
	                				+ "</form>");
	            }
	            out.println("<table>");
	            out.println("</body>");
	            out.println("</html>");
	            
	          
	        }
	}
}