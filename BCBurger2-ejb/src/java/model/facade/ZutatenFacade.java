/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}
