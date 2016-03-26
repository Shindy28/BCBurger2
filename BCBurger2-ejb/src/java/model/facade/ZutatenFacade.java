/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Benutzer;
import model.entity.Zutaten;

/**
 *
 * @author Florian
 */
@Stateless
public class ZutatenFacade extends AbstractFacade<Zutaten> implements ZutatenFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZutatenFacade() {
        super(Zutaten.class);
    }
    
    @Override
    public int getZutatenIdByBez(String bezeichnung) {
      List<Zutaten> zut = this.findAll();
      for(Zutaten current: zut){
          if(current.getZutatenBezeichnung().equals(bezeichnung)){
            return current.getZutatenId();
           }
      }
        return -1;
    }
    
    @Override
    public double getZutatenPreisByBez(String bezeichnung) {
      List<Zutaten> zut = this.findAll();
      for(Zutaten current: zut){
          if(current.getZutatenBezeichnung().equals(bezeichnung)){
            return current.getZutatenPreis();
           }
      }
        return 0;
    }

    /**
     *
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
     * @return
     */
    @Override
    public double getBurgerPreis(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18) {
    
   double burgerpreis =  this.getZutatenPreisByBez(b1);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b2);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b3);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b4);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b5);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b6);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b7);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b8);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b9);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b10);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b11);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b12);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b13);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b14);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b15);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b16);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b17);
   burgerpreis = burgerpreis + this.getZutatenPreisByBez(b18);
   
   return burgerpreis;
   
    }
}
