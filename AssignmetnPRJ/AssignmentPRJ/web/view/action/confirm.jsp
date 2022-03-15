<%-- 
    Document   : confirm
    Created on : Mar 15, 2022, 3:13:01 PM
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
        <form action="confirm" method="POST">
          STT: ${requestScope.bill.id} <input type="hidden" name="id" value="${requestScope.bill.id}"/>  <br/>
          Tên phòng: ${requestScope.bill.room.name}<br/>
          Tiền phòng: ${requestScope.bill.roomCharge} <input type="hidden" name="roomCharge" value=""/><br/>
          Tiền điện: ${requestScope.bill.electricMoney} <input type="hidden" name="electricMoney" value="${requestScope.bill.electricMoney}" /><br/>
          Tiền nước: ${requestScope.bill.waterMoney} <input type="hidden" name="waterMoney" value="${requestScope.bill.waterMoney}" /><br/>
          Tiền mạng: ${requestScope.bill.networkMoney} <input type="hidden" name="networkMoney" value="${requestScope.bill.networkMoney}" /><br/>
          Tiền vệ sinh: ${requestScope.bill.cleanerMoney} <input type="hidden" name="cleanerMoney" value="${requestScope.bill.cleanerMoney}" /><br/>
          Tiền nước uống: ${requestScope.bill.waterDrink} <input type="hidden" name="waterDrink" value="${requestScope.bill.waterDrink}" /><br/>
          Còn thiếu: ${requestScope.bill.shortMoney} <input type="hidden" name="shortMoney" value="${requestScope.bill.shortMoney}" /><br/>
          Ghi chú: ${requestScope.bill.status} <input type="hidden" name="status" value="${requestScope.bill.status}"/><br/>
          <input type="submit" value="Save"/>
        </form>
    </body>
</html>
