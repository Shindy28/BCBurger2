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
 * Registrierung oder Einloggen ausfuehren
 * 
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    LoginBeanLocal LoginBean;

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
            request.getRequestDispatcher("/Home.jsp?username="+username+"&ort="+ort).forward(request, response);
        }           
    }
}