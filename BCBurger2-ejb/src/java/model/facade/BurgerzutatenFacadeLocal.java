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
    
    public int save(int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9, int b10, int b11, int b12, int b13, int b14, int b15, int b16, int b17, int b18);

    
}
