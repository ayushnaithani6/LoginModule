<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("username") == null) {
			response.sendRedirect("loginForm.jsp");
		}
	
		String username = (String)session.getAttribute("username");
	%>
	
	welcome back <%= username %>.
	<br>
	<a href="videos.jsp">click here for videos </a>
	
	<form action="logoutController">
		<button> logout </button>
	</form>
	
</body>
</html>