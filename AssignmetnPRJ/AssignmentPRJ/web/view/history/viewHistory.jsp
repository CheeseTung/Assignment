<%-- 
    Document   : viewHistory
    Created on : Mar 17, 2022, 12:31:21 AM
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
    <c:if test="${requestScope.ph.size() > 0}">
        <table border="1px">
            <tr>
                <td>Room name</td>
                <td>Room charge</td>
                <td>Electric</td>
                <td>Water</td>
                <td>Network</td>
                <td>Cleaner</td>
                <td>Water drink</td>
                <td>Lack of money</td>
                <td>Total price</td>
            </tr>
            <c:forEach items="${requestScope.ph}" var="ph">
                <tr>
                    <td>${ph.roomName}</td>
                    <td>${ph.roomCharge}</td>
                    <td>${ph.electricMoney}</td> 
                    <td>${ph.waterMoney}</td>
                    <td>${ph.networkMoney}</td>
                    <td>${ph.cleanerMoney}</td>
                    <td>${ph.waterDrink}</td>
                    <td>${ph.shortMoney}</td>
                    <td>${ph.totalPrice}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${requestScope.ph.size() eq 0}">
        No record to display
    </c:if>

    <a href="BillController" >Back to view</a>
    <a href="HomeAdmin">Back to home page</a>
</body>
</html>
