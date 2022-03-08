<%-- 
    Document   : loginCustomer
    Created on : Mar 1, 2022, 11:04:35 PM
    Author     : chitung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Login (Customer)</h3>
        <form action="loginCustomer" method="POST">
            Username: <input type="text" name="username" /> <br/>
            Password: <input type="password" name="password" /><br/>
            <input type="checkbox" value="remember" name="remember"/> Remember Me! <br/>
            <input type="submit" value="Sign in" /> 
            <h5 style="color: red">${requestScope.loginFailed}</h5> 
        </form>
    </body>
</html>
