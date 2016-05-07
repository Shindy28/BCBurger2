/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import model.entity.Benutzer;
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
public class BenutzerFacadeTest {
    
    public BenutzerFacadeTest() {
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
     * Test of create method, of class BenutzerFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Benutzer entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class BenutzerFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Benutzer entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BenutzerFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Benutzer entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class BenutzerFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        Benutzer expResult = null;
        Benutzer result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class BenutzerFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        List<Benutzer> expResult = null;
        List<Benutzer> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class BenutzerFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        List<Benutzer> expResult = null;
        List<Benutzer> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class BenutzerFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBenutzerIdByBenutzerName method, of class BenutzerFacade.
     */
    @Test
    public void testGetBenutzerIdByBenutzerName() throws Exception {
        System.out.println("getBenutzerIdByBenutzerName");
        String benutzerName = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        int expResult = 0;
        int result = instance.getBenutzerIdByBenutzerName(benutzerName);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class BenutzerFacade.
     */
    @Test
    public void testRegister() throws Exception {
        System.out.println("register");
        String benutzerName = "";
        String passwort = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        boolean expResult = false;
        boolean result = instance.register(benutzerName, passwort);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordByBenutzeId method, of class BenutzerFacade.
     */
    @Test
    public void testCheckPasswordByBenutzeId() throws Exception {
        System.out.println("checkPasswordByBenutzeId");
        int benutzerId = 0;
        String passwort = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BenutzerFacadeLocal instance = (BenutzerFacadeLocal)container.getContext().lookup("java:global/classes/BenutzerFacade");
        boolean expResult = false;
        boolean result = instance.checkPasswordByBenutzeId(benutzerId, passwort);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
