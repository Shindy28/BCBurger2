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

/**
 *
 * @author DanielRohleder
 */
@WebServlet("/warenkorb")
public class WarenkorbServlet extends HttpServlet {

    @EJB
    SaveBeanLocal SaveBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String param, username;
        
        param = request.getParameter("submit");
        username = request.getParameter("username");
        String bidstr = request.getParameter("bid");
        String burgername = request.getParameter("burgername");
        
        
        if (param.equals("Zu Warenkorb")){
            int bid = Integer.parseInt(bidstr);
            SaveBean.performOrder(bid, username, burgername);
            String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
            System.out.println(burgerArray.length);
            request.setAttribute("burgerArray", burgerArray);
            request.setAttribute("username", username);
            request.getRequestDispatcher("/Warenkorb.jsp?username="+username).forward(request, response);
        }
        else if (param.equals("Loeschen")){
            
            int bid = Integer.parseInt(bidstr);
            SaveBean.deleteBurgerInWarenkorb(bid);
            String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
            request.setAttribute("username", username);
            if (burgerArray.length > 0){
                request.setAttribute("burgerArray", burgerArray);
                request.getRequestDispatcher("/Warenkorb.jsp?username="+username).forward(request, response);
            } 
            else {
                request.getRequestDispatcher("/Home.jsp?username="+username).forward(request, response);
            }
        }
        else if (param.equals("Menge")){
            String mengestr = request.getParameter("menge");
            int menge = Integer.parseInt(mengestr);
            int bid = Integer.parseInt(bidstr);
            SaveBean.changeMenge(bid, menge);
            String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
            request.setAttribute("username", username);
            request.setAttribute("burgerArray", burgerArray);
            request.getRequestDispatcher("/Warenkorb.jsp?username="+username).forward(request, response);
        }
    }

}
