/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.beans.Country;
import com.test.beans.UserLog;
import com.test.beans.UserWeb;
import com.test.daoimplemenatation.DaoImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author User
 */
public class UserController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {



            String fname = request.getParameter("fname");

            String lname = request.getParameter("lname");

            String password = request.getParameter("password");

            String email = request.getParameter("email");

            String username = request.getParameter("username");

            String country = request.getParameter("country");

            String phoneNumber = request.getParameter("phoneNumber");

            DaoImplementation udi = new DaoImplementation();

            UserWeb u1 = new UserWeb(username, fname, lname, email, password, country, phoneNumber);

            int a = udi.addUser(u1);


            if (a > 0) {
                response.sendRedirect("index.jsp");
                UserLog ul = new UserLog(u1.getUserName(), request.getLocalAddr(), "New Registration", "");
                udi.addUserLogInfo(ul);
            } else {
                response.sendRedirect("Login.jsp?errorMsg=4");
            }



        } finally {
            out.close();
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
