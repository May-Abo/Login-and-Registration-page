/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.beans.UserLog;
import com.test.beans.UserWeb;
import com.test.daoimplemenatation.DaoImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
public class UserLogOut extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            DaoImplementation di = new DaoImplementation();
            
            UserWeb uw = (UserWeb) request.getSession().getAttribute("userlog");
            
            UserLog ul = new UserLog(uw.getUserName(), request.getLocalAddr(), "Log Out", "");
            
            int result = di.addUserLogInfo(ul);
            
            request.getSession().setAttribute("userlog", null);
            
            response.sendRedirect("Login.jsp?errorMsg=3");
            
        } finally {
            out.close();
        }
    }


}
