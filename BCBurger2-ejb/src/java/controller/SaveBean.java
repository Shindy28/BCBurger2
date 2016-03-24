/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.facade.BenutzerFacadeLocal;
import model.facade.BurgerFacadeLocal;
import model.facade.BurgerzutatenFacadeLocal;
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

@Override
public void performSave(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18, String username ){
    
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
    
    int userID = benutzerFacade.getBenutzerIdByBenutzerName(username);
    
    int bzid = burgerzutatenFacade.save( zID1, zID2, zID3, zID4, zID5, zID6, zID7, zID8, zID9, zID10, zID11, zID12, zID13, zID14, zID15, zID16, zID17, zID18);
    
   double burgerpreis = 0;
  
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b1);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b2);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b3);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b4);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b5);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b6);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b7);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b8);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b9);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b10);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b11);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b12);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b13);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b14);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b15);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b16);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b17);
   burgerpreis = burgerpreis + zutatenFacade.getZutatenPreisByBez(b18);

  int bid = burgerFacade.saveBurger(bzid, burgerpreis);
    

}


}
