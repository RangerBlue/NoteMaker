<%@page import="java.util.List"%>
<%@page import="com.notemaker.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.notemaker.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Konto</title>
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
			<h1>Konto</h1>

			<%=new Date()%></br>
			<%
				Users user = (Users) session.getAttribute("user");
				if (user == null || user.equals(""))
					response.sendRedirect("403.jsp");
			%>

			</p>

			<table>
				<thead>
					<tr>
						<th>Login</th>
						<th>Imię</th>
						<th>Nazwisko</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<%
						LoginService loginService = new LoginService();
						List<Users> list = loginService.getListOfUsers(user);
						for (Users u : list) {
					%>
					<tr>
						<td><%=u.getUserId()%></td>
						<td><%=u.getFirstName()%></td>
						<td><%=u.getLastName()%></td>
						<td><%=u.getEmail()%></td>
					</tr>
					<%
						}
					%>
				
				<tbody>
			</table>
			<br />
		</div>
	</center>
</body>
</html>
