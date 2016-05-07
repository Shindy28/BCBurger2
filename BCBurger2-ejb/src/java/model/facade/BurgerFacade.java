package model.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Burger;

/**
 * @desc Klasse enthält alle Methoden um einen Burger zu erstellen und zu verwalten
 * @author Florian
 */
@Stateless
public class BurgerFacade extends AbstractFacade<Burger> implements BurgerFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BurgerFacade() {
        super(Burger.class);
    }
    
    /**
     * @desc Methode speichert den vom Benutzer konfigurierten Burger in Tabelle Burger
     * @param bzid - burgerZutatenId um Zutaten des Burgers zuordnen zu können
     * @param burgerPreis
     * @param burgerName
     * @param benutzerId
     * @return burgerId
     */
        @Override
     public int saveBurger(int bzid, double burgerPreis, String burgerName, int benutzerId){
        Burger current =  new Burger(bzid, burgerPreis, burgerName, benutzerId);
        this.create(current);
        return current.getBurgerId();
    }
     
//Methode liefert Preis für Burger zu entspechender burgerId aus der Datenbank

    /**
     * @desc Methode um Preis für Burger zu ermitteln
     * @param burgerId
     * @return burgerPreis
     */
        @Override
    public double getPreisByBurgerId(int burgerId){
      Burger bur = this.find(burgerId);
      return bur.getBurgerPreis();
    }
    
    /**
     * @desc Methode um Name von Burger zu ermitteln
     * @param burgerId
     * @return burgerName
     */
        @Override
    public String getNameByBurgerId(int burgerId) {
      Burger bur = this.find(burgerId);
      return bur.getBurgerName();
    }

    /**
     * @desc Methode um erstellte Burger von einem Benutzer zu ermitteln
     * @param benutzerId
     * @return Array mit burgerIds
     */
        @Override
    public int[] getBurgerIdByBenutzerId(int benutzerId) {
        int i = 0;
        
//Ermittelt die Anzahl der Burger die einem Benutzer in der Datenbank zugeordnet sind
        List<Burger> b1 = this.findAll();
         for(Burger current: b1){
             if(current.getBenutzerId().equals(benutzerId)){
                 i++;
             }
         }
//Ermittelt alle Burger die einem Benutzer zuegordnet sind und speichert die BurgerIds im Array
        int[] bidList = new int[i];
         i = 0;
        
        List<Burger> b2 = this.findAll();
         for(Burger current: b2){
             if(current.getBenutzerId().equals(benutzerId)){
                bidList[i] = current.getBurgerId();
                i++;
             }
         }
//Rückgabe Array mit den burgerIds         
         return bidList;
    }
}
