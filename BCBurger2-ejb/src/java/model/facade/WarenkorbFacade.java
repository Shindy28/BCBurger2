package model.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Warenkorb;

/**
 * @desc Klasse enthält alle Methoden um einen Warenkorb der Burger enthält zu erstellen und zu verwalten
 * @author Florian
 */
@Stateless
public class WarenkorbFacade extends AbstractFacade<Warenkorb> implements WarenkorbFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WarenkorbFacade() {
        super(Warenkorb.class);
    }
    /**
     * @desc Methode um Burger einer Bestellung zur ermitteln
     * @param bestId - bestellungId
     * @return Array mit burgerIds
     */
        @Override
    public int[] getBurgerIdByBestellungId(int bestId) {
        int i = 0;
//Ermittelt die Anzahl der Burger die einem Warenkorb in der Datenbank zugeordnet sind        
        List<Warenkorb> wk = this.findAll();
         for(Warenkorb current: wk){
             if(current.getBestellungId().equals(bestId)){
                 i++;
             }
         }
//Ermittelt alle Bestellungen die einem Warenkorb zugeordent sind und speichert die BestellungIds im Array       
        int[] bidList = new int[i];
         i = 0;
        
        List<Warenkorb> b2 = this.findAll();
         for(Warenkorb current: b2){
             if(current.getBestellungId().equals(bestId)){
                bidList[i] = current.getBurgerId();
                i++;
             }
         }
 //Rückgabe Array mit den BestellungIds        
         return bidList;
    
    }

    /**
     * @desc Methode um Menge von Burger im Warenkorb zu ermitteln
     * @param burgerId
     * @return menge
     */
        @Override
    public int getMengeByBurgerId(int burgerId) {
         int menge = -1;
         List<Warenkorb> wk = this.findAll();
         for(Warenkorb current: wk){
             if(current.getBurgerId().equals(burgerId))
                 menge = current.getMenge();
         }    
         return menge;
    }
    
}
