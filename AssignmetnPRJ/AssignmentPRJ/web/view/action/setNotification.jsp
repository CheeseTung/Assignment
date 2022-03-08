<%-- 
    Document   : setNotification
    Created on : Mar 8, 2022, 5:44:41 PM
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
        <form action="SetNotification" method="POST">
            <h4>Set notification for customer</h4>
            <textarea name="alert" cols="40" rows="5" ></textarea><br/>
            <input type="submit" value="Set" />
        </form>
    </body>
</html>
