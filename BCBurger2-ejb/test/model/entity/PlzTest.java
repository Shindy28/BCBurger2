/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

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
public class PlzTest {
    
    public PlzTest() {
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
     * Test of getPlz method, of class Plz.
     */
    @Test
    public void testGetPlz() {
        System.out.println("getPlz");
        Plz instance = new Plz();
        Integer expResult = null;
        Integer result = instance.getPlz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrt method, of class Plz.
     */
    @Test
    public void testGetOrt() {
        System.out.println("getOrt");
        Plz instance = new Plz();
        String expResult = "";
        String result = instance.getOrt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrt method, of class Plz.
     */
    @Test
    public void testSetOrt() {
        System.out.println("setOrt");
        String ort = "";
        Plz instance = new Plz();
        instance.setOrt(ort);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Plz.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Plz instance = new Plz();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Plz.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Plz instance = new Plz();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Plz.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Plz instance = new Plz();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
