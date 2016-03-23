/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param, belag1, belag2, belag3, belag4, belag5, belag6, belag7, belag8, belag9, belag10, belag11, belag12, belag13, belag14, belag15, belag16, belag17, belag18;

        param = request.getParameter("submit");
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
        
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.print("alert('");
        out.print(belag1 + ", ");
        out.print(belag2 + ", ");
        out.print(belag3 + ", ");
        out.print(belag4 + ", ");
        out.print(belag5 + ", ");
        out.print(belag6 + ", ");
        out.print(belag7 + ", ");
        out.print(belag8 + ", ");
        out.print(belag9 + ", ");
        out.print(belag10 + ", ");
        out.print(belag11 + ", ");
        out.print(belag12 + ", ");
        out.print(belag13 + ", ");
        out.print(belag14 + ", ");
        out.print(belag15 + ", ");
        out.print(belag16 + ", ");
        out.print(belag17 + ", ");
        out.print(belag18);
        out.println("');");
        out.println("</script>");
        out.println("location='Home.jsp';");  
        
    }
}
