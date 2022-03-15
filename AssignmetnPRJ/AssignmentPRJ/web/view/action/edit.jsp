<%-- 
    Document   : edit
    Created on : Mar 13, 2022, 11:18:50 AM
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
        <form action="edit" method="POST">
          Number: ${requestScope.bill.id} <input type="hidden" name="id" value="${requestScope.bill.id}"/>  <br/>
          Room name: ${requestScope.bill.room.name}<br/>
         Room charge: <input type="text" name="roomCharge" value="${requestScope.bill.roomCharge}"/><br/>
          Electric: <input type="text" name="electricMoney" value="${requestScope.bill.electricMoney}" /><br/>
          Water: <input type="text" name="waterMoney" value="${requestScope.bill.waterMoney}" /><br/>
          Network: <input type="text" name="networkMoney" value="${requestScope.bill.networkMoney}" /><br/>
          Cleaner: <input type="text" name="cleanerMoney" value="${requestScope.bill.cleanerMoney}" /><br/>
          Water drink: <input type="text" name="waterDrink" value="${requestScope.bill.waterDrink}" /><br/>
          Lack of money: <input type="text" name="shortMoney" value="${requestScope.bill.shortMoney}" /><br/>
          Status: <input type="text" name="status" value="${requestScope.bill.status}"/><br/>
          <input type="submit" value="Save"/>
        </form>
    </body>
</html>
