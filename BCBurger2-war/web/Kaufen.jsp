<%-- 
    Document   : Kaufen
    Created on : 04.04.2016, 21:17:30
    Author     : DanielRohleder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="kaufen.css"/>
        <title>Bestellbestaetigung</title>
    </head>
    <% 
        String[][] burgerArray = (String[][])request.getAttribute("burgerArray");
        int anzahl = burgerArray.length;
        System.out.println("Anzahl: "+anzahl);
        float gespreis = 0;
        request.setAttribute("username", request.getParameter("username"));
    %>
    <body>
        <div class="body">
            <img id="logo" src="img/BC_Burger_Logo_white2.png"/>
            <h1>Bestellbestaetigung</h1>
            <div id="text">
                <p>Hallo <%= request.getParameter("username") %>,<br><br>hiermit bestätigen wir dir deine Bestellung.<br>Du kannst deine Bestellung in 30 min abholen.<br>Vielen Dank für deine Bestellung und bis zum nächsten Mal.<br><br>Bis dahin wünschen wir dir guten Appetit.<br>Dein BCBurger Team</p>
            </div>
            <div id="bestellung">
            <h3>Bestellung:</h3>
                <div>
                    <%
                        for(int x = 0; x < anzahl; x++){
                            String pr = burgerArray[x][18];
                            pr = pr.substring(0, 4);
                            float prfl = Float.parseFloat(pr);
                            String mengestr = burgerArray[x][21];
                            int menge = Integer.parseInt(mengestr);
                            
                    %>
                    <p><%= burgerArray[x][21] %>x <%= burgerArray[x][20] %>: <%= (prfl * menge) %>0€</p>
                    <%
                            gespreis = gespreis + (prfl * menge);
                        }
                    %>
                    <h4>Gesamtpreis: <%= gespreis %>0€</h4>
                </div>
            
            </div>
            <a href="index.html">Abmelden?</a>
        </div>
    </body>
</html>
