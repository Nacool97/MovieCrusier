<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<html>
<head><link rel="stylesheet" href="style/style.css"> </head>
<body>
<header> Movie Cruiser
<img src = "images/img.png" alt = "image_logo" />
<nav>
<a class = "a2" href="/Servlet-MovieCruiser/ShowMovieListCustomer"><u>Movies</u></a>
<a class = "a1" href="/Servlet-MovieCruiser/ShowFavourite" ><u>Favourites</a></u>
</nav>
</header>

<div>
<h2> Favourites </h2>
<c:if test="${rm==true}">
<center><p class="green">Movie removed from Favourites successfully</p></center> 
</c:if>
<table cellpadding="4">
<tr>
<td width="40%"> <b> Title </b> </td>
<td align="right" > <b> Box Office </b> </td> 
<td > <b><center> Genre </center></b> </td>
</tr>
<c:forEach items="${x}" var="list">
<tr>
<td>${list.title}</td>
<td>${list.boxOffice}</td>
<td>${list.genre}</td>
<td><a href="/Servlet-MovieCruiser/RemoveFavourite?id=${list.id}">Remove</a></td>
</tr>
</c:forEach>
<tr>
<td></td>
<td>Number of movies :<c:out value="${count1}"></c:out></td>
</tr>
</table>

</div>
<footer>
Copyright &copy; 2019 
</footer>
</body>
</html>
