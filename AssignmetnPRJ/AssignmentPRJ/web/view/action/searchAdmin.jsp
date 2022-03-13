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

            function deleteBill(id)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "delete?id=" + id;
                }
            }
        </script>
    </head>
    <body>
        <c:if test="${requestScope.bills.size() > 0}">
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
                <c:forEach items="${requestScope.bills}" var="b">
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
                        <td><a href="edit?id=${b.id}">Edit</a> 
                            <a href="#" onclick="deleteBill(${b.id});" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.bills.size() eq 0}">
            No record to display
        </c:if>
    </body>
</html>
