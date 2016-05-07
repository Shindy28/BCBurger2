package controller;

import javax.ejb.Local;

/**
 * @desc Lokales Interface zur Klasse LoginBean
 * @author Florian
 */
@Local
public interface LoginBeanLocal {
    public String performLogin(String benutzerName, String passwort);
    
    public String performRegistry(String benutzerName, String passwort, String passwortConfirm);
}
