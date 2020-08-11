<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/mvcCrud/transact" method=post>
	     <label>From Account</label>:<input type="text" name="fromAccount"/><br/>
	     <label>To Account</label>:<input type="text" name="toAccount"/><br/>
	     <label>Amount</label>:<input type="number" name="amount"/><br/>
	     <input type="submit" value="Transfer Fund"/>
	</form>
</body>
</html>