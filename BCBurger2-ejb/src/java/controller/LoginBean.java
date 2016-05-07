package controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.facade.BenutzerFacadeLocal;

/**
 * @desc Klasse enthält Methoden um sich als Benutzer registrieren und einloggen zu können
 * @author Florian
 */
@Stateless
public class LoginBean implements LoginBeanLocal {
    @EJB
    BenutzerFacadeLocal benutzerFacade;

    /**
     * @desc Methode um sich als Benutzer mit Passwort einzuloggen
     * @param benutzerName
     * @param passwort
     * @return benutzerId als String, falls Passwort korrekt
     */
    @Override
    public String performLogin(String benutzerName, String passwort) {
        benutzerName = benutzerName.toLowerCase();
        int benutzerId =benutzerFacade.getBenutzerIdByBenutzerName(benutzerName);
        
        if(benutzerFacade.checkPasswordByBenutzerId(benutzerId, passwort)){
            return ""+benutzerId;
        }
        else{
            return -1+ "";
        }
    }

    /**
     * @desc Methode um sich als Benutzer mit Passwort zu registrieren
     * @param benutzerName
     * @param passwort
     * @param passwortConfirm
     * @return benutzerId als String
     */
    @Override
    public String performRegistry(String benutzerName, String passwort, String passwortConfirm) {
        benutzerName = benutzerName.toLowerCase();
        
        benutzerFacade.register(benutzerName, passwort);
        int benutzerId = benutzerFacade.getBenutzerIdByBenutzerName(benutzerName);

        return ""+benutzerId;
    }
}
