<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: white;
}

img {
	width: 200px;
	height: 200px;
}

h1 {
	text-align: center;
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
			<a class="nav-link" href="#About" rel="internal"><i class="fa fa-home"></i>About</a> 
			<a class="nav-link" href="#Log Out" rel="internal"><i class="fa fa-user-plus"></i>Log Out</a> 
			<a class="nav-link" href="#Contact us" rel="internal"><i class="fa fa-phone"></i>Contact Us</a>
		</nav>
	</div>
	<img src="./images/fantasia.jpg">
	<img src="./images/marcjacobsdaisy.jpg">
	<img src="./images/bombshellvictoriassecret.jpg">
	<img src="./images/chanelchance.jpg">
	<img src="./images/cocomademoiselle.jpg">
	<img src="./images/blacklslexces pacorabanne.jpg">
	<img src="./images/jadoredior.jpg">
	<img src="./images/missdior.jpg">
	<img src="./images/no5.jpg">
	<img src="./images/opium.jpg">
	<img src="./images/gucci.jpg">
	<img src="./images/versace.jpg">
	<div>${message}</div>
	<br />

	<table>
		<tr>
			<th>Edit</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
			<th>Volume</th>
			<th>Year Released</th>
			<th>Reviews
		</tr>
		<c:forEach items="${allPerfumes}" var="perfume">
			<tr>
				<td><a href="EditPerfume/${perfume.perfumeId}">Edit Perfume</a>
				<td>${perfume.name}</td>
				<td>${perfume.price}</td>
				<td>${perfume.description}</td>
				<td>${perfume.volume}</td>
				<td>${perfume.yearReleased}</td>
				<td>${perfume.yearReleased}</td>
				<td><a href="ReviewsPerPerfume/${perfume.perfumeId}">See
						reviews</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="AddPerfume">Add a new Perfume</a>
	<br />
	<img src="./images/fantasia.jpg">
	<img src="./images/marcjacobsdaisy.jpg">
	<img src="./images/bombshellvictoriassecret.jpg">
	<img src="./images/chanelchance.jpg">
	<img src="./images/cocomademoiselle.jpg">
	<img src="./images/blacklslexces pacorabanne.jpg">
	<img src="./images/jadoredior.jpg">
	<img src="./images/missdior.jpg">
	<img src="./images/no5.jpg">
	<img src="./images/opium.jpg">
	<img src="./images/gucci.jpg">
	<img src="./images/versace.jpg">
</body>
</html>