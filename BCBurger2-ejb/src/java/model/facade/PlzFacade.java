package model.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Plz;

/**
 * @desc Klasse enthält alle Methoden um eine PLZ zu erstellen und zu verwalten
 * @author Florian
 */
@Stateless
public class PlzFacade extends AbstractFacade<Plz> implements PlzFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlzFacade() {
        super(Plz.class);
    }
    
}
