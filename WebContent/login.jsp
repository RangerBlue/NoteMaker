<%@page import="com.notemaker.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>

	<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<script>
	function validateForm() {
		var login = document.forms["myForm"]["userId"].value;
		var pass = document.forms["myForm"]["password"].value;
		if (login == "" || pass == "") {
			alert("Pola nie mogą być puste!");
			return false;
		}
	}
</script>
<body>
	<%
		Users user = (Users) session.getAttribute("user");
		if (!(user == null || user.equals("")))
			response.sendRedirect("home.jsp");
	%>
	<form name="myForm" method="post" action="LoginServlet"
		onsubmit="return validateForm()">
		<div id="login-box">
			<table>
				<tr>
					<td colspan="2"><H2>Logowanie</H2></td>
				</tr>
				<tr>
					<td colspan="2">Podaj swoje dane</td>
				</tr>
				<tr>
					<td><div id="login-box-name"">Login:</div></td>
					<td><div id="login-box-field"">
							<input name="userId" class="form-login" title="Username" value="" /></td>
					</div>
				</tr>
				<tr>
					<td>
						<div id="login-box-name">Hasło:</div>
					</td>
					<td>
						<div id="login-box-field">
							<input name="password" type="password" class="form-login"
								title="Password" value="" size="30" maxlength="48" />
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2"><span class="login-box-options"> Nowy użytkownik? <a href="register.jsp">Rejestracja</a>
					</span></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Login" /></td>
				</tr>
			</table>

		</div>


	</form>

</body>
</html>
