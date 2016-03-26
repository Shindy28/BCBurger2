/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Benutzer;

/**
 *
 * @author Florian
 */
@Local
public interface BenutzerFacadeLocal {

    void create(Benutzer benutzer);

    void edit(Benutzer benutzer);

    void remove(Benutzer benutzer);

    Benutzer find(Object id);

    List<Benutzer> findAll();

    List<Benutzer> findRange(int[] range);

    int count();

    public int getBenutzerIdByBenutzerName(String benutzerName);
    
    /**
     *
     * @param benutzerId
     * @param password
     * @return
     */
    public boolean checkPasswordByBenutzeId(int benutzerId, String passwort);

    public boolean register(String benutzerName, String passwor);

    public void saveBurgerBenutzer(int bid, int userID);
    
}
