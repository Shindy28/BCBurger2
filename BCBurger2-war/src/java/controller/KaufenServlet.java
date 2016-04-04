/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kaufen")
public class KaufenServlet extends HttpServlet {

    @EJB
    SaveBeanLocal SaveBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String param, username;
        
        System.out.println("Start");
        param = request.getParameter("submit");
        username = request.getParameter("username");
        String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
        
        
        request.setAttribute("burgerArray", burgerArray);
        request.setAttribute("username", username);
        request.getRequestDispatcher("/Kaufen.jsp?username="+username).forward(request, response);
    }

}
