<%@ page language="java" contentType="text/html;"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Collection"%>
<html>
<body>
<h1>Spring MVC Web Project Example</h1>
 
<h2>Message : ${message}</h2>
<h2>Counter : ${counter}</h2>

<h4>${debugStatement}</h4>
<p>Collection is:${foundAccounts.isEmpty()}</p>
<h3>Accounts found:</h3>
<table border="1">
	<tr><td>Account Num</td><td>Customer Name</td><td>Amount</td></tr>
	<c:forEach var="account" items="${foundAccounts}">
  		<tr><td>${account.customerAcct}</td><td>${account.customerName}</td><td>${account.customerMoney}</td></tr>
</c:forEach>
</table>	
</body>
</html>
