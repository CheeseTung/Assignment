<%-- 
    Document   : viewContract
    Created on : Mar 14, 2022, 9:41:24 PM
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
        <h3>Contract room ${requestScope.contract.room.name} </h3>
        <br/>
        Room name: ${requestScope.contract.room.name}<br/>
        Deposit: ${requestScope.contract.deposit}<br/>
        Hire: ${requestScope.contract.hire}<br/>
        <br/>
        <a href="BillController" >View bill</a>
    </body>
</html>
