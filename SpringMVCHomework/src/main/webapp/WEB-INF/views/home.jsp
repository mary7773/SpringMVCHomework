<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<jsp:include page="template/header.jsp"/>

<form:form modelAttribute="account" method="post" action="${pageContext.request.contextPath}/bankOperation">
Client ID: <form:input type="text" value="${account.clientId}" path="clientId"/> <br/>
Current amount: <form:input type="text" value="${account.currentAmount}" path="currentAmount"/> <br/>
Operation: <form:radiobutton path="operation" value="Deposit" />Deposit <form:radiobutton
					path="operation" value="Withdraw" />Withdraw<br/>
Amount: <form:input type="text" value="" path="amount"/> <br/>
Currency: <form:input type="text" value="" path="currency"/> <br/><br/>
<input type="submit" value="Submit"/> <br/>
</form:form>
<jsp:include page="template/footer.jsp"/>
</body>
</html>