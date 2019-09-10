<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<!doctype html>
<head>
	<link rel="stylesheet" href="style/style.css">
	
</head>
<body>

<header>Movie Cruiser <img src="images/img.png"/>
<nav>
<a class="a2"  href="/Servlet-MovieCruiser/ShowMovieListAdmin">Movies</a>
<a class="a1"></a>
</nav>
</header>
<div><h2>Menu items</h2><br>

	<table>
		<tr>
		<td width="30%"><b>Title</b></td>
		<td width=10% align="right"><b>Box Office</b></td>
		<td width =10%><b><center>Active</center></td>
		<td><b><center>Date of Launch</b></center></td>
		<td><b><center>Genre</b></center></td>
		<td><b><center>Has Teaser</b></center></td>
		<td><b><center>Action</b></center></td>
		</tr>
		
	
<c:forEach items="${x}"	 var="list">
<tr>
<td>${list.title }</td>
<td >${list.boxOffice }</td>
<c:if test="${list.active==true}">
<td align="center">Yes</td>
</c:if>
<c:if test="${list.active==false}">
<td align="center">No</td>
</c:if>
<td align="center"><fmt:formatDate pattern="dd/MM/YYYY" value="${list.dateOfLaunch }"/></td>
<td align="center">${list.genre }</td>
<c:if test="${list.isHasTeaser()==true}">
<td align="center">Yes</td>
</c:if>
<c:if test="${list.isHasTeaser()==false}">
<td align="center">No</td>
</c:if>
<td align="center"><a href="/Servlet-MovieCruiser/ShowEditMovie?id=${list.id}">Edit</a></td>
</tr>
</c:forEach>	
	</table>
</div>

<footer>
Copyright &copy; 2019 
</footer>

</body>
</html>