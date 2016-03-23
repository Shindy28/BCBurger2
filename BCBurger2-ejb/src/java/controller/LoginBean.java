package controller;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.facade.BenutzerFacadeLocal;

/**
 *
 * @author Florian
 */
@Stateless
public class LoginBean implements LoginBeanLocal {
    @EJB
    BenutzerFacadeLocal benutzerFacade;

    @Override
    public String performLogin(String benutzerName, String passwort) {
        benutzerName = benutzerName.toLowerCase();
        validateBenutzerName(benutzerName);
        validatePasswort(passwort);
        
        long userID =benutzerFacade.getBenutzerIdByBenutzerName(benutzerName);
        return ""+userID; //Login succesfull
        //throw new InputException("Erfolgreich angemeldet"); //TODO: Weiterleitung bzw. nachladen mit AJAX
    }

    @Override
    public String performRegistry(String benutzerName, String passwort, String passwortConfirm) {
        benutzerName = benutzerName.toLowerCase();
        validateBenutzerName(benutzerName);
        validatePasswort(passwort);
        
        benutzerFacade.register(benutzerName, passwort);
        int benutzerId = benutzerFacade.getBenutzerIdByBenutzerName(benutzerName);

        
       

        return ""+benutzerId; //Registry succesfull
        //throw new InputException("Erfolgreich registriert"); //TODO: Weiterleitung bzw. nachladen mit AJAX
    }

    private boolean validateBenutzerName(String benutzerName){
   
        return true;
    }

    private boolean validatePasswort(String passwort){
    
        return true;
    }

}
