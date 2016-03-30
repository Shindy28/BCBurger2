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
import model.entity.Burgerzutaten;

/**
 *
 * @author Florian
 */
@Stateless
public class BurgerzutatenFacade extends AbstractFacade<Burgerzutaten> implements BurgerzutatenFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public int save(int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9, int b10, int b11, int b12, int b13, int b14, int b15, int b16, int b17, int b18) {
       Burgerzutaten current =  new Burgerzutaten(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, 15, b16, b17, b18);
        this.create(current);
        return current.getBurgerzutatenId();
    }

    public BurgerzutatenFacade() {
        super(Burgerzutaten.class);
    }
        
   

    
    
}
