/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Burger;

/**
 *
 * @author Florian
 */
@Local
public interface BurgerFacadeLocal {

    void create(Burger burger);

    void edit(Burger burger);

    void remove(Burger burger);

    Burger find(Object id);

    List<Burger> findAll();

    List<Burger> findRange(int[] range);

    int count();
    
}
