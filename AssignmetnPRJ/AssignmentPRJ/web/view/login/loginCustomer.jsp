<%-- 
    Document   : loginCustomer
    Created on : Mar 1, 2022, 11:04:35 PM
    Author     : chitung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Password: <input type="text" name="password" /><br/>
            <input type="submit" value="Sign in" /> 
            <h5 style="color: red">${requestScope.loginFailed}</h5> 
        </form>
    </body>
</html>
