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
 * Burger zu Warenkorb hinzufuegen, aus dem Warenkorb loeschen oder die Menge im Warenkorb aendern
 * 
 */

@WebServlet("/warenkorb")
public class WarenkorbServlet extends HttpServlet {

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
        
        param = request.getParameter("submit");
        username = request.getParameter("username");
        String bidstr = request.getParameter("bid");
        String burgername = request.getParameter("burgername");
        
        
        switch (param) {
            case "Zu Warenkorb":
            {
                int bid = Integer.parseInt(bidstr);
                SaveBean.performOrder(bid, username, burgername);
                String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
                System.out.println(burgerArray.length);
                request.setAttribute("burgerArray", burgerArray);
                request.setAttribute("username", username);
                request.getRequestDispatcher("/Warenkorb.jsp?username="+username).forward(request, response);
                break;
            }
            case "Loeschen":
            {
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
                break;
            }
            case "Menge":
            {
                String mengestr = request.getParameter("menge");
                int menge = Integer.parseInt(mengestr);
                int bid = Integer.parseInt(bidstr);
                SaveBean.changeMenge(bid, menge);
                String[][] burgerArray = SaveBean.getBurgerInWarenkorb(username.toLowerCase());
                request.setAttribute("username", username);
                request.setAttribute("burgerArray", burgerArray);
                request.getRequestDispatcher("/Warenkorb.jsp?username="+username).forward(request, response);
                break;
            }
        }
    }

}
