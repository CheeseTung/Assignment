<%-- 
    Document   : editElectric
    Created on : Mar 14, 2022, 6:40:39 PM
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
        <form action="editElectric" method="POST">
            STT: ${requestScope.electricBill.id}<input type="hidden" name="id" value="${requestScope.electricBill.id}" />
            Tên phòng: ${requestScope.electricBill.bill.room.name}<br/>
            Giá/Số: ${requestScope.electricBill.price} <input type="hidden" name="price" value="${requestScope.electricBill.price}"/><br/>
            Số điện: <input type="text" name="count" value="${requestScope.electricBill.count}" /><br/>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
