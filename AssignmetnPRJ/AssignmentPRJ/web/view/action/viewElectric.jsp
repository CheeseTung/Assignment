<%-- 
    Document   : editElectric
    Created on : Mar 14, 2022, 3:39:07 PM
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
        <c:if test="${requestScope.electricBills.size() gt 0}">
            <table border="1px">
                <tr>
                    <td>Number</td>
                    <td>Room name</td>
                    <td>Price/1 electric number</td>
                    <td>Electric number</td>
                </tr>
                <c:forEach items="${requestScope.electricBills}" var="eb">
                    <tr>
                        <td>${eb.id}</td>
                        <td>${eb.bill.room.name}</td>
                        <td>${eb.price}</td>
                        <td>${eb.count}</td>
                        <td><a href="editElectric?id=${eb.id}">Edit</a></td>
                    </tr>
                </c:forEach>           
            </table>
        </c:if>
        <a href="BillController">View bill</a>
    </body>
</html>
