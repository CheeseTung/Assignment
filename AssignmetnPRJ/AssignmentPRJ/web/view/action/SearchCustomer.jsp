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
        <h3>Please note that the room fee will be paid on the last day of the month</h3><br/>
        <c:if test="${requestScope.bill.size() > 0}">
            <table border="1px">
                <tr>
                    <td>Number</td>
                    <td>Room name</td>
                    <td>Room charge</td>
                    <td>Electric</td>
                    <td>Water</td>
                    <td>Network</td>
                    <td>Cleaner</td>
                    <td>Water drink</td>
                    <td>Lack of money</td>
                    <td>Status</td>
                    <td>Total price</td>
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
