/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Bill;

import Controller.BaseAuthenticationController;
import dal.BillDBContext;
import dal.PaymentHistoryDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.Payment;
import model.PaymentHistory;

/**
 *
 * @author chitung
 */
public class SubmitBill extends BaseAuthenticationController {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int paymentID = Integer.parseInt(request.getParameter("paymentID"));
        BillDBContext bDB = new BillDBContext();
        Bill bill = bDB.getBillByPayment(paymentID);
        
        PaymentHistory ph = new PaymentHistory();
        Payment p = new Payment();
        p.setId(paymentID);
        ph.setPayment(p);
        
        
        bill.setId(bill.getId());       
        ph.setBill(bill);
        ph.setFromDate(bill.getFromDate());
        ph.setToDate(bill.getToDate());
        ph.setRoomName(bill.getRoom().getName());
        ph.setRoomCharge(bill.getRoomCharge());
        ph.setElectricMoney(bill.getElectricMoney());
        ph.setWaterMoney(bill.getWaterMoney());
        ph.setNetworkMoney(bill.getNetworkMoney());
        ph.setCleanerMoney(bill.getCleanerMoney());
        ph.setWaterDrink(bill.getWaterDrink());
        ph.setShortMoney(bill.getShortMoney());
        ph.setTotalPrice(bill.getPayment().getTotalPrice());
        
        PaymentHistoryDBContext phDB = new PaymentHistoryDBContext();
        phDB.insertPaymentHistory(ph);
        response.sendRedirect("BillController");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
