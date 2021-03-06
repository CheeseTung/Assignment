/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Bill;

import Controller.BaseAuthenticationController;
import dal.BillDBContext;
import dal.PaymentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.Payment;

/**
 *
 * @author chitung
 */
public class EditBill extends BaseAuthenticationController {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditBill</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditBill at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        int billId = Integer.parseInt(request.getParameter("id"));
        BillDBContext bDB = new BillDBContext();
        Bill bill = bDB.getBill(billId);
        request.setAttribute("bill", bill);
        request.getRequestDispatcher("view/action/edit.jsp").forward(request, response);
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
        int roomCharge = Integer.parseInt(request.getParameter("roomCharge"));
        int waterMoney = Integer.parseInt(request.getParameter("waterMoney"));
        int networkMoney = Integer.parseInt(request.getParameter("networkMoney"));
        int cleanerMoney = Integer.parseInt(request.getParameter("cleanerMoney"));
        int waterDrink = Integer.parseInt(request.getParameter("waterDrink"));
        int shortMonet = Integer.parseInt(request.getParameter("shortMoney"));
        String status = request.getParameter("status");
        int id = Integer.parseInt(request.getParameter("id"));
        
        Bill b = new Bill();
        b.setId(id);
        b.setRoomCharge(roomCharge);
        b.setWaterMoney(waterMoney);
        b.setNetworkMoney(networkMoney);
        b.setCleanerMoney(cleanerMoney);
        b.setWaterDrink(waterDrink);
        b.setShortMoney(shortMonet);
        b.setStatus(status);
        
        BillDBContext bDB = new BillDBContext();
        bDB.updateBill(b);
        response.sendRedirect("BillController");
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
