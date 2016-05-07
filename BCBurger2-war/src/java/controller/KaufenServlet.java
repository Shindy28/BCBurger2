package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Burger aus Warenkorb laden und auf Bestellbestaetigungsseite anzeigen
 * 
 */

@WebServlet("/kaufen")
public class KaufenServlet extends HttpServlet {

    @EJB
    SaveBeanLocal SaveBean;

/**
 * 
 * @param request HttpServletRequest
 * @param response HttpServletResponse
 * @throws ServletException ServletException
 * @throws IOException IOException
 * 
 */
    
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
