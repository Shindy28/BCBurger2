/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Filialen;

/**
 * @desc Lokales Interface zur FilialenFacade Klasse
 * @author Florian
 */
@Local
public interface FilialenFacadeLocal {

    void create(Filialen filialen);

    void edit(Filialen filialen);

    void remove(Filialen filialen);

    Filialen find(Object id);

    List<Filialen> findAll();

    List<Filialen> findRange(int[] range);

    int count();
    
}
