<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--- ... --->
<h1><c:out value="${dojo.name}"/> Roster</h1>
<table class="table">
    <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
    </thead>
    <tbody>
    
    
    <c:forEach var="ninja" items="${ninjas}">
    
    
        <tr>
            <td><c:out value="${ninja.firstName}"/></td>
           	<td><c:out value="${ninja.lastName}"/></td>
            <td><c:out value="${ninja.age}"/></td>
            
               
        </tr>
        
        
    </c:forEach>
        
        
    </tbody>
</table>

<p><a href="http://localhost:8080">Return home</a></p>
</body>
</html>