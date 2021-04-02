<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit perfume</title>
<style type="text/css">
body {
	background-color: #ffe6ff
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
	<h1>Edit perfume</h1>
	<div>${message}</div>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/EditPerfumeSubmit"
		modelAttribute="perfume">
		<div>
			<sf:errors path="name" />
			<sf:label path="name">Name</sf:label>
			<sf:input path="name" type="text" required="required" />
		</div>
		<div>
			<sf:errors path="price" />
			<sf:label path="price">Price</sf:label>
			<sf:input path="price" type="number" required="required" />
		</div>
		<div>
			<sf:errors path="description" />
			<sf:label path="description">Description</sf:label>
			<sf:input path="description" type="text" required="required" />
		</div>
		<div>
			<sf:errors path="volume" />
			<sf:label path="volume">Volume</sf:label>
			<sf:input path="volume" type="number" required="required" />
		</div>
		<div>
			<sf:errors path="yearReleased" />
			<sf:label path="yearReleased">Year Released</sf:label>
			<sf:input path="yearReleased" type="number" required="required" />
		</div>
		<div>
			<sf:errors path="stores" />
			<sf:label path="stores">Stores</sf:label>
			<sf:select path="stores" items="${allStores}" multiple="multiple"
				itemLabel="location" required="required" />
		</div>
		<div>
			<sf:errors path="brand" />
			<sf:label path="brand">Brand</sf:label>
			<sf:select path="brand" items="${allBrands}" itemLabel="name"
				required="required" />
		</div>
		<sf:hidden path="perfumeId" value="${perfumeId}" />
		<div>
			<input type="submit" value="edit perfume" /> 
			<input type="submit"value="delete perfume" />
		</div>
	</sf:form>
</body>
</html>