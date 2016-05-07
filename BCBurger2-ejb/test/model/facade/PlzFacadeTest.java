/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import model.entity.Plz;
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
public class PlzFacadeTest {
    
    public PlzFacadeTest() {
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
     * Test of create method, of class PlzFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Plz entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        instance.create(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class PlzFacade.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Plz entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        instance.edit(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class PlzFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Plz entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        instance.remove(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PlzFacade.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        Plz expResult = null;
        Plz result = instance.find(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class PlzFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        List<Plz> expResult = null;
        List<Plz> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class PlzFacade.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        List<Plz> expResult = null;
        List<Plz> result = instance.findRange(range);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class PlzFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PlzFacadeLocal instance = (PlzFacadeLocal)container.getContext().lookup("java:global/classes/PlzFacade");
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
