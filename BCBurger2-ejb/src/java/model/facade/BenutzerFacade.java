package model.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Benutzer;

/**
 * @desc Klasse enthält alle Methoden um ein Benutzer zu erstellen und zu verwalten
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
   

    /**
     * @desc Methode führt Registrierung von Benutzer durch
     * @param benutzerName
     * @param passwort
     */
    @Override
    public void register(String benutzerName, String passwort) {
       this.create(new Benutzer(benutzerName, passwort));
      
    }
    /**
     * @desc Methode um ID von Benutzer zu ermitteln
     * @param benutzerName
     * @return benutzerId
     */
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
     * @desc Methode überprüft Passwort von Benutzer
     * @param benutzerId
     * @param passwort
     * @return true, falls Passwörter identisch
     */
    @Override
    public boolean checkPasswordByBenutzerId(int benutzerId, String passwort) {
        return this.find(benutzerId).getBenutzerPasswort().equals(passwort);
    }
    
}
