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
}
