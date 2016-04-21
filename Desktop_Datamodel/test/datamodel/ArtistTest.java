/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reviews.IReview;

/**
 *
 * @author 10467841
 */
public class ArtistTest {
    
    public ArtistTest() {
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
     * Test of getArtistTags method, of class Artist.
     */
    @Test
    public void testGetArtistTags() {
        Artist instance = new Artist();
        instance.addArtistTag("New tag");
        instance.addArtistTag("another tag");
        System.out.println("getArtistTags");
        List<String> expResult = new ArrayList();
        expResult.add("New tag");
        expResult.add("another tag");
        List<String> result = instance.getArtistTags();
        assertEquals(expResult, result);
    }

    /**
     * Test of addArtistTag method, of class Artist.
     */
    @Test
    public void testAddArtistTag() {
        System.out.println("addArtistTag");
        String tag = "hfgghj";
        Artist instance = new Artist();
        Boolean expResult = true;
        Boolean result = instance.addArtistTag(tag);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeArtistTag method, of class Artist.
     */
//    @Test
//    public void testRemoveArtistTag() {
//        System.out.println("removeArtistTag");
//        String tag = "";
//        Artist instance = new Artist();
//        Boolean expResult = null;
//        Boolean result = instance.removeArtistTag(tag);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getArtistID method, of class Artist.
     */
    @Test
    public void testGetArtistID() {
        System.out.println("getArtistID");
        Artist instance = new Artist(0, "testname", null, null, null, null);
        Integer expResult = 0;
        Integer result = instance.getArtistID();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getArtistName method, of class Artist.
     */
    @Test
    public void testGetArtistName() {
        System.out.println("getArtistName");
        Artist instance = new Artist(0, "testname", null, null, null, null);
        String expResult = "testname";
        String result = instance.getArtistName();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setArtist method, of class Artist.
//     */
//    @Test
//    public void testSetArtist() {
//        System.out.println("setArtist");
//        String name = "";
//        Artist instance = new Artist();
//        instance.setArtist(name);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getDescription method, of class Artist.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Artist instance = new Artist(0, "testname", "sdfgs", null, null, null);
        String expResult = "sdfgs";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setDescription method, of class Artist.
     */
//    @Test
//    public void testSetDescription() {
//        System.out.println("setDescription");
//        String description = "";
//        Artist instance = new Artist();
//        instance.setDescription(description);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
