<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css" />
        <script language="javascript" type="text/javascript" src="config.js"></script> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>BC Burger</title>
    </head>
    <body>
        <header>
            <div id="kopf1"><img id="logo" src="img/BC_Burger_Logo.png" alt="Burgerbild"/></div>
            <div id="kopf2"><h1>BC Burger</h1></div>
            <div id="kopf3"><h3>Kaiserallee 93<br><%= request.getAttribute("ort") %></h3></div>
            <div id="kopf4"><h3>Hallo Burgerfreund<br><%= request.getAttribute("username") %></h3></div>
            <div id="kopf5"><img id="profil" src="img/Profil.png" alt=""/></div>
        </header>
        <div id="zutaten">
            <h2>Brot</h2>
            <hr align="left">
            <div id="brot">
                <label><input type="radio" class="radio" name="brot1" value="brioche" onclick="ausgabe(value, name);"><img class="brot1" id="start" name="brioche" src="img/Brot/brioche.png" alt=""/></label>
                <label><input type="radio" class="radio" name="brot1" value="bigmac" onclick="ausgabe(value, name);"><img class="brot1" name="bigmac" src="img/Brot/bigmacbun.png" alt=""/></label>
                <label><input type="radio" class="radio" name="brot1" value="dinkel" onclick="ausgabe(value, name);"><img class="brot1" name="dinkel" src="img/Brot/dinkel.png" alt=""/></label>
            </div>
            <h2 class="uebers">Fleisch</h2>
            <hr align="left">
            <div id="fleisch">
                <label><input type="checkbox" class="cbox" name="fleisch1" value="newbeef" onclick="ausgabe(value, name);" checked><img class="fleisch1" name="newbeef" id="start" src="img/Fleisch/cow.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="fleisch1" value="chicken" onclick="ausgabe(value, name);"><img class="fleisch1" name="chicken" src="img/Fleisch/huhn.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="fleisch1" value="veggie" onclick="ausgabe(value, name);"><img class="fleisch1" name="veggie" src="img/Fleisch/vegetarisch.png" alt=""/></label>
                <div class="plumin"><button class="minus" onclick="minus('newbeef', 'fleisch1');">-</button><button class="plus" onclick="plus('newbeef', 'fleisch1');">+</button></div>
                <div class="plumin"><button class="minus" onclick="minus('chicken', 'fleisch1');">-</button><button class="plus" onclick="plus('chicken', 'fleisch1');">+</button></div>
                <div class="plumin"><button class="minus" onclick="minus('veggie', 'fleisch1');">-</button><button class="plus" onclick="plus('veggie', 'fleisch1');">+</button></div>
            </div>
            <h2 class="uebers">Käse</h2>
            <hr align="left">
            <div id="kaese">
                <label><input type="checkbox" class="cbox" name="kaese1" value="cheese" onclick="ausgabe(value, name);" checked><img class="kaese1" name="cheese" id="start" src="img/Kaese/cheese.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="kaese1" value="cheddar" onclick="ausgabe(value, name);"><img class="kaese1" name="cheddar" src="img/Kaese/cheddar.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="kaese1" value="emmentaler" onclick="ausgabe(value, name);"><img class="kaese1" name="emmentaler" src="img/Kaese/emmentaler.png" alt=""/></label>
                <div class="plumin"><button class="minus" onclick="minus('cheese', 'kaese1');">-</button><button class="plus" onclick="plus('cheese', 'kaese1');">+</button></div>
                <div class="plumin"><button class="minus" onclick="minus('cheddar', 'kaese1');">-</button><button class="plus" onclick="plus('cheddar', 'kaese1');">+</button></div>
                <div class="plumin"><button class="minus" onclick="minus('emmentaler', 'kaese1');">-</button><button class="plus" onclick="plus('emmentaler', 'kaese1');">+</button></div>
            </div>
            <h2 class="uebers">Salat</h2>
            <hr align="left">
            <div id="salat">
                <label><input type="checkbox" class="cbox" name="salat1" value="salat" onclick="ausgabe(value, name);" checked><img class="salat1" name="salat" id="start" src="img/Salat/salat.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="salat1" value="salatbun" onclick="ausgabe(value, name);"><img class="salat1" name="salatbun" src="img/Salat/salatbun.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="salat1" value="rucula" onclick="ausgabe(value, name);"><img class="salat1" name="rucula" src="img/Salat/rucula.png" alt=""/></label>
            </div>
            <h2 class="uebers">Gemüse</h2>
            <hr align="left">
            <div id="gemuese">
                <label><input type="checkbox" class="cbox" name="gemuese1" value="tomate" onclick="ausgabe(value, name);" checked><img class="gemuese1" name="tomate" id="start" src="img/Gemuese/tomate.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="gemuese1" value="gurke" onclick="ausgabe(value, name);" checked><img class="gemuese1" name="gurke" id="start" src="img/Gemuese/gurke.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="gemuese1" value="essiggurkerl" onclick="ausgabe(value, name);"><img class="gemuese1" name="essiggurkerl" src="img/Gemuese/essiggurkerl.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="gemuese1" value="zwiebelrot" onclick="ausgabe(value, name);"><img class="gemuese1" name="zwiebelrot" src="img/Gemuese/zwiebelrot.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="gemuese1" value="rostzwiebel" onclick="ausgabe(value, name);"><img class="gemuese1" name="rostzwiebel" src="img/Gemuese/rostzwiebel.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="gemuese1" value="jalapenos" onclick="ausgabe(value, name);"><img class="gemuese1" name="jalapenos" src="img/Gemuese/jalapenos.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="gemuese1" value="bacon" onclick="ausgabe(value, name);"><img class="gemuese1" name="bacon" src="img/Gemuese/bacon.png" alt=""/></label>
            </div>
            <h2 class="uebers">Soße</h2>
            <hr align="left">
            <div id="sosse">
                <label><input type="checkbox" class="cbox" name="sosse1" value="ketchup" onclick="ausgabe(value, name);" checked><img class="sosse1" name="ketchup" id="start" src="img/Sosse/ketchup.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="sosse1" value="senf" onclick="ausgabe(value, name);"><img class="sosse1" name="senf" src="img/Sosse/senf.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="sosse1" value="sandwhischsauce" onclick="ausgabe(value, name);"><img class="sosse1" name="sandwhischsauce" src="img/Sosse/sandwhischsauce.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="sosse1" value="bigmacsauce" onclick="ausgabe(value, name);"><img class="sosse1" name="bigmacsauce" src="img/Sosse/bigmacsauce.png" alt=""/></label>
                <label><input type="checkbox" class="cbox" name="sosse1" value="gucamaole" onclick="ausgabe(value, name);"><img class="sosse1" name="gucamaole" src="img/Sosse/gucamaole.png" alt=""/></label>
            </div>
        </div>
        <div id="burger">
            <h3>Dein Burger:</h3>
            <div>
                <form action="save" method="post">
                    <input id="inputBrotOben" type="hidden" name="Brotoben" value="Briocheoben"><img id="brotoben" src="img/Brot/briocheoben.png"/></input>
                    <input id="inputsossebelag2" type="hidden" name="Sossebelag2" value="Leer"><img id="sossebelag2" src="img/Sosse/leer.png" alt=""/></input>
                    <input id="inputgemuesebelag7" type="hidden" name="Gemuesebelag7" value="Leer"><img id="gemuesebelag7" src="img/Gemuese/leer.png" alt=""/></input>
                    <input id="inputgemuesebelag6" type="hidden" name="Gemuesebelag6" value="Leer"><img id="gemuesebelag6" src="img/Gemuese/leer.png" alt=""/></input>
                    <input id="inputgemuesebelag5" type="hidden" name="Gemuesebelag5" value="Leer"><img id="gemuesebelag5" src="img/Gemuese/leer.png" alt=""/></input>
                    <input id="inputgemuesebelag4" type="hidden" name="Gemuesebelag4" value="Leer"><img id="gemuesebelag4" src="img/Gemuese/leer.png" alt=""/></input>
                    <input id="inputgemuesebelag3" type="hidden" name="Gemuesebelag3" value="Leer"><img id="gemuesebelag3" src="img/Gemuese/leer.png" alt=""/></input>
                    <input id="inputgemuesebelag2" type="hidden" name="Gemuesebelag2" value="Tomate"><img id="gemuesebelag2" src="img/Gemuese/tomate.png" alt="Tomate"/></input>
                    <input id="inputgemuesebelag1" type="hidden" name="Gemuesebelag1" value="Gurke"><img id="gemuesebelag1" src="img/Gemuese/gurke.png" alt="Gurke"/></input>
                    <input id="inputsalatbelag" type="hidden" name="Salatbelag" value="Salat"><img id="salatbelag" src="img/Salat/salat.png" alt="Salat"/></input>
                    <input id="inputkaesebelag3" type="hidden" name="Kaesebelag3" value="Leer"><img id="kaesebelag3" src="img/Kaese/leer.png" alt=""/></input>
                    <input id="inputkaesebelag2" type="hidden" name="Kaesebelag2" value="Leer"><img id="kaesebelag2" src="img/Kaese/leer.png" alt=""/></input>
                    <input id="inputkaesebelag1" type="hidden" name="Kaesebelag1" value="Cheese"><img id="kaesebelag1" src="img/Kaese/cheese.png" alt="Cheese"/></input>
                    <input id="inputfleischbelag3" type="hidden" name="Fleischbelag3" value="Leer"><img id="fleischbelag3" src="img/Fleisch/leer.png" alt=""/></input>
                    <input id="inputfleischbelag2" type="hidden" name="Fleischbelag2" value="Leer"><img id="fleischbelag2" src="img/Fleisch/leer.png" alt=""/></input>
                    <input id="inputfleischbelag1" type="hidden" name="Fleischbelag1" value="Newbeef"><img id="fleischbelag1" src="img/Fleisch/newbeef.png" alt="Newbeef"/></input>
                    <input id="inputsossebelag1" type="hidden" name="Sossebelag1" value="Ketchup"><img id="sossebelag1" src="img/Sosse/ketchup.png" alt="Ketchup"/></input>
                    <input id="inputBrotUnten" type="hidden" name="Brotunten" value="Briocheunten"><img id="brotunten" src="img/Brot/briocheunten.png" alt="Briocheunten"/></input>
                    <h4 id="burgerpreis">Preis: 4 €</h4>
                    <input id="preis" type="hidden" value="4"/>
                    <div class="save">
                        <input type="submit" name="submit" value="Speichern"/>
                        <input type="submit" name="submit" value="Bestellen"/>
                    </div>
                    <input type="hidden" name="username" value="<%= request.getAttribute("username") %>"/>
                </form>
            </div>
        </div>       
    </body>
</html>
