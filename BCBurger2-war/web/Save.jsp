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
        <h1>Burger von <%= request.getAttribute("username") %></h1>
        <a href="Home.jsp">Neuen Burger konfigurieren</a>
        <% 
            String[][] burgerArray = (String[][])request.getAttribute("burgerArray");
            int anzahl = burgerArray.length;
            int i;
        %>
        <%
            for (int j = 0; j < anzahl; j++){
        %>
        <div class="burger">
            <%
                for (i = 0; i < 18; i++){
            %>
            <%
                if (i == 0){
            %>
            <img style="z-index: <%=18-i%>" class="brotoben" value ="<%= burgerArray[j][i] %>" src="img/Brot/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i == 1 || i == 16){
            %>
            <img style="z-index: <%=18-i%>" class="sosse" value ="<%= burgerArray[j][i] %>" src="img/Sosse/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i > 1 && i < 9){
            %>
            <img style="z-index: <%=18-i%>" class="gemuese" value ="<%= burgerArray[j][i] %>" src="img/Gemuese/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i == 9){
            %>
            <img style="z-index: <%=18-i%>" class="salat" value ="<%= burgerArray[j][i] %>" src="img/Salat/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i > 9 && i < 13){
            %>
            <img style="z-index: <%=18-i%>" class="kaese" value ="<%= burgerArray[j][i] %>" src="img/Kaese/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i > 12 && i < 16){
            %>
            <img style="z-index: <%=18-i%>" class="fleisch" value ="<%= burgerArray[j][i] %>" src="img/Fleisch/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
                else if (i == 17){
            %>
            <img style="z-index: <%=18-i%>" class="brotunten" value ="<%= burgerArray[j][i] %>" src="img/Brot/<%= burgerArray[j][i].toLowerCase() %>.png" alt="<%= burgerArray[j][i] %>">
            <%
                }
            %>    
            <%
                }
            %>
            <h2>Preis: <%= burgerArray[j][18] %></h2>
            <form action="loeschen" method="post">
                <input type="submit" name="submit" value="Löschen"/>
            </form>
            <form action="loeschen" method="post">
                <input type="submit" name="submit" value="Zu Warenkorb"/>
            </form>
        </div>
        <%
            }
        %>
    </body>
</html>
