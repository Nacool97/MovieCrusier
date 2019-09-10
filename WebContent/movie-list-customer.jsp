<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="style/style.css">

</head>

<body>

<header>Movie Cruiser
<img src = "images/img.png" alt = "image_logo" />
<nav>
<a class="a2" href="/Servlet-MovieCruiser/ShowMovieListCustomer"><u>Movies</u></a>
<a class="a1" href="/Servlet-MovieCruiser/ShowFavourite"><u>Favourites</a></u>
</nav>
</header>
<div> 


<h2>Movies</h2>

<c:if test="${fav==true}">
<center><p class="green">Item added to Favourites Successfully</p></center>
</c:if>
<table cellpadding="4">
		<tr>
		<td width="40%"><b>Title</b></b></td>
		<td align="right"><b>Box Office</b></td>
		<td><b><center>Genre</b></center></td>
		<td><b><center>Has Teaser</b></center></td>
		<td><b><center>Action</b></center></td>
		</tr>
	<c:forEach items="${x}" var="list">
	<tr><td>${list.title}</td>
	<td>${list.boxOffice}</td>
	<td>${list.genre}</td>
	<c:if test="${list.isHasTeaser()==true}">
	<td>Yes</td>
	</c:if>
	<c:if test="${list.isHasTeaser()==false}">
	<td>No</td>
	</c:if>
	<c:if test="${list.active}==true">
	<td> Yes </td>
	</c:if>
	<c:if test="${list.active}==false">
	<td> No </td>
	</c:if>
	<td><a href="/Servlet-MovieCruiser/AddToFavourite?id=${list.id}">Add To Favourites</a></td>
	</c:forEach>		
	</table></div>
<footer>
Copyright &copy; 2019 
</footer>
</body>




</html>