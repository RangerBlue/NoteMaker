<%@page import="java.util.List"%>
<%@page import="com.notemaker.service.LoginService"%>
<%@page import="com.notemaker.service.NoteService"%>
<%@page import="java.util.Date"%>
<%@page import="com.notemaker.model.Note"%>
<%@page import="com.notemaker.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Notatki</title>
</head>
<body>
	<center>
		<div id="menu">
			<ul>
				<li><a href="home.jsp">Konto</a></li>
				<li><a href="note.jsp">Notatki</a></li>
				<li><a href="addnote.jsp">Dodaj</a></li>
				<li><a href="logout.jsp">Wyloguj</a></li>

				</nav>
		</div>
		<div id="container">
			<h4>Panel notatek</h4>
			<%=new Date()%></br>
			<%
				Users user = (Users) session.getAttribute("user");
				if (user == null || user.equals(""))
					response.sendRedirect("403.jsp");
			%>
			<b>Witaj <%=user.getFirstName() + " " + user.getUserId() + " " + user.getLastName()%></b>
			</p>

			<%
				NoteService noteService = new NoteService();
				List<Note> list = noteService.getListOfNotes(user);
				for (Note u : list) {
			%>
			<table>
				<tbody>
					<tr>
						<td>Tytuł</td>
						<td><%=u.getTitle()%></td>
					</tr>
					<tr>
						<td>Treść</td>
						<td><%=u.getContent()%></td>
					</tr>
					<tr>
						<td>Data</td>
						<td><%=u.getPublishedString()%></td>
					</tr>
					<tr>
						<td>Autor</td>
						<td><%=u.getUser_id()%></td>
					</tr>
					<tr>
						<td colspan="2">
							<form method="post" action="DeleteNoteServlet">
								<input type="hidden" name="idnote" value="<%=u.getId()%>">
								<input type="submit" value="Usuń" />
							</form>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<form method="post" action="addnote.jsp">
								<input type="hidden" name="idnote" value="<%=u.getId()%>">
								<input type="hidden" name="edit" value="true"> <input
									type="submit" value="Edytuj" />
							</form>
						</td>
					</tr>
				<tbody>
			</table>
			<%
				}
			%>

			<br />
			</di
				v>
	</center>
</body>
</html>
