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
 * @desc Lokales Interface zur Klasse BurgerzutatenFacade
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
    
    public int save(int zid1, int zid2, int zid3, int zid4, int zid5, int zid6, int zid7, int zid8, int zid9, int zid10, int zid11, int zid12, int zid13, int zid14, int zid15, int zid16,int zid17, int zid18);

    
}
