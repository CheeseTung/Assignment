/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Bill;

import Controller.BaseAuthenticationController;
import dal.BillDBContext;
import dal.ElectricDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import model.ElectricBill;

/**
 *
 * @author chitung
 */
public class EditElectric extends BaseAuthenticationController {

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
            out.println("<title>Servlet EditElectric</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditElectric at " + request.getContextPath() + "</h1>");
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
        int electricID = Integer.parseInt(request.getParameter("id"));
        ElectricDBContext eDB = new ElectricDBContext();
        ElectricBill eb = eDB.getElectricBill(electricID);
        request.setAttribute("electricBill", eb);
        request.getRequestDispatcher("view/action/editElectric.jsp").forward(request, response);
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
        int price = Integer.parseInt(request.getParameter("price"));
        int count = Integer.parseInt(request.getParameter("count"));
        int id = Integer.parseInt(request.getParameter("id"));
        int electricMoney = price*count;
        
        ElectricBill eb = new ElectricBill();
        eb.setId(id);
        eb.setPrice(price);
        eb.setCount(count);
        
        ElectricDBContext eDB = new ElectricDBContext();
        eDB.updateElectric(eb);
        
        //update electric money into database
        Bill b = new Bill();
        b.setId(id);
        b.setElectricMoney(electricMoney);
        
        BillDBContext bDB = new BillDBContext();
        bDB.updateElectricMonney(b);
        
        response.sendRedirect("searchElectric");
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
