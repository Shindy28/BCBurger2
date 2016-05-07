package model.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Filialen;

/**
 * @desc Klasse enthält alle Methoden um Filialen zu erstellen und zu verwalten
 * @author Florian
 */
@Stateless
public class FilialenFacade extends AbstractFacade<Filialen> implements FilialenFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilialenFacade() {
        super(Filialen.class);
    }
    
}
