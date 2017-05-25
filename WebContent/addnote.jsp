<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.notemaker.model.Users"%>
<%@page import="com.notemaker.model.Note"%>
<%@page import="com.notemaker.service.NoteService"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodanie notatki</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</style>
</head>

<body>
	<div id="menu">
		<ul>
			<li><a href="home.jsp">Konto</a></li>
			<li><a href="note.jsp">Notatki</a></li>
			<li><a href="addnote.jsp">Dodaj</a></li>
			<li><a href="logout.jsp">Wyloguj</a></li>

			</nav>
	</div>
	<div id="container">

		<h3>Dodanie notatki</h3>
		<%
			Users user = (Users) session.getAttribute("user");
			if (user == null || user.equals(""))
				response.sendRedirect("403.jsp");
		%>
		<form action="NoteServlet" method="POST">
			<%
				String ifEdit = request.getParameter("edit");
				if (ifEdit == null) {
			%>
			<table align="center" cellpadding="10">
				<tr>
					<td>Tytuł</td>
					<td><input type="text" name="tittle" maxlength="30" /></td>
				</tr>
				<tr>
					<td>Treść</td>
					<td><input type="text" name="content" maxlength="500" /></td>
				</tr>
				<input type="hidden" name="username" value="<%=user.getUserId()%>" />
				<input type="hidden" name="edit" value="0" />

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Dodaj"> <input type="reset" value="Reset">
					</td>
				</tr>
			</table>
			<%
				} else {
					NoteService service = new NoteService();
					int id = Integer.parseInt((request.getParameter("idnote")));
					Note note = service.getNoteById(id);
			%>
			<table align="center" cellpadding="10">
				<tr>
					<td>Tytuł</td>
					<td><input type="text" name="tittle" maxlength="30"
						value=<%=note.getTitle()%> /></td>
				</tr>
				<tr>
					<td>Treść</td>
					<td><input type="text" name="content" maxlength="500"
						value=<%=note.getContent()%> /></td>
				</tr>
				<input type="hidden" name="username" value="<%=user.getUserId()%>" />
				<input type="hidden" name="noteid" value="<%=id%>" />
				<input type="hidden" name="edit" value="1" />
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Dodaj"> <input type="reset" value="Reset">
					</td>
				</tr>
			</table>
			<%
				}
			%>
		</form>
	</div>
</body>
</html>