/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Warenkorb;

/**
 *
 * @author Florian
 */
@Local
public interface WarenkorbFacadeLocal {

    void create(Warenkorb warenkorb);

    void edit(Warenkorb warenkorb);

    void remove(Warenkorb warenkorb);

    Warenkorb find(Object id);

    List<Warenkorb> findAll();

    List<Warenkorb> findRange(int[] range);

    int count();


    
}
