/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Local;

/**
 *
 * @author Florian
 */
@Local
public interface LoginBeanLocal {
    public String performLogin(String benutzerName, String passwort);
    
    public String performRegistry(String benutzerName, String passwort, String passwortConfirm);
}
