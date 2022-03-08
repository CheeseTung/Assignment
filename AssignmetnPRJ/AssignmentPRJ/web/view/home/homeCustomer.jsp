<%-- 
    Document   : homeCustomer
    Created on : Mar 7, 2022, 10:10:13 PM
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
        <h3>TỴ HÀ MOTEL</h3><br/>
        <a>View Bill</a><br/>
        <h3>${requestScope.notification.alert}</h3>
    </body>
</html>
