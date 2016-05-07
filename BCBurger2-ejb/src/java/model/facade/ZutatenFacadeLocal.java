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
 * @desc Lokales Interface zur ZutatenFacade Klasse
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

    public double getBurgerPreis(String b1, String b2, String b3, String b4, String b5, String b6, String b60, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18);

    public String getBezByZutatenId(int zid);
    
}
