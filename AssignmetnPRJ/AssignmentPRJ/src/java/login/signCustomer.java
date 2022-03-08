/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import dal.CustomerAccountDBContext;
import dal.HostAccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customerAccount;

/**
 *
 * @author chitung
 */
public class signCustomer extends HttpServlet {

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
            out.println("<title>Servlet signCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signCustomer at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/login/signCustomer.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String raw_username = request.getParameter("username");
        String raw_password = request.getParameter("password");
        String raw_displayName = request.getParameter("displayName");
        String raw_number = request.getParameter("number");
        String raw_address = request.getParameter("address");
        
        String username = raw_username; //check username
        String password = raw_password; //check password
        String displayName = raw_displayName; //check displayName
        String number = raw_number;
        String address = raw_address;
        
        customerAccount ca = new customerAccount();
        ca.setUsername(username);
        ca.setPassword(password);
        ca.setDisplayname(displayName);
        ca.setNumber(number);
        ca.setAddress(address);
        
        
        CustomerAccountDBContext caDB = new CustomerAccountDBContext();
        customerAccount caExist = caDB.getCustomerAccount(username, password);
        if(caExist == null){
            caDB.insertCustomerAccount(ca);
            response.sendRedirect("HomeAdmin"); //send to home page
        }else{
            String exist = "This account is already exist! Please try again ";
            request.setAttribute("exist", exist);
            request.getRequestDispatcher("view/login/signCustomer.jsp").forward(request, response);
        }
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
