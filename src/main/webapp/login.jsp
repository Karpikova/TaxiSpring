<%--
  Created by IntelliJ IDEA.
  User: makar
  Date: 20.04.2017
  Time: 4:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<form method="post">
    Login:
        <input type="text" name="login">
    Password:
        <input type="text" name="password">
    <input type="submit" name="login" value="Log in">
</form>
<a href="${pageContext.request.contextPath}?toAuth=1">First time here, want to enjoy as a passenger</a><br>
<a href="${pageContext.request.contextPath}?toAuth=2">First time here, want to enjoy as a driver</a><br><br><br>
<form method="get">
    <c:if test="${param.toAuth != null}">
        Login:
        <input type="text" name="login">
        Password:
        <input type="text" name="password"><br><br>
        Your name:
            <input type="text" name="fullName" required="required">
        Your birthday:
            <input type="date" name="birth"><br><br>
    </c:if>
    <c:if test="${param.toAuth == 2}">
        Your car number:
        <input type="text" name="carNumber" required="required">
        Car description:
        <input type="text" name="carDescription" required="required">
        Your passport number:
        <input type="text" name="passport" required="required">
    </c:if><br><br>

    <c:if test="${param.toAuth != null}">
    <input type="submit" name="createAnAccount" value="I promice I'll behave. Create an account.">
    </c:if>
</form>
</html>