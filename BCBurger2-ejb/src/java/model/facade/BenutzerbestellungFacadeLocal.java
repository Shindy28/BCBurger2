/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Benutzerbestellung;

/**
 *
 * @author Florian
 */
@Local
public interface BenutzerbestellungFacadeLocal {

    void create(Benutzerbestellung benutzerbestellung);

    void edit(Benutzerbestellung benutzerbestellung);

    void remove(Benutzerbestellung benutzerbestellung);

    Benutzerbestellung find(Object id);

    List<Benutzerbestellung> findAll();

    List<Benutzerbestellung> findRange(int[] range);

    int count();
    
}
