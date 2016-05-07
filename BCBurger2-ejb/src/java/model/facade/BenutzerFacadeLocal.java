package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Benutzer;

/**
 * @desc Lokales Interface zur BenutzerFacade Klasse
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
    
    public void register(String benutzerName, String passwort); 
   
    public int getBenutzerIdByBenutzerName(String benutzerName);
    
    public boolean checkPasswordByBenutzerId(int benutzerId, String passwort);

    
}
