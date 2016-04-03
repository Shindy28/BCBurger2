/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.entity.Benutzer;
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
 *
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


@Override
public void performSave(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18, String username, String burgername ){
    
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
    
    username = username.toLowerCase();
    int userid = benutzerFacade.getBenutzerIdByBenutzerName(username);
    
    int bzid = burgerzutatenFacade.save( zID1, zID2, zID3, zID4, zID5, zID6, zID7, zID8, zID9, zID10, zID11, zID12, zID13, zID14, zID15, zID16, zID17, zID18);
    
    double burgerpreis = zutatenFacade.getBurgerPreis(b1, b2, b3, b4, b5, b6 , b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18);

    int bid = burgerFacade.saveBurger(bzid, burgerpreis, burgername, userid);
   
}

    @Override
    public String[][] getSaveBurger(String username){
         
        int userid = benutzerFacade.getBenutzerIdByBenutzerName(username);
        
        int[] bidList = burgerFacade.getBurgerIdByBenutzerId(userid);
        String [][] saveburger = new String[bidList.length][21];
        
        Burgerzutaten bz;
        Burger burger;
         
         for(int i=0; i< bidList.length; i++){
            burger = burgerFacade.find(bidList[i]);
            bz = burgerzutatenFacade.find(burger.getBurgerzutatenId());
                
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
            saveburger[i][18] = "" + burgerFacade.getPreisByBurgerId(bidList[i]) + "0€";
            saveburger[i][19] = "" + bidList[i];
            saveburger[i][20] = "" + burgerFacade.getNameByBurgerId(bidList[i]);
            
         }
       return saveburger;
    }
    
    @Override
    public void deleteBurger(int bid){
    
      Burger bur = burgerFacade.find(bid);
      int bzid = bur.getBurgerzutatenId();
      Burgerzutaten bz = burgerzutatenFacade.find(bzid);
     
      burgerzutatenFacade.remove(bz);
      burgerFacade.remove(bur);
  
    }
    @Override
    public void performOrder(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18, String username, String burgername){
    
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
    
    username = username.toLowerCase();
    int userid = benutzerFacade.getBenutzerIdByBenutzerName(username);
    
    int bzid = burgerzutatenFacade.save( zID1, zID2, zID3, zID4, zID5, zID6, zID7, zID8, zID9, zID10, zID11, zID12, zID13, zID14, zID15, zID16, zID17, zID18);
    
    double burgerpreis = zutatenFacade.getBurgerPreis(b1, b2, b3, b4, b5, b6 , b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18);

    int bid = burgerFacade.saveBurger(bzid, burgerpreis, burgername, userid);
    
    List<Bestellung> bestList = bestellungFacade.findAll();
    for(Bestellung current: bestList){
        if(current.getBenutzerId().equals(userid)){
           Warenkorb wk = new Warenkorb(current.getBestellungId(),bid, 1);
           warenkorbFacade.create(wk);
           current.setBestellungPreis(this.getGesPreis(current.getBestellungId()));
        }
        else{
             Bestellung best = new Bestellung(userid);
             bestellungFacade.create(best);
             Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
             warenkorbFacade.create(wk);
             best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
        }
    }
}
   
    @Override
    public void performOrder(int bid, String username, String burgername){
    
    username = username.toLowerCase();
    int userid = benutzerFacade.getBenutzerIdByBenutzerName(username);
    int zaehlen = 0;
    System.out.println("performOrder");
    
    List<Bestellung> bestList = bestellungFacade.findAll();
    for(Bestellung current: bestList){
        zaehlen++;
    }
    System.out.println("performOrder: "+zaehlen);
    if(zaehlen == 0){
        System.out.println("Start");
        System.out.println(userid);
        Bestellung best = new Bestellung(userid);
        bestellungFacade.create(best);
        System.out.println("Bestellung angelegt:" + best.getBestellungId());
        Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
        warenkorbFacade.create(wk);
        System.out.println("Warenkorb angelegt");
        best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
    }
        
    for(Bestellung current: bestList){
        System.out.println("performOrder2");
        if(current.getBenutzerId().equals(userid)){
           Warenkorb wk = new Warenkorb(current.getBestellungId(),bid, 1);
           warenkorbFacade.create(wk);
           current.setBestellungPreis(this.getGesPreis(current.getBestellungId()));
        }
        else{
             Bestellung best = new Bestellung(userid);
             bestellungFacade.create(best);
             Warenkorb wk = new Warenkorb(best.getBestellungId(),bid, 1);
             warenkorbFacade.create(wk);
             best.setBestellungPreis(this.getGesPreis(best.getBestellungId()));
        }
    }
    }
     
    @Override
     public void changeMenge(int bid, int menge){
       Bestellung best;
       List<Warenkorb> wk = warenkorbFacade.findAll();
       for(Warenkorb current: wk){
         if(current.getBurgerId().equals(bid)){
             current.setMenge(menge);
             best = bestellungFacade.find(current.getBestellungId());
             best.setBestellungPreis(this.getGesPreis(current.getBestellungId()) );
         }
       }
    }
    
    @Override
    public void deleteBurgerInWarenkorb(int bid){
      Bestellung best;
      double preis;
      List<Warenkorb> wk = warenkorbFacade.findAll();
      for(Warenkorb current: wk){
         if(current.getBurgerId().equals(bid)){
             warenkorbFacade.remove(current);
             best = bestellungFacade.find(current.getBestellungId());
             best.setBestellungPreis(this.getGesPreis(current.getBestellungId()));
         }
      }
    }
    @Override 
    public double getGesPreis(int bestid){
        double gespreis = 0;
        double burgerpreis;
        List<Warenkorb> wk = warenkorbFacade.findAll();
        for(Warenkorb current: wk){
            if(current.getBestellungId().equals(bestid)){
                burgerpreis = burgerFacade.getPreisByBurgerId(current.getBurgerId());
                gespreis = gespreis + burgerpreis * current.getMenge();
            }
        }
        return gespreis;
    }
    
    @Override
    public String[][] getBurgerInWarenkorb(String username){
        int bestid = -1;
        int userid = benutzerFacade.getBenutzerIdByBenutzerName(username);
       
        List<Bestellung> bestList = bestellungFacade.findAll();
        for(Bestellung current: bestList){
           if(current.getBenutzerId().equals(userid)){
               bestid = current.getBestellungId();
           }
       }
        
        int[] bidList = warenkorbFacade.getBurgerIdByBestellungId(bestid);
        
        String [][] burgerinwarenkorb= new String[bidList.length][21];
        
        Burgerzutaten bz;
        Burger burger;
         
         for(int i=0; i< bidList.length; i++){
            burger = burgerFacade.find(bidList[i]);
            bz = burgerzutatenFacade.find(burger.getBurgerzutatenId());
                
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
            burgerinwarenkorb[i][18] = "" + burgerFacade.getPreisByBurgerId(bidList[i]) + "0€";
            burgerinwarenkorb[i][19] = "" + bidList[i];
            burgerinwarenkorb[i][20] = "" + burgerFacade.getNameByBurgerId(bidList[i]);
            
         }
       return burgerinwarenkorb;
    }
    
    @Override
    public int getBestellungIdByBenutzername(String username){
        int userid = -1;
        int bestid = -1;
        List<Benutzer> benuList = benutzerFacade.findAll();
        for(Benutzer current : benuList){
            if(current.getBenutzerName().equals(username))
                userid = current.getBenutzerId();
        }
        
        List<Bestellung> bestList = bestellungFacade.findAll();
        for(Bestellung current : bestList){
            if(current.getBenutzerId().equals(userid))
               bestid = current.getBestellungId();
        }
        return bestid;
    }
}
