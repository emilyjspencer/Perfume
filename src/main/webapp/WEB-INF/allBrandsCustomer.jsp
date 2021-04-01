<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All brands</title>
<style type="text/css">
body {
	background-color: #ffe6ff
}

h1 {
	text-align: center;
}

table {
	position: relative;
	left: 560px;
}

nav {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
}

a {
	font-size: 20px;
	margin: 20px;
	text-decoration: none;
	color: #95a5a6;
	font-family: roboto;
	border-bottom: 1px solid #52c9aa;
	transition: color 0.75s ease-in-out;
}

a:hover {
	color: #e974bc;
	border-bottom-color: #4d0730;
}

i {
	margin-right: 10px;
}

@media screen and (max-width: 600px) {
	nav {
		flex-direction: column;
		align-items: center;
		background: #cc8db4;
	}
	a {
		color: white;
	}
}

@media screen and (max-width: 920px) {
	nav {
		justify-content: center;
	}
	a {
		font-size: 26px;
	}
}

h1 {
	color: white;
	text-align: center;
	height: 200px;
	font-family: Dancing Script;
	font-size: 60px;
	padding: 10px;
	position: relative;
	top: 40px;
}

.banner {
	background-color: black;
}

h2 {
	text-align: center;
}

.form {
	text-align: center;
	position: relative;
	left: -0px;
	font-size: 16px;
}

button {
	color: black;
	background-color: white;
	border: solid #d1d1e0 2px;
	border-radius: 10px;
}

form {
	font-size: 16px;
}
</style>
</head>
<body>
	<div class="banner">
		<h1>Perfect Perfumes</h1>
		<div class="header"></div>
		<nav>
			<a class="nav-link" href="/" rel="internal"><i class="fa fa-home"></i>Home</a>
			<a class="nav-link" href="#About" rel="internal"><i
				class="fa fa-home"></i>About</a> <a class="nav-link" href="#Log out"
				rel="internal"><i class="fa fa-sign-in"></i>Log Out</a> <a
				class="nav-link" href="#Contact us" rel="internal"><i
				class="fa fa-phone"></i>Contact Us</a>
		</nav>
	</div>
	<h1>All brands</h1>
	<div>${message}</div>
	<table>
		<th>Name</th>
		<th>Year Founded</th>
		<c:forEach items="${allBrandsCustomer}" var="brand">
			<tr>
				<td>${brand.name}</td>
				<td>${brand.yearFounded}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>