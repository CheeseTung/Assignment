<%-- 
    Document   : homeAdmin
    Created on : Mar 7, 2022, 10:09:58 PM
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
        <h3>MANAGEMENT OF THE MOTEL TỴ HÀ</h3><br/>
        <h4>Wellcome ${requestScope.hostAccount.displayname}</h4><br/>
        <a href="signCustomer">Sign out customer account</a><br/>
        <br/>
        <a href="BillController">Edit bill</a><br/>
        <br/>
        <a href="SetNotification">Set notification for customer</a>
    </body>
</html>
