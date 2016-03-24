/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * jonas beschde
 */
/*aktuell2*/
var ausgabe = function(name, klasse) {
        
        var preis = parseFloat(document.getElementById("preis").value);
                
        if (klasse == "fleisch1" || klasse == "kaese1"){
            document.getElementsByName(klasse)[0].checked = true;
            document.getElementsByName(klasse)[1].checked = true;
            document.getElementsByName(klasse)[2].checked = true;
            if (klasse == "fleisch1") {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src != "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                if (zaehlen < 3) {
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                }
                else {
                    alert("Du darft maximal 3 Stueck Fleisch auswaehlen!");
                }
            }
            if (klasse == "kaese1") {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src != "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                if (zaehlen < 3) {
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                }
                else {
                    alert("Du darft maximal 3 Stueck Kaese auswaehlen!");
                }
            }
        }        
        else {
            document.getElementsByName(name)[0].style.borderColor = 'white';
        }
        if (!document.getElementsByName(klasse)[0].checked) {
            document.getElementsByClassName(klasse)[0].style.borderColor = 'transparent';
        }
        if (!document.getElementsByName(klasse)[1].checked) {
            document.getElementsByClassName(klasse)[1].style.borderColor = 'transparent';
        }
        if (!document.getElementsByName(klasse)[2].checked) {
            document.getElementsByClassName(klasse)[2].style.borderColor = 'transparent';
        }
        if (klasse == "gemuese1" || klasse == "sosse1") {
            if (!document.getElementsByName(klasse)[3].checked) {
                document.getElementsByClassName(klasse)[3].style.borderColor = 'transparent';
            }
            if (!document.getElementsByName(klasse)[4].checked) {
                document.getElementsByClassName(klasse)[4].style.borderColor = 'transparent';
            }
        }
        
        if (klasse == "gemuese1") {
            if (!document.getElementsByName(klasse)[5].checked) {
                document.getElementsByClassName(klasse)[5].style.borderColor = 'transparent';
            }
            if (!document.getElementsByName(klasse)[6].checked) {
                document.getElementsByClassName(klasse)[6].style.borderColor = 'transparent';
            }
        }
        
        if (klasse == "sosse1") {
            var zaehlen = 0;
            for (var i = 0; i < 5; i++) {
                if (document.getElementsByName(klasse)[i].checked) {
                    zaehlen = zaehlen + 1;
                }
            }
        }
                
        switch (name) {
            case "brioche": {
                document.getElementById("brotoben").src = "img/Brot/brioche_oben.png";
                document.getElementById("inputBrotOben").value = "Briocheoben";
                document.getElementById("brotunten").src = "img/Brot/brioche_unten.png";
                document.getElementById("inputBrotUnten").value = "Briocheunten";
                break;
            }
            case "bigmac": {
                document.getElementById("brotoben").src = "img/Brot/bigmacbun_oben.png";
                document.getElementById("inputBrotOben").value = "Bigmacoben";
                document.getElementById("brotunten").src = "img/Brot/bigmacbun_unten.png";
                document.getElementById("inputBrotUnten").value = "Bigmacunten";
                break;
            }
            case "dinkel": {
                document.getElementById("brotoben").src = "img/Brot/dinkel_oben.png";
                document.getElementById("inputBrotOben").value = "Dinkeloben";
                document.getElementById("brotunten").src = "img/Brot/dinkel_unten.png";
                document.getElementById("inputBrotUnten").value = "Dinkelunten";
                break;
            }
            case "newbeef": {                        
                if (document.getElementsByName(klasse)[0].checked) {
                    for (var i=1; i<=3; i++) {                                
                        if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("fleischbelag" + i).src = "img/Fleisch/newbeef.png";
                            document.getElementById("inputfleischbelag" + i).value = "Newbeef";
                            preis = preis + 2;
                            break;
                        }
                    }
                }
                break;
            }
            case "chicken": {                       
                if (document.getElementsByName(klasse)[1].checked) {
                    for (var i=1; i<=3; i++) {                                
                        if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("fleischbelag" + i).src = "img/Fleisch/chicken.png";
                            document.getElementById("inputfleischbelag" + i).value = "Chicken";
                            preis = preis + 2;
                            break;
                        }
                    }
                }
                break;
            }
            case "veggie": {                       
                if (document.getElementsByName(klasse)[2].checked) {
                    for (var i=1; i<=3; i++) {                                
                        if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("fleischbelag" + i).src = "img/Fleisch/veggie.png";
                            document.getElementById("inputfleischbelag" + i).value = "Veggie";
                            preis = preis + 2;
                            break;
                        }
                    }
                }
                break;
            }
            case "cheese": {                        
                if (document.getElementsByName(klasse)[0].checked) {
                    for (var i=1; i<=3; i++) {                                
                        if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("kaesebelag" + i).src = "img/Kaese/cheese.png";
                            document.getElementById("inputkaesebelag" + i).value = "Cheese";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "cheddar": {                       
                if (document.getElementsByName(klasse)[1].checked) {
                    for (var i=1; i<=3; i++) {                                
                        if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("kaesebelag" + i).src = "img/Kaese/cheddar.png";
                            document.getElementById("inputkaesebelag" + i).value = "Cheddar";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "emmentaler": {                       
                if (document.getElementsByName(klasse)[2].checked) {
                    for (var i=1; i<=3; i++) {                                
                        if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("kaesebelag" + i).src = "img/Kaese/emmentaler.png";
                            document.getElementById("inputkaesebelag" + i).value = "Emmentaler";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "salat": {                        
                if (document.getElementsByName(klasse)[0].checked) {
                    document.getElementsByClassName(klasse)[1].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[1].checked = false;
                    document.getElementsByClassName(klasse)[2].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[2].checked = false;
                    document.getElementById("salatbelag").src = "img/Salat/salat.png";
                    document.getElementById("inputsalatbelag").value = "Salat";
                }
                else {
                    document.getElementById("salatbelag").src = "img/leer.png";
                    document.getElementById("inputsalatbelag").value = "Leer";
                }
                break;
            }
            case "salatbun": {                        
                if (document.getElementsByName(klasse)[1].checked) {
                    document.getElementsByClassName(klasse)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[0].checked = false;
                    document.getElementsByClassName(klasse)[2].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[2].checked = false;
                    document.getElementById("salatbelag").src = "img/Salat/salatbun.png";
                    document.getElementById("inputsalatbelag").value = "Salatbun";
                }
                else {
                    document.getElementById("salatbelag").src = "img/leer.png";
                    document.getElementById("inputsalatbelag").value = "Leer";
                }
                break;
            }
            case "rucula": {                        
                if (document.getElementsByName(klasse)[2].checked) {
                    document.getElementsByClassName(klasse)[1].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[1].checked = false;
                    document.getElementsByClassName(klasse)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[0].checked = false;
                    document.getElementById("salatbelag").src = "img/Salat/rucula.png";
                    document.getElementById("inputsalatbelag").value = "Rucula";
                }
                else {
                    document.getElementById("salatbelag").src = "img/leer.png";
                    document.getElementById("inputsalatbelag").value = "Leer";
                }
                break;
            }
            case "tomate": {                        
                if (document.getElementsByName(klasse)[0].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/tomate.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Tomate";
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {                        
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/tomate.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            break;
                        }
                    }
                }
                break;
            }
            case "gurke": {                        
                if (document.getElementsByName(klasse)[1].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/gurke.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Gurke";
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/gurke.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            break;
                        }
                    }
                }
                break;
            }
            case "essiggurkerl": {                        
                if (document.getElementsByName(klasse)[2].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/essiggurkerl.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Essiggurkerl";
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/essiggurkerl.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            break;
                        }
                    }
                }
                break;
            }
            case "zwiebelrot": {                        
                if (document.getElementsByName(klasse)[3].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/zwiebelrot.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Zwiebelrot";
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/zwiebelrot.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            break;
                        }
                    }
                }
                break;
            }
            case "rostzwiebel": {                        
                if (document.getElementsByName(klasse)[4].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/rostzwiebel.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Rostzwiebel";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/rostzwiebel.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "jalapenos": {                        
                if (document.getElementsByName(klasse)[5].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/jalapenos.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Jalapenos";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/jalapenos.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "bacon": {                        
                if (document.getElementsByName(klasse)[6].checked) {
                    for (var i=1; i<=7; i++) {                                
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/Gemuese/bacon.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Bacon";
                            preis = preis + 1;
                            break;
                        }
                    }
                }
                else {
                    for (var i=7; i>=1; i--) {
                        if (document.getElementById("gemuesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Gemuese/bacon.png"){
                            document.getElementById("gemuesebelag" + i).src = "img/leer.png";
                            document.getElementById("inputgemuesebelag" + i).value = "Leer";
                            preis = preis - 1;
                            break;
                        }
                    }
                }
                break;
            }
            case "ketchup": {                        
                if (document.getElementsByName(klasse)[0].checked && zaehlen <= 2) {
                    for (var i=1; i<=2; i++) {                                
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("sossebelag" + i).src = "img/Sosse/ketchup.png";
                            document.getElementById("inputsossebelag" + i).value = "Ketchup";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else if (zaehlen > 2) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[0].checked = false;
                    alert("Du darfst nur maximal 2 Sossen auswaehlen!");
                }
                else {
                    for (var i=2; i>=1; i--) {                        
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Sosse/ketchup.png"){
                            document.getElementById("sossebelag" + i).src = "img/leer.png";
                            document.getElementById("inputsossebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "senf": {                        
                if (document.getElementsByName(klasse)[1].checked && zaehlen <= 2) {
                    for (var i=1; i<=2; i++) {                                
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("sossebelag" + i).src = "img/Sosse/senf.png";
                            document.getElementById("inputsossebelag" + i).value = "Senf";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else if (zaehlen > 2) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[1].checked = false;
                    alert("Du darfst nur maximal 2 Sossen auswaehlen!");
                }
                else {
                    for (var i=2; i>=1; i--) {                        
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Sosse/senf.png"){
                            document.getElementById("sossebelag" + i).src = "img/leer.png";
                            document.getElementById("inputsossebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "sandwhischsauce": {                        
                if (document.getElementsByName(klasse)[2].checked && zaehlen <= 2) {
                    for (var i=1; i<=2; i++) {                                
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("sossebelag" + i).src = "img/Sosse/sandwhischsauce.png";
                            document.getElementById("inputsossebelag" + i).value = "Sandwischsauce";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else if (zaehlen > 2) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[2].checked = false;
                    alert("Du darfst nur maximal 2 Sossen auswaehlen!");
                }
                else {
                    for (var i=2; i>=1; i--) {                        
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Sosse/sandwhischsauce.png"){
                            document.getElementById("sossebelag" + i).src = "img/leer.png";
                            document.getElementById("inputsossebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "bigmacsauce": {                        
                if (document.getElementsByName(klasse)[3].checked && zaehlen <= 2) {
                    for (var i=1; i<=2; i++) {                                
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("sossebelag" + i).src = "img/Sosse/bigmacsauce.png";
                            document.getElementById("inputsossebelag" + i).value = "Bigmacsauce";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else if (zaehlen > 2) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[3].checked = false;
                    alert("Du darfst nur maximal 2 Sossen auswaehlen!");
                }
                else {
                    for (var i=2; i>=1; i--) {                        
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Sosse/bigmacsauce.png"){
                            document.getElementById("sossebelag" + i).src = "img/leer.png";
                            document.getElementById("inputsossebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
            case "gucamaole": {                        
                if (document.getElementsByName(klasse)[4].checked && zaehlen <= 2) {
                    for (var i=1; i<=2; i++) {                                
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                            document.getElementById("sossebelag" + i).src = "img/Sosse/gucamaole.png";
                            document.getElementById("inputsossebelag" + i).value = "Gucamaole";
                            preis = preis + 0.5;
                            break;
                        }
                    }
                }
                else if (zaehlen > 2) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[4].checked = false;
                    alert("Du darfst nur maximal 2 Sossen auswaehlen!");
                }
                else {
                    for (var i=2; i>=1; i--) {                        
                        if (document.getElementById("sossebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Sosse/gucamaole.png"){
                            document.getElementById("sossebelag" + i).src = "img/leer.png";
                            document.getElementById("inputsossebelag" + i).value = "Leer";
                            preis = preis - 0.5;
                            break;
                        }
                    }
                }
                break;
            }
        }
        
        document.getElementById("preis").value = preis;
        document.getElementById("burgerpreis").innerHTML = 'Preis: '+preis+' €'
               
};

var plus = function(name, klasse){
    
    var preis = parseFloat(document.getElementById("preis").value);
    
    if (klasse == "fleisch1") {
        var zaehlen = 0;
        for (var i=1; i<=3; i++) {                                
            if (document.getElementById("fleischbelag" + i).src != "http://localhost:8080/BCBurger2-war/img/leer.png"){
                zaehlen = zaehlen + 1;
            }
        }
    }
    if (klasse == "kaese1") {
        var zaehlen = 0;
        for (var i=1; i<=3; i++) {                                
            if (document.getElementById("kaesebelag" + i).src != "http://localhost:8080/BCBurger2-war/img/leer.png"){
                zaehlen = zaehlen + 1;
            }
        }
    }
    if (zaehlen < 3){
        switch(name){
            case "newbeef": { 
                var zaehlen2 = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/newbeef.png"){
                        zaehlen2 = zaehlen2 + 1;
                    }
                }
                if (zaehlen2 == 0){
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                    document.getElementsByName(klasse)[0].checked = true;
                }
                
                for (var i = 1; i <= 3; i++){  
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        document.getElementById("fleischbelag" + i).src = "img/Fleisch/newbeef.png";
                        document.getElementById("inputfleischbelag" + i).value = "Newbeef";
                        preis = preis + 2;
                        break;
                    }    
                }
                break;
            }
            case "chicken": {
                    
                var zaehlen2 = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/chicken.png"){
                        zaehlen2 = zaehlen2 + 1;
                    }
                }
                if (zaehlen2 == 0){
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                    document.getElementsByName(klasse)[0].checked = true;
                }
                
                for (var i = 1; i <= 3; i++){  
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        document.getElementById("fleischbelag" + i).src = "img/Fleisch/chicken.png";
                        document.getElementById("inputfleischbelag" + i).value = "Chicken";
                        preis = preis + 2;
                        break;
                    }    
                }
                break;
            }
            case "veggie": {
                var zaehlen2 = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/veggie.png"){
                        zaehlen2 = zaehlen2 + 1;
                    }
                }
                if (zaehlen2 == 0){
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                    document.getElementsByName(klasse)[0].checked = true;
                }
                
                for (var i = 1; i <= 3; i++){  
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        document.getElementById("fleischbelag" + i).src = "img/Fleisch/veggie.png";
                        document.getElementById("inputfleischbelag" + i).value = "Veggie";
                        preis = preis + 2;
                        break;
                    }    
                }
                break;
            }
            case "cheese": {
                var zaehlen2 = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/cheese.png"){
                        zaehlen2 = zaehlen2 + 1;
                    }
                }
                if (zaehlen2 == 0){
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                    document.getElementsByName(klasse)[0].checked = true;
                }    
                 
                for (var i = 1; i <= 3; i++){  
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        document.getElementById("kaesebelag" + i).src = "img/Kaese/cheese.png";
                        document.getElementById("inputkaesebelag" + i).value = "Cheese";
                        preis = preis + 0.5;
                        break;
                    }    
                }
                break;   
            }
            case "cheddar": {
                var zaehlen2 = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/cheddar.png"){
                        zaehlen2 = zaehlen2 + 1;
                    }
                }
                if (zaehlen2 == 0){
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                    document.getElementsByName(klasse)[0].checked = true;
                }     
                    
                for (var i = 1; i <= 3; i++){  
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        document.getElementById("kaesebelag" + i).src = "img/Kaese/cheddar.png";
                        document.getElementById("inputkaesebelag" + i).value = "Cheddar";
                        preis = preis + 0.5;
                        break;
                    }    
                }
                break;    
            }
            case "emmentaler": {
                var zaehlen2 = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/emmentaler.png"){
                        zaehlen2 = zaehlen2 + 1;
                    }
                }
                if (zaehlen2 == 0){
                    document.getElementsByName(name)[0].style.borderColor = 'white';
                    document.getElementsByName(klasse)[0].checked = true;
                }     
                    
                for (var i = 1; i <= 3; i++){  
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/leer.png"){
                        document.getElementById("kaesebelag" + i).src = "img/Kaese/emmentaler.png";
                        document.getElementById("inputkaesebelag" + i).value = "Emmentaler";
                        preis = preis + 0.5;
                        break;
                    }    
                }
                break;    
            }
        }
    }
    else {
        if (klasse == "fleisch1"){
            alert("Du darft maximal 3 Stueck Fleisch auswaehlen!");
        }
        else {
            alert("Du darft maximal 3 Stueck Kaese auswaehlen!");
        }
    }
    document.getElementById("preis").value = preis;
    document.getElementById("burgerpreis").innerHTML = 'Preis: '+preis+' €'
};

var minus = function(name, klasse){
    
    var preis = parseFloat(document.getElementById("preis").value);
    
    if (klasse == "fleisch1") {
        switch (name){
            case "newbeef": {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/newbeef.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                
                for (var i=3; i >= 1; i--) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/newbeef.png"){
                        document.getElementById("fleischbelag" + i).src = "img/leer.png";
                        document.getElementById("inputfleischbelag" + i).value = "Leer";
                        preis = preis - 2;
                        break;
                    }
                }
                if (zaehlen == 1) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[0].checked = false;
                }
                break;
            }
            case "chicken": {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/chicken.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                for (var i=3; i >= 1; i--) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/chicken.png"){
                        document.getElementById("fleischbelag" + i).src = "img/leer.png";
                        document.getElementById("inputfleischbelag" + i).value = "Leer";
                        preis = preis - 2;
                        break;
                    }
                }
                if (zaehlen == 1) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[1].checked = false;
                }
                break;
            }
            case "veggie": {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/veggie.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                for (var i=3; i >= 1; i--) {                                
                    if (document.getElementById("fleischbelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Fleisch/veggie.png"){
                        document.getElementById("fleischbelag" + i).src = "img/leer.png";
                        document.getElementById("inputfleischbelag" + i).value = "Leer";
                        preis = preis - 2;
                        break;
                    }
                }
                if (zaehlen == 1) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[2].checked = false;
                }
                break;
            }
        }    
    }
    if (klasse == "kaese1") {
        switch (name){
            case "cheese": {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/cheese.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                
                for (var i=3; i >= 1; i--) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/cheese.png"){
                        document.getElementById("kaesebelag" + i).src = "img/leer.png";
                        document.getElementById("inputkaesebelag" + i).value = "Leer";
                        preis = preis - 0.5;
                        break;
                    }
                }
                if (zaehlen == 1) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[0].checked = false;
                }
                break;
            }
            case "cheddar": {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/cheddar.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                
                for (var i=3; i >= 1; i--) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/cheddar.png"){
                        document.getElementById("kaesebelag" + i).src = "img/leer.png";
                        document.getElementById("inputkaesebelag" + i).value = "Leer";
                        preis = preis - 0.5;
                        break;
                    }
                }
                if (zaehlen == 1) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[1].checked = false;
                }
                break;
            }
            case "emmentaler": {
                var zaehlen = 0;
                for (var i=1; i<=3; i++) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/emmentaler.png"){
                        zaehlen = zaehlen + 1;
                    }
                }
                
                for (var i=3; i >= 1; i--) {                                
                    if (document.getElementById("kaesebelag" + i).src == "http://localhost:8080/BCBurger2-war/img/Kaese/emmentaler.png"){
                        document.getElementById("kaesebelag" + i).src = "img/leer.png";
                        document.getElementById("inputkaesebelag" + i).value = "Leer";
                        preis = preis - 0.5;
                        break;
                    }
                }
                if (zaehlen == 1) {
                    document.getElementsByName(name)[0].style.borderColor = 'transparent';
                    document.getElementsByName(klasse)[2].checked = false;
                }
                break;
            }
        }    
    }
    
    document.getElementById("preis").value = preis;
    document.getElementById("burgerpreis").innerHTML = 'Preis: '+preis+' €'
};


