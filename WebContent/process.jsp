<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
		String knightVersion = request.getParameter("version");
		int numOfRuns = Integer.parseInt(request.getParameter("numberOfRuns"));
		int rowStart = Integer.parseInt(request.getParameter("row"));
		int colStart = Integer.parseInt(request.getParameter("column"));
		
		
		request.getRequestDispatcher("KnightPicker").forward(request,response);
	%>
</body>
</html>