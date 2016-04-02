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
import model.entity.Burger;
import model.entity.Warenkorb;

/**
 *
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
    
}
