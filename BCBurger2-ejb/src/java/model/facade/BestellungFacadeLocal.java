/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Bestellung;

/**
 * @desc Lokales Interface zur BestellungFacade Klasse
 * @author Florian
 */
@Local
public interface BestellungFacadeLocal {

    void create(Bestellung bestellung);

    void edit(Bestellung bestellung);

    void remove(Bestellung bestellung);

    Bestellung find(Object id);

    List<Bestellung> findAll();

    List<Bestellung> findRange(int[] range);

    int count();
    
}
