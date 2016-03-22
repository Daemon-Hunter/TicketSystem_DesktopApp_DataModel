/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import datamodel.SocialMedia;
import java.awt.image.BufferedImage;
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
        Integer result = instance.getSocialId();
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
        Boolean result = instance.setSocialId(id);
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
        Boolean result = instance.setSocialId(id);
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
            instance.setSocialId(id);
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
        Boolean result = instance.setSocialId(id);
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
        Boolean result = instance.setSocialId(id);
        assertEquals("Fail, setId didn't return false when setting an "
                + "id who's length is too large", expResult, result);
    }
    
    /**
     * Test of setImage method, of class SocialMedia.
     */
    @Test
    public void testSetImageNull() {
        System.out.println("setImage - null");
        BufferedImage img = null;
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
        String fb = "https://www.facebook.com/Mungos_HiFi";
        SocialMedia instance = new SocialMedia(null, null, fb, null, null, null, null, null);
        String result = instance.getFacebook();
        assertEquals("Fail, the returned URL didn't match the one set", fb, result);
    }

    /**
     * Test of setFacebook method, of class SocialMedia.
     */
    @Test
    public void testSetFacebook() {
        System.out.println("setFacebook");
        String fb = "https://www.facebook.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean result = instance.setFacebook(fb);
        assertEquals("Fail, method didn't return true", true, result);
    }
    
    /**
     * Test of setFacebook method, of class SocialMedia.
     */
    @Test
    public void testSetFacebookNull() {
        System.out.println("setImage - null");
        String fb = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setFacebook(fb);
        assertEquals("The method did not return false", set, false);
    }

    /**
     * Test of getTwitter method, of class SocialMedia.
     */
    @Test
    public void testGetTwitter() {
        System.out.println("getTwitter");
        String tw = "https://www.twitter.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, tw, null, null, null, null);
        String result = instance.getTwitter();
        assertEquals("Fail, the returned string didn't match the one set", tw, result);
    }

    /**
     * Test of setTwitter method, of class SocialMedia.
     */
    @Test
    public void testSetTwitter() {
        System.out.println("setTwitter");
        String tw = "https://www.twitter.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean result = instance.setTwitter(tw);
        assertEquals("Fail, method didn't return true", true, result);
    }
    
    /**
     * Test of setTwitter method, of class SocialMedia.
     */
    @Test
    public void testSetTwitterNull() {
        System.out.println("setTwitter - null");
        String tw = null;
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
        String insta = "https://www.instagram.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, insta, null, null, null);
        String result = instance.getInstagram();
        assertEquals("Fail, the returned URL didn't match the one set", insta, result);
    }

    /**
     * Test of setInstagram method, of class SocialMedia.
     */
    @Test
    public void testSetInstagram() {
        System.out.println("setInstagram");
        String insta = "https://www.instagram.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean result = instance.setInstagram(insta);
        assertEquals("Fail, method didn't return true", true, result);
    }

    /**
     * Test of setInstagram method, of class SocialMedia.
     */
    @Test
    public void testSetInstagramNull() {
        System.out.println("setInstagram - null");
        String insta = null;
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
        String sc = "https://www.soundcloud.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, sc, null, null);
        String result = instance.getSoundcloud();
        assertEquals("Fail, the returned URL didn't match the one set", sc, result);
    }

    /**
     * Test of setSoundcloud method, of class SocialMedia.
     */
    @Test
    public void testSetSoundcloud() {
        System.out.println("setSoundcloud");
        String sc = "https://www.soundcloud.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean result = instance.setSoundcloud(sc);
        assertEquals("Fail, method didn't return true", true, result);
    }
    
    /**
     * Test of setSoundcloud method, of class SocialMedia.
     */
    @Test
    public void testSetSoundcloudNull() {
        System.out.println("setSoundcloud - null");
        String sc = null;
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
        String web = "https://www.mungos-hifi.com";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, web, null);
        String result = instance.getWebsite();
        assertEquals("Fail, the returned URL didn't match the one set", web, result);
    }

    /**
     * Test of setWebsite method, of class SocialMedia.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String web = "https://www.mungos-hifi.com";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean result = instance.setSoundcloud(web);
        assertEquals("Fail, method didn't return true", true, result);
    }
    
    /**
     * Test of setWebsite method, of class SocialMedia.
     */
    @Test
    public void testSetWebsiteNull() {
        System.out.println("setWebsite - null");
        String web = null;
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
        String sp = "https://www.spotify.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, sp);
        String result = instance.getSpotify();
        assertEquals("Fail, the returned URL didn't match the one set", sp, result);
    }

    /**
     * Test of setSpotify method, of class SocialMedia.
     */
    @Test
    public void testSetSpotify() {
        System.out.println("setSpotify");
        String sp = "https://www.spotify.com/mungos_hifi";
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean result = instance.setSoundcloud(sp);
        assertEquals("Fail, method didn't return true", true, result);
    }
    
    /**
     * Test of setSpotify method, of class SocialMedia.
     */
    @Test
    public void testSetSpotifyNull() {
        System.out.println("setSpotify - null");
        String sp = null;
        SocialMedia instance = new SocialMedia(null, null, null, null, null, null, null, null);
        Boolean set = instance.setTwitter(sp);
        assertEquals("The method did not return false", set, false);
    }
}
