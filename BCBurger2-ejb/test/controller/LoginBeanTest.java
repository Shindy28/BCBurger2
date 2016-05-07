/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Florian
 */
public class LoginBeanTest {
    
    public LoginBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of performLogin method, of class LoginBean.
     */
    @Test
    public void testPerformLogin() throws Exception {
        System.out.println("performLogin");
        String benutzerName = "Florian";
        String passwort = "123";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginBeanLocal instance = (LoginBeanLocal)container.getContext().lookup("java:global/classes/LoginBean");
        String expResult = "";
        String result = instance.performLogin(benutzerName, passwort);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performRegistry method, of class LoginBean.
     */
    @Test
    public void testPerformRegistry() throws Exception {
        System.out.println("performRegistry");
        String benutzerName = "Daniel";
        String passwort = "123";
        String passwortConfirm = "123";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        LoginBeanLocal instance = (LoginBeanLocal)container.getContext().lookup("java:global/classes/LoginBean");
        String expResult = "";
        String result = instance.performRegistry(benutzerName, passwort, passwortConfirm);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
