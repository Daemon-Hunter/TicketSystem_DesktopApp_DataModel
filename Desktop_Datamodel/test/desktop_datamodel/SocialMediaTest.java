/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 10512691
 */
public class SocialMediaTest {
    
    public SocialMediaTest() {
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
     * Test of getId method, of class SocialMedia.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer expResult = 1;
        SocialMedia instance = new SocialMedia(expResult, null, null, null, null, null, null, null);
        Integer result = instance.getId();
        assertEquals("Fail, resulting Id didn't match input", expResult, result);
    }

    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetIdValid() {
        System.out.println("setId - valid");
        Integer id = 5;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean expResult = true;
        Boolean result = instance.setId(id);
        assertEquals("Fail, setId didn't return true", expResult, result);
    }
    
    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetIdZero() {
        System.out.println("setId - zero");
        Integer id = 0;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean expResult = false;
        Boolean result = instance.setId(id);
        assertEquals("Fail, setId zero didn't return false", expResult, result);
    }
    
    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetIdNull() {
        System.out.println("setId - null");
        Integer id = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        try {
            instance.setId(id);
            fail("The method did not throw a NullPointerException");
        }
        catch (NullPointerException ex) { }
    }
    
    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetIdNegative() {
        System.out.println("setId - negative");
        Integer id = -5;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean expResult = false;
        Boolean result = instance.setId(id);
        assertEquals("Fail, setId didn't return false when setting a "
                + "negative number", expResult, result);
    }
    
    /**
     * Test of setId method, of class SocialMedia.
     */
    @Test
    public void testSetIdInvalidLength() {
        System.out.println("setId - too long");
        Integer id = 100000001;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean expResult = false;
        Boolean result = instance.setId(id);
        assertEquals("Fail, setId didn't return false when setting an "
                + "id who's length is too large", expResult, result);
    }

    /**
     * Test of getImage method, of class SocialMedia.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        try {
            URL img = new URL("https://i.ytimg.com/vi/qaEYggF38hk/maxresdefault.jpg");
            SocialMedia instance = new SocialMedia(null, img, null, null, null, null, null, null);
            URL result = instance.getImage();
            assertEquals("Fail, the returned URL didn't match the one set", img, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setImage method, of class SocialMedia.
     */
    @Test
    public void testSetImage() {
        System.out.println("setImage");
        try {
            URL img = new URL("https://i.ytimg.com/vi/qaEYggF38hk/maxresdefault.jpg");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setImage(img);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }
    
    /**
     * Test of setImage method, of class SocialMedia.
     */
    @Test
    public void testSetImageNull() {
        System.out.println("setImage - null");
        URL img = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setImage(img);
        assertEquals("The method did not return false", set, false);
    }

    /**
     * Test of getFacebook method, of class SocialMedia.
     */
    @Test
    public void testGetFacebook() {
        System.out.println("getFacebook");
        try {
            URL fb = new URL("https://www.facebook.com/Mungos_HiFi");
            SocialMedia instance = new SocialMedia(null, null, fb, null, null, null, null, null);
            URL result = instance.getFacebook();
            assertEquals("Fail, the returned URL didn't match the one set", fb, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setFacebook method, of class SocialMedia.
     */
    @Test
    public void testSetFacebook() {
        System.out.println("setFacebook");
        try {
            URL fb = new URL("https://www.facebook.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setFacebook(fb);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }
    
    /**
     * Test of setFacebook method, of class SocialMedia.
     */
    @Test
    public void testSetFacebookNull() {
        System.out.println("setImage - null");
        URL fb = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setImage(fb);
        assertEquals("The method did not return false", set, false);
    }

    /**
     * Test of getTwitter method, of class SocialMedia.
     */
    @Test
    public void testGetTwitter() {
        System.out.println("getTwitter");
        try {
            URL tw = new URL("https://www.twitter.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, tw, null, null, null, null);
            URL result = instance.getTwitter();
            assertEquals("Fail, the returned URL didn't match the one set", tw, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setTwitter method, of class SocialMedia.
     */
    @Test
    public void testSetTwitter() {
        System.out.println("setTwitter");
        try {
            URL tw = new URL("https://www.twitter.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setTwitter(tw);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }
    
    /**
     * Test of setTwitter method, of class SocialMedia.
     */
    @Test
    public void testSetTwitterNull() {
        System.out.println("setTwitter - null");
        URL tw = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setTwitter(tw);
        assertEquals("The method did not return false", set, false);
    }

    /**
     * Test of getInstagram method, of class SocialMedia.
     */
    @Test
    public void testGetInstagram() {
        System.out.println("getInstagram");
        try {
            URL insta = new URL("https://www.instagram.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, insta, null, null, null);
            URL result = instance.getInstagram();
            assertEquals("Fail, the returned URL didn't match the one set", insta, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setInstagram method, of class SocialMedia.
     */
    @Test
    public void testSetInstagram() {
        System.out.println("setInstagram");
        try {
            URL insta = new URL("https://www.instagram.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setInstagram(insta);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setInstagram method, of class SocialMedia.
     */
    @Test
    public void testSetInstagramNull() {
        System.out.println("setInstagram - null");
        URL insta = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setInstagram(insta);
        assertEquals("The method did not return false", set, false);
    }
    
    /**
     * Test of getSoundcloud method, of class SocialMedia.
     */
    @Test
    public void testGetSoundcloud() {
        System.out.println("getSoundcloud");
        try {
            URL sc = new URL("https://www.soundcloud.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, sc, null, null);
            URL result = instance.getSoundcloud();
            assertEquals("Fail, the returned URL didn't match the one set", sc, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setSoundcloud method, of class SocialMedia.
     */
    @Test
    public void testSetSoundcloud() {
        System.out.println("setSoundcloud");
        try {
            URL sc = new URL("https://www.soundcloud.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setSoundcloud(sc);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }
    
    /**
     * Test of setSoundcloud method, of class SocialMedia.
     */
    @Test
    public void testSetSoundcloudNull() {
        System.out.println("setSoundcloud - null");
        URL sc = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setSoundcloud(sc);
        assertEquals("The method did not return false", set, false);
    }

    /**
     * Test of getWebsite method, of class SocialMedia.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        try {
            URL web = new URL("https://www.mungos-hifi.com");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, web, null);
            URL result = instance.getWebsite();
            assertEquals("Fail, the returned URL didn't match the one set", web, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setWebsite method, of class SocialMedia.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        try {
            URL web = new URL("https://www.mungos-hifi.com");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setSoundcloud(web);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }
    
    /**
     * Test of setWebsite method, of class SocialMedia.
     */
    @Test
    public void testSetWebsiteNull() {
        System.out.println("setWebsite - null");
        URL web = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setWebsite(web);
        assertEquals("The method did not return false", set, false);
    }

    /**
     * Test of getSpotify method, of class SocialMedia.
     */
    @Test
    public void testGetSpotify() {
        System.out.println("getSpotify");
        try {
            URL sp = new URL("https://www.spotify.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, sp);
            URL result = instance.getSpotify();
            assertEquals("Fail, the returned URL didn't match the one set", sp, result);
        }
        catch (MalformedURLException ex)  {
            fail("Error in test image URL");
        }
    }

    /**
     * Test of setSpotify method, of class SocialMedia.
     */
    @Test
    public void testSetSpotify() {
        System.out.println("setSpotify");
        try {
            URL sp = new URL("https://www.spotify.com/mungos_hifi");
            SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
            Boolean result = instance.setSoundcloud(sp);
            assertEquals("Fail, method didn't return true", true, result);
        }
        catch (MalformedURLException ex) {
            fail("Error in test image URL");
        }
    }
    
    /**
     * Test of setSpotify method, of class SocialMedia.
     */
    @Test
    public void testSetSpotifyNull() {
        System.out.println("setSpotify - null");
        URL sp = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setTwitter(sp);
        assertEquals("The method did not return false", set, false);
    }
}
