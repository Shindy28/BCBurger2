<%-- 
    Document   : Warenkorb
    Created on : 03.04.2016, 19:00:30
    Author     : DanielRohleder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="warenkorb.css" />
        <title>Warenkorb</title>
    </head>
    <body>
        <header>
            <div id="kopf1"><img id="logo" src="img/BC_Burger_Logo2.png" alt="Burgerbild"/></div>
            <div id="kopf2"><h1>BC Burger</h1></div>
            <div id="kopf4"><h3>Warenkorb<br>von <%= request.getParameter("username") %></h3></div>
            <div id="kopf3"><a href="Home.jsp?username=<%= request.getParameter("username") %>">Neuen Burger konfigurieren?</a></div>
            <div id="kopf5"><img id="profil" src="img/Profil.png" alt=""/></div>
        </header>
        <% 
            String[][] burgerArray = (String[][])request.getAttribute("burgerArray");
            int anzahl = burgerArray.length;
            System.out.println("Anzahl: "+anzahl);
            int i;
            int j = 0;
            int z = 0;
            float gespreis = 0;
            request.setAttribute("username", request.getParameter("username"));
        %>
        <%
            for (int y = 0; y <= anzahl/2; y++){
        %>
        <div class="mutter">
        <%
            for (j = j; j < anzahl && z < 2; j++){
                z++;
        %>
        <div class="burger<%= z %>">
            <h3><%= burgerArray[anzahl-j-1][20] %></h3>
            <%
                for (i = 0; i < 18; i++){
            %>
            <%
                if (i == 0){
            %>
            <img style="z-index: <%=18-i%>" class="brotoben" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Brot/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i == 1 || i == 16){
            %>
            <img style="z-index: <%=18-i%>" class="sosse" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Sosse/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i > 1 && i < 9){
            %>
            <img style="z-index: <%=18-i%>" class="gemuese" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Gemuese/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i == 9){
            %>
            <img style="z-index: <%=18-i%>" class="salat" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Salat/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i > 9 && i < 13){
            %>
            <img style="z-index: <%=18-i%>" class="kaese" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Kaese/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i > 12 && i < 16){
            %>
            <img style="z-index: <%=18-i%>" class="fleisch" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Fleisch/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i == 17){
            %>
            <img style="z-index: <%=18-i%>" class="brotunten" value ="<%= burgerArray[anzahl-j-1][i] %>" src="img/Brot/<%= burgerArray[anzahl-j-1][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
            %>    
            <%
                }
            %>
            <h2>Preis: <%= burgerArray[anzahl-j-1][18] %></h2>
            <form action="warenkorb" method="post">
                <input type="hidden" name="bid" value="<%= burgerArray[anzahl-j-1][19] %>"/> 
                <input type="hidden" name="ort" value="<%= request.getParameter("ort") %>"/> 
                <input type="hidden" name="username" value="<%= request.getParameter("username") %>"/> 
                <input type="hidden" name="submit" value="Menge"/>
                <div id="menge">
                    <p>Menge: </p>
                    <input type="textfield" name="menge" value="<%= burgerArray[anzahl-j-1][21] %>" maxlength="1"/> 
                </div>
            </form>
            <form action="warenkorb" method="post">
                <input type="hidden" name="bid" value="<%= burgerArray[anzahl-j-1][19] %>"/> 
                <input type="hidden" name="ort" value="<%= request.getParameter("ort") %>"/> 
                <input type="hidden" name="username" value="<%= request.getParameter("username") %>"/> 
                <input class="button" type="submit" name="submit" value="Loeschen"/>
            </form>
        </div>
        <%
            }
            z = 0;
        %>
        </div>
        <%
            }
        %>
        <div id="bestellung">
            <h3>Bestellung:</h3>
            <div>
                <form action="kaufen" method="post">
                    <%
                        for(int x = 0; x < anzahl; x++){
                            String pr = burgerArray[x][18];
                            pr = pr.substring(0, 4);
                            float prfl = Float.parseFloat(pr);
                            String mengestr = burgerArray[x][21];
                            int menge = Integer.parseInt(mengestr);
                            
                    %>
                    <input type="hidden" name="bid<%= x %>" value="<%= burgerArray[x][19] %>"><p><%= burgerArray[x][21] %>x <%= burgerArray[x][20] %>: <%= (prfl * menge) %>0€</p></input>
                    <%
                            gespreis = gespreis + (prfl * menge);
                        }
                    %>
                    <input type="hidden" name="gesamtpreis" value=""><h4>Gesamtpreis: <%= gespreis %>0€</h4></input>
                    <input type="hidden" name="username" value="<%= request.getParameter("username") %>" />
                    <input type="hidden" name="ort" value="<%= request.getParameter("ort") %>"/> 
                    <input class="button" type="submit" name="submit" value="Kaufen" />
                </form>
            </div>
        </div>
    </body>
</html>

