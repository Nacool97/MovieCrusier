<DOCTYPE! html>
<head>
<link rel="stylesheet" href="style/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<header>Movie Cruiser
<img src = "images/img.png" alt = "image_logo" />
<nav >
<a class="a2" href="/Servlet-MovieCruiser/ShowMovieListAdmin"><u>Movies</u></a>
<a class="a1" ></a></nav>
</header>
<form name="editMovie" action="EditMovie?id=${x.id}" method="post">
<div>
<h2>Edit Movie </h2>
<table class="Table">
<tr><td><label for="name">Title</label></td></tr>
<tr><td><input type="text" name="title" size="95" id="name" value="<c:out value="${x.title}"/>"/></td></tr>
</table>
<table class="Table" width="600">
<tr><td><label for="price">Box Office ($)</td><td>Active</td><td><label for="DOL">Date of Launch</label></td><td>Genre</td></tr>
<tr><td><input type="text" name="price" id="price" style="text-align:right" value="<c:out value="${x.boxOffice}"/>"/></td> 
<td class="radio"><input type="radio" name="active" value="true" id="yes" <c:if test="${x.active==true}">checked</c:if>/><label for="yes">Yes</label><input type="radio" name="active" value="false" id="no" <c:if test="${x.active==false }">checked</c:if>/><label for="no">No</label></td>
<td>
<fmt:formatDate pattern="dd/MM/YYYY" value="${x.dateOfLaunch}" var="date"/>
<input type="text" name="dateOfLaunch" id="DOL" value="<c:out value="${date}"/>"/></td>
<td><select name="genre">
<option value="Science Fiction" ${x.genre.equals("Science Fiction")}?selected:" ">Science Fiction</option>
<option value="Superhero" ${x.genre.equals("Superhero")}?selected:" ">Superhero</option>
<option value="Romance" ${x.genre.equals("Romance")}?selected:" ">Romance</option>
<option value="Comedy" ${x.genre.equals("Comedy")}?selected:" ">Comedy</option>
<option value="Adventure" ${x.genre.equals("Adventure")}?selected:" ">Adventure</option>
<option value="Thriller" ${x.genre.equals("Thriller")}?selected:" ">Thriller</option>
</select></td></tr>

<tr><td><br><input type="checkbox" value="true" name="HasTeaser" style="width:15; height:15" id="FD" <c:if test="${x.isHasTeaser()==true}">checked</c:if>/> <label for="FD"></label></label>Has Teaser</label></td></tr>
<td>
<br>
<input type="submit" value="Save" class="button" name="save" onSubmit="valid()"></input>
</td>
</table>

</div>
<footer>
Copyright &copy; 2019 
</footer>
</form>
</body>
</html>

