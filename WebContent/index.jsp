<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="process.jsp" method="get">
		<table>
			<tr>
				<td>What version of the Knight's Tour would you like to run?</td>
				<td>
					<select name="version">
						<option value="simpleVersion">Non-intelligent</option>
						<option value="heuristics">Accessibility Heuristics</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>How many times would you like to run it (enter a number in decimal format such as 1,99,234,etc...)?</td>
				<td><input name="numberOfRuns" type="text" required></td>
			</tr>
			<tr>
				<td>Which row to start at(enter a value from 0-9)?</td>
				<td><input name="row" type="number" min="0" max="7" required></td>
			</tr>
			<tr>
				<td>Which column to start at(enter a value from 0-9)?</td>
				<td><input name="column" type="number" min="0" max="7" required></td>
			</tr>
		</table>
		<input type="submit" value="submit">
	</form>
</body>
</html>

