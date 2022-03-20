<%-- 
    Document   : history
    Created on : Mar 17, 2022, 1:18:18 PM
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
        <link href="../css/pagger.css" rel="stylesheet" type="text/css"/>
        <script src="../js/pagger.js" type="text/javascript"></script>
    </head>
    <body>
        <form action="viewHistory" method="POST">
            <h3>Search room bill history</h3><br/>
            From date <input type="date" name="fromDate" /> to date <input type="date" name="toDate" /><input type="submit" value="Search" />
        </form>
        <c:if test="${requestScope.ph.size() > 0}">
        <h3>Room bill from date ${requestScope.fromDate} to ${requestScope.toDate}</h3>
        
             <div id="paggertop" class="container"> </div>
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
            <div id="paggerbot" class="container"> </div>
            <script>
                        pagger('paggertop',${requestScope.pageindex},${requestScope.pagesize}, 2);
                        pagger('paggerbot',${requestScope.pageindex},${requestScope.pagesize}, 2);
            </script>
        </c:if>
        <c:if test="${requestScope.bills.size() eq 0}">
            No record to display
        </c:if>
    </body>
</html>