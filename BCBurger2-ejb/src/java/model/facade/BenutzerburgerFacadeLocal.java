/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Benutzerburger;

/**
 *
 * @author Florian
 */
@Local
public interface BenutzerburgerFacadeLocal {

    void create(Benutzerburger benutzerburger);

    void edit(Benutzerburger benutzerburger);

    void remove(Benutzerburger benutzerburger);

    Benutzerburger find(Object id);

    List<Benutzerburger> findAll();

    List<Benutzerburger> findRange(int[] range);

    int count();
    
}
