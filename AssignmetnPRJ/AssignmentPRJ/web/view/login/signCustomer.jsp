<%-- 
    Document   : signCustomer
    Created on : Mar 1, 2022, 11:06:22 PM
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
        <h3>Sign out (Customer)</h3>
        <form action="signCustomer" method="POST">
            Username: <input type="text" name="username" /> <br/>
            Password: <input type="text" name="password" /><br/>
            Display Name: <input type="text" name="displayName" /><br/>
            Number: <input type="text" name="number" /><br/>
            Address: <input type="text" name="address" /><br/>
            <input type="submit" value="Sign out" /> 
            <h4 style="color: red">${requestScope.exist}</h4>
        </form>
    </body>
</html>
