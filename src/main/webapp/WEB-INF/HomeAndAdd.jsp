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


<div style="display:flex;">
	<div style="margin:50px;" >
	
		<h1>Create New Dojo</h1>
		<form:form action="/newDojo" method="post" modelAttribute="dojo">
					<p>
						<form:label path="name">Dojo Name</form:label>
						<form:errors path="name" class="text-danger"/>
						<form:input type="text" path="name" />
					</p>
						
					<p>
						<input type=submit value="Submit"/>
					</p>
					
					
		</form:form>
	
	
	
	</div>
	
	<div>
	<h1>Assign new Ninja to a Dojo</h1>
		<form:form action="/newNinja" method="post" modelAttribute="ninja">
			<form:label path="dojo">Select Dojo</form:label>
			<form:select path="dojo">
					<form:option value="" path="dojo"> </form:option>
				<c:forEach var="dojo" items="${dojos}">
					<form:option value="${dojo.id}" path="dojo">
						<c:out value="${dojo.name}"></c:out>
					</form:option>
				</c:forEach>
			</form:select>
			<p>
					<form:label path="firstName">First Name</form:label>
					<form:errors path="firstName" class="text-danger"/>
					<form:input path="firstName" />
			</p>
			<p>
					<form:label path="lastName">Last Name</form:label>
					<form:errors path="lastName" class="text-danger"/>
					<form:input path="lastName" />
			</p>
			<p>
					<form:label path="age">Age</form:label>
					<form:errors path="age" class="text-danger"/>
					<form:input type="number" path="age" />
			</p>
			<p>
						<input type=submit value="Submit"/>
					</p>
		</form:form>
	
	</div>
	
</div>
	
	
	
	
<div>
<h1>List of existing Dojos DOES NOT DELETE ASSOCIATED NINJAS YET</h1>
<c:forEach var="dojo" items="${dojos}">
	<p>
			<form action="/delete/dojo/${dojo.id}" method="post">
			<a href="http://localhost:8080/dojo/show/${dojo.id }"><c:out value="${dojo.name}"/></a>
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</p>
	
</c:forEach>


</div>




	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>