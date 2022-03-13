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
        <h4>Wellcome ${requestScope.customerAccount.displayname}</h4><br/>
        <a href="searchCustomer" >View Bill</a><br/>
        
        
        <h3 style="border: 1px solid">${requestScope.notification.alert}</h3>
    </body>
</html>
