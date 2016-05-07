package controller;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.entity.Bestellung;
import model.entity.Burger;
import model.entity.Burgerzutaten;
import model.entity.Warenkorb;
import model.facade.BenutzerFacadeLocal;
import model.facade.BestellungFacadeLocal;
import model.facade.BurgerFacadeLocal;
import model.facade.BurgerzutatenFacadeLocal;
import model.facade.WarenkorbFacadeLocal;
import model.facade.ZutatenFacadeLocal;

/**
 * @ ZutatenFacadeLocallasse enthält Methoden um konfigurierte Burger speichern und bestellen, sowie Änderungen an der Bestellung vornehmen zu können
 * @author Florian
 */
@Stateless
public class SaveBean implements SaveBeanLocal {
@EJB
BenutzerFacadeLocal benutzerFacade;
@EJB
BurgerFacadeLocal burgerFacade;
@EJB
BurgerzutatenFacadeLocal burgerzutatenFacade;
@EJB
ZutatenFacadeLocal zutatenFacade;
@EJB
WarenkorbFacadeLocal warenkorbFacade;
@EJB
BestellungFacadeLocal bestellungFacade;

    /**
     * @desc Methode speichert konfigurierten Burger mit Name des Burger, dem errechneten Gesamtpreis und Zuordnung zum Benutzer
     * @param b1
     * @param b2
     * @param b3
     * @param b4
     * @param b5
     * @param b6
     * @param b7
     * @param b8
     * @param b9
     * @param b10
     * @param b11
     * @param b12
     * @param b13
     * @param b14
     * @param b15
     * @param b16
     * @param b17
     * @param b18
     * @param benutzername
     * @param burgername
     */
    @Override
public void performSave(String b1, String b2, String b3, String b4, String b5, 
                        String b6, String b7, String b8, String b9, String b10, 
                        String b11, String b12, String b13, String b14, String b15, 
                        String b16, String b17, String b18, String benutzername, String burgername ){
  
 //Zuordunung des übergebene Benutzernamen zur benutzerId  
    benutzername = benutzername.toLowerCase();
    int userid = benutzerFacade.getBenutzerIdByBenutzerName(benutzername);
    
//Zuordnung der übergebenen Bezeichnungen der Zutaten zu den zutatenIds
    int zID1 = zutatenFacade.getZutatenIdByBez(b1);
    int zID2 = zutatenFacade.getZutatenIdByBez(b2);
    int zID3 = zutatenFacade.getZutatenIdByBez(b3);
    int zID4 = zutatenFacade.getZutatenIdByBez(b4);
    int zID5 = zutatenFacade.getZutatenIdByBez(b5);
    int zID6 = zutatenFacade.getZutatenIdByBez(b6);
    int zID7 = zutatenFacade.getZutatenIdByBez(b7);
    int zID8 = zutatenFacade.getZutatenIdByBez(b8);
    int zID9 = zutatenFacade.getZutatenIdByBez(b9);
    int zID10 = zutatenFacade.getZutatenIdByBez(b10);
    int zID11 = zutatenFacade.getZutatenIdByBez(b11);
    int zID12 = zutatenFacade.getZutatenIdByBez(b12);
    int zID13 = zutatenFacade.getZutatenIdByBez(b13);
    int zID14 = zutatenFacade.getZutatenIdByBez(b14);
    int zID15 = zutatenFacade.getZutatenIdByBez(b15);
    int zID16 = zutatenFacade.getZutatenIdByBez(b16);
    int zID17 = zutatenFacade.getZutatenIdByBez(b17);
    int zID18 = zutatenFacade.getZutatenIdByBez(b18);
    
    //ZutatenIds eines Burgers in Tabelle burgerzutaten speichern
    //Rückgabewert burgerzutatenID dient zur Zuordnung der Burgerzutaten des Burger
    int bzid = burgerzutatenFacade.save( zID1, zID2, zID3, zID4, zID5, 
                                         zID6, zID7, zID8, zID9, zID10, 
                                         zID11, zID12, zID13, zID14, zID15, 
                                         zID16, zID17, zID18);
    
    //Burgerpreis mit Hilfe der Bezeichnungen der Zutaten errechnen
    double burgerpreis = zutatenFacade.getBurgerPreis(b1, b2, b3, b4, b5, 
                                                      b6, b7, b8, b9, b10, 
                                                      b11, b12, b13, b14, b15, 
                                                      b16, b17, b18);
    
//BurgerzutatenId, Burgerpreis, Name des Burger und BenutzerId in Tabelle Burger speichern
    int bid = burgerFacade.saveBurger(bzid, burgerpreis, burgername, userid);
   
}

    /**
     * @desc Methode ermittelt alle vom Benutzer konfigurierten Burger
     * @param benutzername
     * @return Mehrdimensionales Array, das für jeden Burger alle Zutaten, sowie den Name den Preis und die ID des Burgers enthält
     */
        @Override
    public String[][] getSaveBurger(String benutzername){
        //Zuordunung des übergebene Benutzernamen zur benutzerId 
        int userid = benutzerFacade.getBenutzerIdByBenutzerName(benutzername);
        //Zuordnung der BurgerIds die beim übergebene Benutzer zugeordnet sind
        int[] bidList = burgerFacade.getBurgerIdByBenutzerId(userid);
        //Erzeugen eines neuen mehrdimensionalen Array das genau so viele Burger enhält, wie dem übergeben Benutzer zugeordnet sind
        String [][] saveburger = new String[bidList.length][21];
        
        Burgerzutaten bz;
        Burger burger;
        //Für jeden Burger der dem Benutzer zugeordnet ist
         for(int i=0; i< bidList.length; i++){
            //Lokales BurgerObjekt anhand der BurgerId finden
            burger = burgerFacade.find(bidList[i]);
            //BurgerzutatneObjekt welches über die BurgerzutatenId dem BurgerObjekt zugeordent ist finden
            bz = burgerzutatenFacade.find(burger.getBurgerzutatenId());
            
            //Einzelne Bezeichnung der Zutaten über die ZutatenId ermitteln und in Array speichern
            //BurgerzutatenObjekt liefert die eizelnen ZutatenIds
            saveburger[i][0] = zutatenFacade.getBezByZutatenId(bz.getZid1());
            saveburger[i][1] = zutatenFacade.getBezByZutatenId(bz.getZid2());
            saveburger[i][2] = zutatenFacade.getBezByZutatenId(bz.getZid3());
            saveburger[i][3] = zutatenFacade.getBezByZutatenId(bz.getZid4());
            saveburger[i][4] = zutatenFacade.getBezByZutatenId(bz.getZid5());
            saveburger[i][5] = zutatenFacade.getBezByZutatenId(bz.getZid6());
            saveburger[i][6] = zutatenFacade.getBezByZutatenId(bz.getZid7());
            saveburger[i][7] = zutatenFacade.getBezByZutatenId(bz.getZid8());
            saveburger[i][8] = zutatenFacade.getBezByZutatenId(bz.getZid9());
            saveburger[i][9] = zutatenFacade.getBezByZutatenId(bz.getZid10());
            saveburger[i][10] = zutatenFacade.getBezByZutatenId(bz.getZid11());
            saveburger[i][11] = zutatenFacade.getBezByZutatenId(bz.getZid12());
            saveburger[i][12] = zutatenFacade.getBezByZutatenId(bz.getZid13());
            saveburger[i][13] = zutatenFacade.getBezByZutatenId(bz.getZid14());
            saveburger[i][14] = zutatenFacade.getBezByZutatenId(bz.getZid15());
            saveburger[i][15] = zutatenFacade.getBezByZutatenId(bz.getZid16());
            saveburger[i][16] = zutatenFacade.getBezByZutatenId(bz.getZid17());
            saveburger[i][17] = zutatenFacade.getBezByZutatenId(bz.getZid18());
            //Burgerpreis durch BurgerId ermitten und in Array speichern
            saveburger[i][18] = "" + burgerFacade.getPreisByBurgerId(bidList[i]) + "0€";
           //BurgerId in Array speichern 
            saveburger[i][19] = "" + bidList[i];
            //Name des Burgers durch BurgerId ermiteln und in Array speichern
            saveburger[i][20] = "" + burgerFacade.getNameByBurgerId(bidList[i]);
            
         }
       return saveburger;
    }
   
    /**
     * @desc Methode löscht Burger aus der Datenbank
     * @param bid burgerId
     */
        @Override
    public void deleteBurger(int bid){
      //BurgerObjekt zur BurgerId ermitteln
      Burger bur = burgerFacade.find(bid);
      //urgerzutatenId zum BurgerObjekt ermitteln
      int bzid = bur.getBurgerzutatenId();
      //BurgerzutatenObjekt zur burgerzutatenId ermitteln
      Burgerzutaten bz = burgerzutatenFacade.find(bzid);
      //BurgerzutatenObjekt aus Tabelle Burgerzutaten löschen
      burgerzutatenFacade.remove(bz);
      //BurgerObjekt aus Tabelle Burger löschen
      burgerFacade.remove(bur);
  
    }

    /**
     * @desc Methode speichert konfigurierten Burger und legt für den Benutzer und den Burger eine Bestellung und einen Warenkorb an
     * @param b1 Bezeichnung der ersten Zutat des Burgers
     * @param b2 Bezeichnung der zweiten Zutat des Burgers usw.
     * @param b3
     * @param b4
     * @param b5
     * @param b6
     * @param b7
     * @param b8
     * @param b9
     * @param b10
     * @param b11
     * @param b12
     * @param b13
     * @param b14
     * @param b15
     * @param b16
     * @param b17
     * @param b18
     * @param benutzername
     * @param burgername
     */
    @Override
    public void performOrder(String b1, String b2, String b3, String b4, String b5, 
                             String b6, String b7, String b8, String b9, String b10, 
                             String b11, String b12, String b13, String b14, String b15, 
                             String b16, String b17, String b18, String benutzername, String burgername){
    
//Zuordunung des übergebene Benutzernamen zur benutzerId  
    benutzername = benutzername.toLowerCase();
    int userid = benutzerFacade.getBenutzerIdByBenutzerName(benutzername);
    
//Zuordnung der übergebenen Bezeichnungen der Zutaten zu den zutatenIds
    int zID1 = zutatenFacade.getZutatenIdByBez(b1);
    int zID2 = zutatenFacade.getZutatenIdByBez(b2);
    int zID3 = zutatenFacade.getZutatenIdByBez(b3);
    int zID4 = zutatenFacade.getZutatenIdByBez(b4);
    int zID5 = zutatenFacade.getZutatenIdByBez(b5);
    int zID6 = zutatenFacade.getZutatenIdByBez(b6);
    int zID7 = zutatenFacade.getZutatenIdByBez(b7);
    int zID8 = zutatenFacade.getZutatenIdByBez(b8);
    int zID9 = zutatenFacade.getZutatenIdByBez(b9);
    int zID10 = zutatenFacade.getZutatenIdByBez(b10);
    int zID11 = zutatenFacade.getZutatenIdByBez(b11);
    int zID12 = zutatenFacade.getZutatenIdByBez(b12);
    int zID13 = zutatenFacade.getZutatenIdByBez(b13);
    int zID14 = zutatenFacade.getZutatenIdByBez(b14);
    int zID15 = zutatenFacade.getZutatenIdByBez(b15);
    int zID16 = zutatenFacade.getZutatenIdByBez(b16);
    int zID17 = zutatenFacade.getZutatenIdByBez(b17);
    int zID18 = zutatenFacade.getZutatenIdByBez(b18);
    
    //ZutatenIds eines Burgers in Tabelle burgerzutaten speichern
    //Rückgabewert burgerzutatenID dient zur Zuordnung der Burgerzutaten des Burger
    int bzid = burgerzutatenFacade.save( zID1, zID2, zID3, zID4, zID5, 
                                         zID6, zID7, zID8, zID9, zID10, 
                                         zID11, zID12, zID13, zID14, zID15, 
                                         zID16, zID17, zID18);
    
    //Burgerpreis mit Hilfe der Bezeichnungen der Zutaten errechnen
    double burgerpreis = zutatenFacade.getBurgerPreis(b1, b2, b3, b4, b5, 
                                                      b6, b7, b8, b9, b10, 
                                                      b11, b12, b13, b14, b15, 
                                                      b16, b17, b18);
    
//BurgerzutatenId, Burgerpreis, Name des Burger und BenutzerId in Tabelle Burger speichern und die zurgeordnete BurgerId zurückgegeben
    int bid = burgerFacade.saveBurger(bzid, burgerpreis, burgername, userid);
    
    int zaehlen = 0;
//Anzahl Bestellungen finden 
    List<Bestellung> bestList = bestellungFacade.findAll();
    for(Bestellung current: bestList){
        zaehlen++;
    }
    //Falls noch keine Bestellung vorhanden ist, neues BestellungsObjekt und Warenkorbobjekt für Benutzer erzeugen
    if(zaehlen == 0){
        //Neues BestellungsObjekt mit Zuordnung zur benutzerId erzeugen
        Bestellung best = new Bestellung(userid);
        bestellungFacade.create(best);
        //Neues WarenkorbObjekt mit Zuordnung zur bestellungsid, burgerId und Menge des Burgers ist 1, erzeugen
        //Warenkorb enthält somit den gerade konfigurierten Burger mit der Menge 1
        Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
        warenkorbFacade.create(wk);
        //Gesamtpreis für Bestellung setzen
        //Gesmtpreis über BestellungId ermitteln
        best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
    }
    //Für jedes BestellungsObjekt prüfen ob es der benutzerId zugeordent ist, die übergeben wurde
    for(Bestellung current: bestList){
        if(current.getBenutzerId().equals(userid)){
           //Falls ja, wird ein neues WarenkorbObjekt mit Zuordnung zur bestellungsid, burgerId, Menge des Burgers ist 1, erzeugt
           //Warenkorb enthält somit den gerade konfigurierten Burger mit der Menge 1
           Warenkorb wk = new Warenkorb(current.getBestellungId(),bid, 1);
           warenkorbFacade.create(wk);
           //Gesamtpreis für Bestellung setzen
           //Gesmtpreis über BestellungId ermitteln
           current.setBestellungPreis(this.getGesPreis(current.getBestellungId()));
        }
        else{
             //Falls nicht, wird eine neues BestellungsObjekt mit Zuordnung zur übergebenen benutzerId erzeugt
             Bestellung best = new Bestellung(userid);
             bestellungFacade.create(best);
             //Neues WarenkorbObjekt mit Zuordnung zur bestellungsid, burgerId, Menge des Burgers ist 1, erzeugen
             //Warenkorb enthält somit den gerade konfigurierten Burger mit der Menge 1
             Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
             warenkorbFacade.create(wk);
             //Gesamtpreis für Bestellung setzen
             //Gesmtpreis über BestellungId ermitteln
             best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
        }
    }
}
   
    /**
     * @desc Method  legt eine Bestellung und einen Warenkorb für den Benutzer und den Burger an
     * @param benutzername
     * @param burgername
     */
    @Override
    public void performOrder(int bid, String benutzername, String burgername){
    
    //Zuordunung des übergebene Benutzernamen zur benutzerId  
    benutzername = benutzername.toLowerCase();
    int userid = benutzerFacade.getBenutzerIdByBenutzerName(benutzername);
    int zaehlen = 0;
    
    //Anzahl Bestellungen finden
    List<Bestellung> bestList = bestellungFacade.findAll();
    for(Bestellung current: bestList){
        zaehlen++;
    }
  
    //Falls noch keine Bestellung vorhanden ist, neues BestellungsObjekt und Warenkorbobjekt für Benutzer erzeugen
    if(zaehlen == 0){
        //Neues BestellungsObjekt mit Zuordnung zur benutzerId erzeugen
        Bestellung best = new Bestellung(userid);
        bestellungFacade.create(best);
        //Neues WarenkorbObjekt mit Zuordnung zur bestellungsid, burgerId und Menge des Burgers ist 1, erzeugen
        //Warenkorb enthält somit den gerade konfigurierten Burger mit der Menge 1
        Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
        warenkorbFacade.create(wk);
        //Gesamtpreis für Bestellung setzen
        //Gesmtpreis über BestellungId ermitteln
        best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
    }      
     //Für jedes BestellungsObjekt prüfen ob es der benutzerId zugeordent ist, die übergeben wurde    
    for(Bestellung current: bestList){
        if(current.getBenutzerId().equals(userid)){
        //Falls ja, wird ein neues WarenkorbObjekt mit Zuordnung zur bestellungsid, burgerId, Menge des Burgers ist 1, erzeugt
        //Warenkorb enthält somit den gerade konfigurierten Burger mit der Menge 1
           Warenkorb wk = new Warenkorb(current.getBestellungId(),bid, 1);
           warenkorbFacade.create(wk);
           //Gesamtpreis für Bestellung setzen
           //Gesmtpreis über BestellungId ermitteln
           current.setBestellungPreis(this.getGesPreis(current.getBestellungId()));
        }
        else{
             //Falls nicht, wird eine neues BestellungsObjekt mit Zuordnung zur übergebenen benutzerId erzeugt 
             Bestellung best = new Bestellung(userid);
             bestellungFacade.create(best);
             //Neues WarenkorbObjekt mit Zuordnung zur bestellungsid, burgerId, Menge des Burgers ist 1, erzeugen
             //Warenkorb enthält somit den gerade konfigurierten Burger mit der Menge 1
             Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
             warenkorbFacade.create(wk);
             //Gesamtpreis für Bestellung setzen
             //Gesmtpreis über BestellungId ermitteln
             best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
        }
    }
    }
   
    /**
     * @desc Methode ändert die Menge eines Burgers im Warenkorb
     * @param bid burgerId
     * @param menge
     */
    @Override
     public void changeMenge(int bid, int menge){
       Bestellung best;
       List<Warenkorb> wk = warenkorbFacade.findAll();
       //Prüfe für jedes WarekorbObjekt, ob die übergeben BurgerId enthalten ist
       for(Warenkorb current: wk){
         if(current.getBurgerId().equals(bid)){
             //Falls ja, ändere die Menge des WarenkorbObjektes auf die übergeben Menge
             current.setMenge(menge);
             //Finde BestellungObjekt, das dem WarenkorbObjekt zugeordnet ist
             best = bestellungFacade.find(current.getBestellungId());
             //Neues Gesamtpreis für das BetsellObjekt setzten
             //Neuen Gesamtpreis über bestellungId ermitteln
             best.setBestellungPreis(this.getGesPreis(current.getBestellungId()) );
         }
       }
    }
   
     /**
     * @des Methode ermittelt die Burger die sich im Warenkorb eines Benutzers befinden
     * @param benutzername
     * @return Mehrdimensionales Array das für jeden Burger die einzelnen Zutaten, 
     * den Namen, den Preis und die ID des Burgers, sowie die Menge des Burgers im Warenkorb, enthält
     */
        @Override
    public String[][] getBurgerInWarenkorb(String benutzername){
        int bestid = -1;
        //Zuordunung des übergebene Benutzernamen zur benutzerId  
        int userid = benutzerFacade.getBenutzerIdByBenutzerName(benutzername);
       
        List<Bestellung> bestList = bestellungFacade.findAll();
        //Prüfe für alle BestellungsObjekte, ob sie die zugeordnete benutzerId enhalten
        for(Bestellung current: bestList){
        //Falls ja, BestellungId in Variable speichern
           if(current.getBenutzerId().equals(userid)){
               bestid = current.getBestellungId();
           }
       }
        //Array enthält alle burgerIds die der BestellunId zugrordnet sind
        int[] bidList = warenkorbFacade.getBurgerIdByBestellungId(bestid);
        //Erzeugen eines neuen mehrdimensionalen Array das genau so viele Burger enhält, wie dem übergeben Benutzer zugeordnet sind
        String [][] burgerinwarenkorb= new String[bidList.length][22];
        
        Burgerzutaten bz;
        Burger burger;
            
         //Für jeden Burger der Bestellung zugeordnet ist
         for(int i=0; i< bidList.length; i++){
            //Lokales BurgerObjekt anhand der BurgerId finden
            burger = burgerFacade.find(bidList[i]);
            //BurgerzutatneObjekt welches über die BurgerzutatenId dem BurgerObjekt zugeordent ist finden
            bz = burgerzutatenFacade.find(burger.getBurgerzutatenId());
            //Einzelne Bezeichnung der Zutaten über die ZutatenId ermitteln und in Array speichern
            //BurgerzutatenObjekt liefert die eizelnen ZutatenIds  
            burgerinwarenkorb[i][0] = zutatenFacade.getBezByZutatenId(bz.getZid1());
            burgerinwarenkorb[i][1] = zutatenFacade.getBezByZutatenId(bz.getZid2());
            burgerinwarenkorb[i][2] = zutatenFacade.getBezByZutatenId(bz.getZid3());
            burgerinwarenkorb[i][3] = zutatenFacade.getBezByZutatenId(bz.getZid4());
            burgerinwarenkorb[i][4] = zutatenFacade.getBezByZutatenId(bz.getZid5());
            burgerinwarenkorb[i][5] = zutatenFacade.getBezByZutatenId(bz.getZid6());
            burgerinwarenkorb[i][6] = zutatenFacade.getBezByZutatenId(bz.getZid7());
            burgerinwarenkorb[i][7] = zutatenFacade.getBezByZutatenId(bz.getZid8());
            burgerinwarenkorb[i][8] = zutatenFacade.getBezByZutatenId(bz.getZid9());
            burgerinwarenkorb[i][9] = zutatenFacade.getBezByZutatenId(bz.getZid10());
            burgerinwarenkorb[i][10] = zutatenFacade.getBezByZutatenId(bz.getZid11());
            burgerinwarenkorb[i][11] = zutatenFacade.getBezByZutatenId(bz.getZid12());
            burgerinwarenkorb[i][12] = zutatenFacade.getBezByZutatenId(bz.getZid13());
            burgerinwarenkorb[i][13] = zutatenFacade.getBezByZutatenId(bz.getZid14());
            burgerinwarenkorb[i][14] = zutatenFacade.getBezByZutatenId(bz.getZid15());
            burgerinwarenkorb[i][15] = zutatenFacade.getBezByZutatenId(bz.getZid16());
            burgerinwarenkorb[i][16] = zutatenFacade.getBezByZutatenId(bz.getZid17());
            burgerinwarenkorb[i][17] = zutatenFacade.getBezByZutatenId(bz.getZid18());
            //Burgerpreis durch BurgerId ermitten und in Array speichern
            burgerinwarenkorb[i][18] = "" + burgerFacade.getPreisByBurgerId(bidList[i]) + "0€";
            //BurgerId in Array speichern 
            burgerinwarenkorb[i][19] = "" + bidList[i];
            //Name des Burgers durch BurgerId ermiteln und in Array speichern
            burgerinwarenkorb[i][20] = "" + burgerFacade.getNameByBurgerId(bidList[i]);
            //Menge des Burgers durch BurgerId ermiteln und in Array speichern
            burgerinwarenkorb[i][21] = "" + warenkorbFacade.getMengeByBurgerId(bidList[i]);
         }
       //Mehrdimensionales Array zurückliefern
       return burgerinwarenkorb;
    }
    /**
     * @desc Methode löscht Burger aus Warenkorb
     * @param bid burgerId
     */
        @Override
    public void deleteBurgerInWarenkorb(int bid){
      Bestellung best;
      double preis;
      List<Warenkorb> wk = warenkorbFacade.findAll();
      //Prüfe für alle Warenkorbobjekte, ob sie die übergeben BurgerId enhalten
      for(Warenkorb current: wk){
         if(current.getBurgerId().equals(bid)){
             //Falls ja lösche das WarenkorbObjekt
             warenkorbFacade.remove(current);
             //Find Bestellobjekt das WarenkorbObjekt zugeordent ist
             best = bestellungFacade.find(current.getBestellungId());
             //Neues Gesamtpreis für das BetsellObjekt setzten
             //Neuen Gesamtpreis über bestellungId ermitteln
             best.setBestellungPreis(this.getGesPreis(current.getBestellungId()));
         }
      }
    }

 
    /**
     * @desc Methode ermittelt Gesamtpreis einer Bestellung
     * @param bestid bestellungId
     * @return
     */
        @Override 
    public double getGesPreis(int bestid){
        double gespreis = 0;
        double burgerpreis;
        
        List<Warenkorb> wk = warenkorbFacade.findAll();
        //Prüfe für alle Warenkorbobjekte, ob sie die übergeben BestellungId enhalten
        for(Warenkorb current: wk){
            if(current.getBestellungId().equals(bestid)){
                //Falls ja, wird der Preis des Burgers der dem WarenkorbObjekt zugeordnet ist ermittelt
                burgerpreis = burgerFacade.getPreisByBurgerId(current.getBurgerId());
                //Errechnung des Gesamtpreises durch ermittelte Burgerpreis mal Menge die im WarenkorbObjekt dem Burger zugeordnet ist
                gespreis = gespreis + burgerpreis * current.getMenge();
            }
        }
        return gespreis;
    }

 
    
    /**
     * @desc Methode ermittelt Bestellung eines Benutzers 
     * @param benutzername
     * @return bestellungId
     */
    @Override
    public int getBestellungIdByBenutzername(String benutzername){
       int bestid = -1;
       //Zuordnung BenutzerId zu übergebenem Benutzernamen
       int userid = benutzerFacade.getBenutzerIdByBenutzerName(benutzername);
        
        List<Bestellung> bestList = bestellungFacade.findAll();
        //Prüfe für all BestellungsObjekte ob sie der BenutzerId zugeordnet sind
        for(Bestellung current : bestList){
            //Falls ja, ermittle BetstellungId des BestellungsObjektes
            if(current.getBenutzerId().equals(userid))
               bestid = current.getBestellungId();
        }
        //Rückgabe der ermittelten BetsellungId
        return bestid;
    }
}
