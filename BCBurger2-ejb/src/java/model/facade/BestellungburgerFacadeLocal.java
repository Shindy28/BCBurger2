/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Bestellungburger;

/**
 *
 * @author Florian
 */
@Local
public interface BestellungburgerFacadeLocal {

    void create(Bestellungburger bestellungburger);

    void edit(Bestellungburger bestellungburger);

    void remove(Bestellungburger bestellungburger);

    Bestellungburger find(Object id);

    List<Bestellungburger> findAll();

    List<Bestellungburger> findRange(int[] range);

    int count();
    
}
