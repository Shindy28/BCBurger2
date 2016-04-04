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
@WebServlet("/save")
public class BurgerServlet extends HttpServlet {
    
    @EJB
    SaveBeanLocal SaveBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param, belag1, belag2, belag3, belag4, belag5, belag6, belag7, belag8, belag9, belag10, belag11, belag12, belag13, belag14, belag15, belag16, belag17, belag18, username;
        
        
        System.out.println("Start");
        param = request.getParameter("submit");
        username = request.getParameter("username");
        String bidstr = request.getParameter("bid");
        String burgername = request.getParameter("burgername");
        
        
        System.out.println(param);
        
        if(param.equals("Speichern")){

            belag1 = request.getParameter("Brotoben");
            belag2 = request.getParameter("Sossebelag2");
            belag3 = request.getParameter("Gemuesebelag7");
            belag4 = request.getParameter("Gemuesebelag6");
            belag5 = request.getParameter("Gemuesebelag5");
            belag6 = request.getParameter("Gemuesebelag4");
            belag7 = request.getParameter("Gemuesebelag3");
            belag8 = request.getParameter("Gemuesebelag2");
            belag9 = request.getParameter("Gemuesebelag1");
            belag10 = request.getParameter("Salatbelag");
            belag11 = request.getParameter("Kaesebelag3");
            belag12 = request.getParameter("Kaesebelag2");
            belag13 = request.getParameter("Kaesebelag1");
            belag14 = request.getParameter("Fleischbelag3");
            belag15 = request.getParameter("Fleischbelag2");
            belag16 = request.getParameter("Fleischbelag1");
            belag17 = request.getParameter("Sossebelag1");
            belag18 = request.getParameter("Brotunten");
           
   
            SaveBean.performSave(belag1, belag2, belag3, belag4, belag5, belag6, belag7, belag8, belag9, belag10, belag11, belag12, belag13, belag14, belag15, belag16, belag17, belag18, username, burgername);  
            String[][] burgerArray = SaveBean.getSaveBurger(username.toLowerCase());
            request.setAttribute("burgerArray", burgerArray);
            request.setAttribute("username", username);
            request.setAttribute("burgername", burgername);
            request.getRequestDispatcher("/Save.jsp?username="+username).forward(request, response);
        
        }
        else if (param.equals("Loeschen")){
            
            int bid = Integer.parseInt(bidstr);
            SaveBean.deleteBurger(bid);
            String[][] burgerArray = SaveBean.getSaveBurger(username.toLowerCase());
            request.setAttribute("username", username);
            if (burgerArray.length > 0){
                request.setAttribute("burgerArray", burgerArray);
                request.getRequestDispatcher("/Save.jsp?username="+username).forward(request, response);
            } 
            else {
                request.getRequestDispatcher("/Home.jsp?username="+username).forward(request, response);
            }
        }
        else if (param.equals("Bestellen")){
            belag1 = request.getParameter("Brotoben");
            belag2 = request.getParameter("Sossebelag2");
            belag3 = request.getParameter("Gemuesebelag7");
            belag4 = request.getParameter("Gemuesebelag6");
            belag5 = request.getParameter("Gemuesebelag5");
            belag6 = request.getParameter("Gemuesebelag4");
            belag7 = request.getParameter("Gemuesebelag3");
            belag8 = request.getParameter("Gemuesebelag2");
            belag9 = request.getParameter("Gemuesebelag1");
            belag10 = request.getParameter("Salatbelag");
            belag11 = request.getParameter("Kaesebelag3");
            belag12 = request.getParameter("Kaesebelag2");
            belag13 = request.getParameter("Kaesebelag1");
            belag14 = request.getParameter("Fleischbelag3");
            belag15 = request.getParameter("Fleischbelag2");
            belag16 = request.getParameter("Fleischbelag1");
            belag17 = request.getParameter("Sossebelag1");
            belag18 = request.getParameter("Brotunten");
            
            SaveBean.performOrder(belag1, belag2, belag3, belag4, belag5, belag6, belag7, belag8, belag9, belag10, belag11, belag12, belag13, belag14, belag15, belag16, belag17, belag18, username, burgername);
            String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
            request.setAttribute("burgerArray", burgerArray);
            request.setAttribute("username", username);
            request.getRequestDispatcher("/Warenkorb.jsp?username="+username).forward(request, response);
            
        }
    }
}
