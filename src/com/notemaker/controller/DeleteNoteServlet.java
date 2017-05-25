package com.notemaker.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notemaker.model.Note;
import com.notemaker.model.Users;
import com.notemaker.service.LoginService;
import com.notemaker.service.NoteService;

public class DeleteNoteServlet extends  HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 int id = Integer.parseInt((request.getParameter("idnote")));
			
	 try {	
		 NoteService noteService = new NoteService();
		 Note note = noteService.getNoteById(id);
		 boolean result = noteService.delete(note);		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Usuwanie notatki</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Notatka zosta³‚a usuniêta:</h1>");
			 out.println("Powrót<a href=note.jsp>Kliknij</a>");
		 }else{
			 out.println("<h1>Notatka nie zosta³‚a usuniêta:</h1>");
			 out.println("Powrót<a href=note.jsp>Kliknij</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 } finally {		
		 out.close();
	 }
}}
