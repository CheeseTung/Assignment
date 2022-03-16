<%-- 
    Document   : billAdmin
    Created on : Mar 10, 2022, 4:00:41 PM
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
        <script>
            function submitSearchForm()
            {
                document.getElementById("searchForm").submit();
            }

            function submitBill(id)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "submit?paymentID=" + id;
                }
            }
        </script>
    </head>
    <body>
        <h3>Room charge from <fmt:formatDate type="date" value="${requestScope.bi.fromDate}"></fmt:formatDate> to <fmt:formatDate type="date" value="${requestScope.bi.toDate}"></fmt:formatDate></h3><br/>
        <form action="continue" method="GET">
            <input type="submit" value="Single closing"/>
        </form>
        <form action="viewHistory" method="GET">
            <h3>Search room bill history</h3><br/>
            From date <input type="date" name="fromDate" /> to date <input type="date" name="toDate" /><input type="submit" value="Search" />
        </form>
        <h4><a href="searchElectric">Update electric number of month</a></h4><br/>
        <c:if test="${requestScope.bills.size() > 0}">
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
                <c:forEach items="${requestScope.bills}" var="b">
                    <tr>
                        <td>${b.id}</td>
                        <td><a href="contract?name=${b.room.name}">${b.room.name}</a></td>
                        <td>${b.roomCharge}</td>
                        <td>${b.electricMoney}</td> 
                        <td>${b.waterMoney}</td>
                        <td>${b.networkMoney}</td>
                        <td>${b.cleanerMoney}</td>
                        <td>${b.waterDrink}</td>
                        <td>${b.shortMoney}</td>
                        <td>${b.status}</td>
                        <td>${b.payment.totalPrice}</td>
                        <td><a href="edit?id=${b.id}">Edit</a></td>
                        <td><a href="#" onclick="submitBill(${b.payment.id});" >Submit</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.bills.size() eq 0}">
            No record to display
        </c:if>
    </body>
</html>
