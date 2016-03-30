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
import model.entity.Benutzerburger;

/**
 *
 * @author Florian
 */
@Stateless
public class BenutzerburgerFacade extends AbstractFacade<Benutzerburger> implements BenutzerburgerFacadeLocal {

    
    
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BenutzerburgerFacade() {
        super(Benutzerburger.class);
    }
    
    /**
     *
     * @param bid
     * @param userid
     * @return 
     */
    @Override
    public  void saveBenutzerBurger(int bid, int userid) {
        Benutzerburger current =  new Benutzerburger(bid, userid);
        this.create(current);
    }
    
    @Override
    public int[] getBurgerIdByBenutzerId(int userid){
        int i = 0;
        
        List<Benutzerburger> bb1 = this.findAll();
         for(Benutzerburger current: bb1){
             if(current.getBenutzerId().equals(userid)){
                 i++;
             }
         }

        
        int[] bidList = new int[i];
         i = 0;
        
        List<Benutzerburger> bb2 = this.findAll();
         for(Benutzerburger current: bb2){
             if(current.getBenutzerId().equals(userid)){
                bidList[i] = current.getBurgerId();
                i++;
             }
         }
         
         return bidList;
    }

}
