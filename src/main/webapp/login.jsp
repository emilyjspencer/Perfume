<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login to Perfect Perfumes</title>
</head>
<body>
	<h1>Login here</h1>
	<form action="/LoginSubmit" method="post">
		<div>${message}</div>
		<div>
			<label for="username">user name</label> <input type="text"
				name="username" required="required" />
		</div>
		<div>
			<label for="password">password</label> <input type="password"
				name="password" required="required" />
		</div>
		<button type="submit">Login</button>
	</form>
</body>
</html>