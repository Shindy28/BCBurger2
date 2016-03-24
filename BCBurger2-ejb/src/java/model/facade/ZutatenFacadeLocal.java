/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Zutaten;

/**
 *
 * @author Florian
 */
@Local
public interface ZutatenFacadeLocal {

    void create(Zutaten zutaten);

    void edit(Zutaten zutaten);

    void remove(Zutaten zutaten);

    Zutaten find(Object id);

    List<Zutaten> findAll();

    List<Zutaten> findRange(int[] range);

    int count();
    
    public int getZutatenIdByBez(String bezeichnung);
    
     public double getZutatenPreisByBez(String bezeichnung);
    
}
