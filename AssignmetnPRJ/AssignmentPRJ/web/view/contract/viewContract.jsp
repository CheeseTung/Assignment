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
        <h3>Hợp đồng phòng ${requestScope.contract.room.name} </h3>
        <br/>
        Tên phòng: ${requestScope.contract.room.name}<br/>
        Tiền cọc: ${requestScope.contract.deposit}<br/>
        Ngày cọc: ${requestScope.contract.hire}<br/>
        <br/>
        <a href="BillController" >View bill</a>
    </body>
</html>
