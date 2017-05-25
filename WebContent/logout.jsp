<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.notemaker.model.Users"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Wylogowanie</title>
</head>
<body>
	<%
		Users user = (Users) session.getAttribute("user");
		if (user == null || user.equals(""))
			response.sendRedirect("403.jsp");
		session.removeAttribute("userId");
		session.removeAttribute("password");
		session.invalidate();
	%>
	<center>
		<h1>Udało ci się wylogować</h1>
		Zalgouj się ponownie <a href="login.jsp">Kliknij</a>.
	</center>
</body>
</html>