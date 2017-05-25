package com.notemaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notemaker.model.Note;
import com.notemaker.model.Users;
import com.notemaker.service.RegisterService;
import com.notemaker.service.LoginService;
import com.notemaker.service.NoteService;

public class NoteServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String tittle = request.getParameter("tittle");
	 String content = request.getParameter("content");
	 String username = request.getParameter("username");
	 String edit = request.getParameter("edit");
	 LoginService userService = new LoginService();
	 Users user = userService.getUserByUserId(username);
	 Note note = new Note(tittle,content, new Date(),username);
			
	 try {	
		 boolean result;
		 NoteService noteService = new NoteService();
		 if(edit.equals("0"))
			 result = noteService.save(note);
		 else{
			 Long noteId = Long.parseLong(request.getParameter("noteid"));
			 System.out.print("wartoœæ w noteservlet "+noteId);
			 Note noteUpdate = new Note(noteId, tittle,content, new Date(),username);
			 result = noteService.update(noteUpdate);	
		 }
				
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Notatka Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Notatka zosta³‚a dodana :</h1>");
			 out.println("Strona g³ó³wna <a href=login.jsp>Kliknij</a>");
		 }else{
			 out.println("<h1>Nie uda³‚o siê™ dodaæ notatki</h1>");
			 out.println("Spróbuj pownownie<a href=addnote.jsp>Click here</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 } finally {		
		 out.close();
	 }
}}
