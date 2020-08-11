<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/mvcCrud/add" method=post>
	     <label>Id</label>:<input type="text" name="id"/><br/>
	     <label>Name</label>:<input type="text" name="name"/><br/>
	     <label>Age</label>:<input type="text" name="age"/><br/>
	     <input type="submit" value="Add Customer"/>
	</form>
</body>
</html>