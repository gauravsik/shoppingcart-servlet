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


//@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("AddToCart").include(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		//doGet(request, response);
		  response.setContentType("text/html");
	        String name = request.getParameter("name");
	          HttpSession session = request.getSession();
	        Cart shoppingCart;
	        shoppingCart = (Cart) session.getAttribute("Cart");
	        shoppingCart.deleteFromCart(name);
	        session.setAttribute("cart", shoppingCart);
	         shoppingCart = (Cart) session.getAttribute("Cart");
	        try (PrintWriter out = response.getWriter()) {
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>DeleteItem</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            HashMap<String, Integer> items = shoppingCart.getCartItems();
	            out.println("<h1>Current Items In Cart</h1>");
	            
	            for(String key: items.keySet()){
	                out.println("<form action='DeleteFromCart' method='post'>"
	                		+ "<input type='hidden' name='name' value='"+key+"'>"
	                				+ "<tr><td>"+key+"</td>"
	                				+ "<td>"+"rs"
	                				+items.get(key)+"</td>"
	                				+ "<td><input type='submit' "
	                				+ "value='Delete'>"
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
