package com.notemaker.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notemaker.model.Users;
import com.notemaker.service.LoginService;

import app.notemaker.security.Cipher;
import jdk.nashorn.internal.ir.RuntimeNode.Request;


public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	 String userId = request.getParameter("userId");	
	 String password = request.getParameter("password");
	 LoginService loginService = new LoginService();
	 try {
			password=Cipher.getEncodedString(password);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
	 boolean result = loginService.authenticateUser(userId, password);
	 Users user = loginService.getUserByUserId(userId);
	 if(result == true){
		 request.getSession().setAttribute("user", user);		
		 response.sendRedirect("home.jsp");
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
}
}