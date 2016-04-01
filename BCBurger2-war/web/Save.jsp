<%-- 
    Document   : Save
    Created on : 30.03.2016, 15:54:56
    Author     : DanielRohleder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="save.css" />
        <title>Deine Burger</title>
    </head>
    <body>
        <header>
            <div id="kopf1"><img id="logo" src="img/BC_Burger_Logo2.png" alt="Burgerbild"/></div>
            <div id="kopf2"><h1>BC Burger</h1></div>
            <div id="kopf4"><h3>Gespeicherte Burger<br>von <%= request.getParameter("username") %></h3></div>
            <div id="kopf3"><a href="Home.jsp?username=<%= request.getAttribute("username") %>">Neuen Burger konfigurieren?</a></div>
            <div id="kopf5"><img id="profil" src="img/Profil.png" alt=""/></div>
        </header>
        <% 
            String[][] burgerArray = (String[][])request.getAttribute("burgerArray");
            int anzahl = burgerArray.length;
            int i;
            int j = 0;
            int z = 0;
            request.setAttribute("username", request.getAttribute("username"));
        %>
        <%
            for (int y = 0; y <= anzahl/3; y++){
        %>
        <div class="mutter">
        <%
            for (j = j; j < anzahl && z < 3; j++){
                z++;
        %>
        <div class="burger<%= z %>">
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
            <form action="loeschen" method="post">
                <input type="submit" name="submit" value="Löschen"/>
            </form>
            <form action="loeschen" method="post">
                <input type="submit" name="submit" value="Zu Warenkorb"/>
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
        
    </body>
</html>
