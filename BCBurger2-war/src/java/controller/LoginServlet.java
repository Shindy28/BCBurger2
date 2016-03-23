/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    LoginBeanLocal LoginBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param, username, password, passwordConfirm, ort;

        param = request.getParameter("submit");
        username = request.getParameter("username");
        password = request.getParameter("password");
        passwordConfirm = request.getParameter("passwordConfirm");
        ort = request.getParameter("ort");
        
        String userid;
        
        if (param.equals("Registrieren")) {
            userid = LoginBean.performRegistry(username, password, passwordConfirm);
            
        }
        else {
            userid = LoginBean.performLogin(username, password);
        }
        if (userid.equals("-1")){
            request.getRequestDispatcher("/index.html").forward(request, response);
        }
        else {
            request.setAttribute("username", username);
            request.setAttribute("ort", ort);
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        }           
    }
}