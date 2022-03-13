<%-- 
    Document   : billCustomer
    Created on : Mar 10, 2022, 4:00:53 PM
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
        <c:if test="${requestScope.bill.size() > 0}">
            <table border="1px">
                <tr>
                    <td>STT</td>
                    <td>Phòng</td>
                    <td>Tiền phòng</td>
                    <td>Tiền điện</td>
                    <td>Tiền nước</td>
                    <td>Tiền mạng</td>
                    <td>Tiền vệ sinh</td>
                    <td>Tiền nước uống</td>
                    <td>Còn thiếu</td>
                    <td>Ghi chú</td>
                    <td>Phải nộp</td>
                </tr>
                <c:forEach items="${requestScope.bill}" var="b">
                    <tr>
                        <td>${b.id}</td>
                        <td>${b.room.name}</td>
                        <td>${b.roomCharge}</td>
                        <td>${b.electricMoney}</td> 
                        <td>${b.waterMoney}</td>
                        <td>${b.networkMoney}</td>
                        <td>${b.cleanerMoney}</td>
                        <td>${b.waterDrink}</td>
                        <td>${b.shortMoney}</td>
                        <td>${b.status}</td>
                        <td>${b.payment.totalPrice}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.bill.size() eq 0}">
            No record to display
        </c:if>
    </body>
</html>
