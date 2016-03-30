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

/**
 *
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
    
    @Override
     public int saveBurger(int bzid, double burgerPreis){
         Burger current =  new Burger(bzid, burgerPreis);
        this.create(current);
        return current.getBurgerId();
    }
     
    /**
     *
     * @param burgerid
     * @return
     */
    @Override
    public double getPreisByBurgerId(int burgerid){
      Burger bur = this.find(burgerid);
      return bur.getBurgerPreis();
    }
    
}
