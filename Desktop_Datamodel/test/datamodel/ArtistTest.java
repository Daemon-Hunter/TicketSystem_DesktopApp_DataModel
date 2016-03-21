/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import people.Customer;
import reviews.IReviewFactory;
import reviews.Review;
import utilities.observer.IObserver;
import utilities.observer.ISubject;

/**
 *
 * @author 10512691
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
     * Test of getTable method, of class Artist.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        Artist instance = new Artist();
        DatabaseTable expResult = DatabaseTable.ARTIST;
        DatabaseTable result = instance.getTable();
        assertEquals(expResult, result);
        fail("The table returned wasn't ARTIST");
    }

    /**
     * Test of getId method, of class Artist.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Artist instance = new Artist();
        Integer expResult = null;
        Integer result = instance.getSocialId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Artist.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setSocialId(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImage method, of class Artist.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImage method, of class Artist.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        URL img = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setImage(img);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFacebook method, of class Artist.
     */
    @Test
    public void testGetFacebook() {
        System.out.println("getFacebook");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getFacebook();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFacebook method, of class Artist.
     */
    @Test
    public void testSetFacebook() {
        System.out.println("setFacebook");
        URL fb = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setFacebook(fb);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTwitter method, of class Artist.
     */
    @Test
    public void testGetTwitter() {
        System.out.println("getTwitter");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getTwitter();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTwitter method, of class Artist.
     */
    @Test
    public void testSetTwitter() {
        System.out.println("setTwitter");
        URL tw = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setTwitter(tw);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstagram method, of class Artist.
     */
    @Test
    public void testGetInstagram() {
        System.out.println("getInstagram");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getInstagram();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInstagram method, of class Artist.
     */
    @Test
    public void testSetInstagram() {
        System.out.println("setInstagram");
        URL insta = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setInstagram(insta);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSoundcloud method, of class Artist.
     */
    @Test
    public void testGetSoundcloud() {
        System.out.println("getSoundcloud");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getSoundcloud();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSoundcloud method, of class Artist.
     */
    @Test
    public void testSetSoundcloud() {
        System.out.println("setSoundcloud");
        URL sc = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setSoundcloud(sc);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWebsite method, of class Artist.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getWebsite();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWebsite method, of class Artist.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        URL web = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setWebsite(web);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpotify method, of class Artist.
     */
    @Test
    public void testGetSpotify() {
        System.out.println("getSpotify");
        Artist instance = new Artist();
        URL expResult = null;
        URL result = instance.getSpotify();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpotify method, of class Artist.
     */
    @Test
    public void testSetSpotify() {
        System.out.println("setSpotify");
        URL sp = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.setSpotify(sp);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReview method, of class Artist.
     */
    @Test
    public void testGetReview() {
        System.out.println("getReview");
        Integer uniqueID = null;
        Artist instance = new Artist();
        Review expResult = null;
        Review result = instance.getReview(uniqueID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class Artist.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        IObserver o = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.registerObserver(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class Artist.
     */
    @Test
    public void testRemoveObserver() {
        System.out.println("removeObserver");
        IObserver o = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.removeObserver(o);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteReview method, of class Artist.
     */
    @Test
    public void testDeleteReview() {
        System.out.println("deleteReview");
        Review review = null;
        Artist instance = new Artist();
        Boolean expResult = null;
        Boolean result = instance.deleteReview(review);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReviewFactory method, of class Artist.
     */
    @Test
    public void testGetReviewFactory() {
        System.out.println("getReviewFactory");
        Artist instance = new Artist();
        IReviewFactory expResult = null;
        IReviewFactory result = instance.getReviewFactory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
