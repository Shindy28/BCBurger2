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

/**
 *
 * @author Florian
 */
@Stateless
public class BenutzerFacade extends AbstractFacade<Benutzer> implements BenutzerFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BenutzerFacade() {
        super(Benutzer.class);
    }

    @Override
    public int getBenutzerIdByBenutzerName(String benutzerName) {
      List<Benutzer> benu = this.findAll();
      for(Benutzer current: benu){
          if(current.getBenutzerName().equals(benutzerName)){
            return current.getBenutzerId();
           }
      }
        return -1;
    }

    /**
     *
     * @param benutzerName
     * @param passwort
     * @return
     */
    @Override
    public boolean register(String benutzerName, String passwort) {
       this.create(new Benutzer(benutzerName, passwort));
       return true;
    }

    @Override
    public boolean checkPasswordByBenutzeId(int benutzerId, String passwort) {
        return this.find(benutzerId).getBenutzerPasswort().equals(passwort);
    }
    
}
