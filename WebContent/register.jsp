<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Rejestracja</title>
<style type="text/css">
h3 {
	font-family: Calibri;
	font-size: 22pt;
	font-style: normal;
	font-weight: bold;
	color: #333;
	text-align: center;
	text-decoration: underline
}

table {
	font-family: Calibri;
	color: white;
	font-size: 11pt;
	font-style: normal;
	width: 50%;
	text-align:;
	background-color: #333;
	border-collapse: collapse;
	border: 2px solid navy
}

table.inner {
	border: 0px
}
</style>
</head>

<body>
	<h3>Rejestracja</h3>
	<form action="RegisterServlet" method="POST">

		<table align="center" cellpadding="10">
			<tr>
				<td>Imię</td>
				<td><input type="text" name="firstName" maxlength="30" /></td>
			</tr>
			<tr>
				<td>Nazwisko</td>
				<td><input type="text" name="lastName" maxlength="30" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email" maxlength="100" /></td>
			</tr>

			<tr>
				<td>Login</td>
				<td><input type="text" name="userId" maxlength="100" /></td>
			</tr>
			<tr>
				<td>Hasło</td>
				<td><input type="password" name="password" maxlength="100" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Rejestruj"> <input type="reset" value="Wyczyść">
				</td>
			</tr>
		</table>

	</form>

</body>
</html>