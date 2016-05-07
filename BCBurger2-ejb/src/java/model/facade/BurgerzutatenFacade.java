package model.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Burgerzutaten;

/**
 * @desc Klasse enthält Methoden um die Zutaten eines Burgers zu speichern
 * @author Florian
 */
@Stateless
public class BurgerzutatenFacade extends AbstractFacade<Burgerzutaten> implements BurgerzutatenFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public BurgerzutatenFacade() {
        super(Burgerzutaten.class);
    }

    /**
     * @desc Methode speichert alle Zutaten die auf einem Burger enthalten sind
     * @param zid1 - zutatenId, erste Zutat des Burgers
     * @param zid2 - zutatenId, zweite Zutat des Burgers usw.
     * @param zid3
     * @param zid4
     * @param zid5
     * @param zid6
     * @param zid7
     * @param zid8
     * @param zid9
     * @param zid10
     * @param zid11
     * @param zid12
     * @param zid13
     * @param zid14
     * @param zid15
     * @param zid16
     * @param zid17
     * @param zid18
     * @return burgerZutatenId
     */
        @Override
    public int save(int zid1, int zid2, int zid3, int zid4, int zid5, 
                    int zid6, int zid7, int zid8, int zid9, int zid10, 
                    int zid11, int zid12, int zid13, int zid14, int zid15, 
                    int zid16, int zid17, int zid18) {
        
       Burgerzutaten current =  new Burgerzutaten(zid1, zid2, zid3, zid4, zid5, zid6, zid7, zid8, zid9, zid10, 
                                                  zid11, zid12, zid13, zid14, zid15, zid16, zid17, zid18);
        this.create(current);
        return current.getBurgerzutatenId();
    }   
}
