package com.notemaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notemaker.model.Users;
import com.notemaker.service.RegisterService;


public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String firstName = request.getParameter("firstName");
	 String lastName = request.getParameter("lastName");
	 String email = request.getParameter("email");
	 String userId = request.getParameter("userId");
	 System.out.print("user "+userId);
	 String password = request.getParameter("password");
	 Users user = new Users(firstName,lastName, email,userId, password);
			
	 try {	
		 
		 RegisterService registerService = new RegisterService();
		 boolean result = registerService.register(user);		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Dzięujemy za rejestrację :</h1>");
			 out.println("Aby się zalogować: <a href=login.jsp>Kliknij</a>");
		 }else{
			 out.println("<h1>Rejestracja nieudana</h1>");
			 out.println("Spróbuj ponownie <a href=register.jsp>Kliknij</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 } finally {		
		 out.close();
	 }
}

}