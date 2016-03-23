/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Burgerzutaten;

/**
 *
 * @author Florian
 */
@Local
public interface BurgerzutatenFacadeLocal {

    void create(Burgerzutaten burgerzutaten);

    void edit(Burgerzutaten burgerzutaten);

    void remove(Burgerzutaten burgerzutaten);

    Burgerzutaten find(Object id);

    List<Burgerzutaten> findAll();

    List<Burgerzutaten> findRange(int[] range);

    int count();
    
}
