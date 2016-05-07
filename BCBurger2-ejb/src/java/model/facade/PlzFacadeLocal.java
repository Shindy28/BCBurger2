/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Plz;

/**
 * @desc Lokales Interface zu PlzFacade Klasse
 * @author Florian
 */
@Local
public interface PlzFacadeLocal {

    void create(Plz plz);

    void edit(Plz plz);

    void remove(Plz plz);

    Plz find(Object id);

    List<Plz> findAll();

    List<Plz> findRange(int[] range);

    int count();
    
}
