package com.bitwise.shoppingcart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {


    public LoginFilter() {
    }


	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("login filter started");
		
		String username = null; 
		String password = null;
				username = request.getParameter("username");
				password = request.getParameter("password");
		
		PrintWriter pw = response.getWriter();
		

		System.out.println("username : " + username + " password : " + password);
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		RegisteredUsers ru = new RegisteredUsers();
		
		if(username!=null && ru.getUsersData().containsKey(username)){
			if(ru.getUsersData().get(username).equals(password)){
				System.out.println("valid credentials (in if of if)");
				Cookie loginCookie = new Cookie("username" , username);
				loginCookie.setMaxAge(20);
				res.addCookie(loginCookie);
				chain.doFilter(request, response);		
			}
			else{
				pw.write("<font color=red><h1>Invalid Credentials!</h1></font>");
				System.out.println("invalid credentials (in else)");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		}
		else{
			pw.write("<font color=red><h1>Invalid Credentials</h1></font>");
			System.out.println("invalid credentials (in else)");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		pw.close();
		pw.flush();
		System.out.println("loginfilter ended");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
