<%-- 
    Document   : login
    Created on : Mar 1, 2022, 11:03:58 PM
    Author     : chitung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Login (Admin)</h3>
        <form action="login" method="POST">
            Username: <input type="text" name="username" /> <br/>
            PassWord: <input type="text" name="password" /><br/>
            <input type="submit" value="Sign in" /> 
            <h5 style="color: red">${requestScope.loginFailed}</h5> 
        </form>
    </body>
</html>
