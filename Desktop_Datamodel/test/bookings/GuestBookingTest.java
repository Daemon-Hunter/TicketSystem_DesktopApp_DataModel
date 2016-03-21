/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.DatabaseTable;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tickets.Ticket;
import utilities.observer.IObserver;
import utilities.observer.ISubject;

/**
 *
 * @author 10467841
 */
public class GuestBookingTest {
    
    public GuestBookingTest() {
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
     * Test of getTable method, of class GuestBooking.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        GuestBooking instance = new GuestBooking();
        DatabaseTable expResult = null;
        DatabaseTable result = instance.getTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerObserver method, of class GuestBooking.
     */
    @Test
    public void testRegisterObserver() {
        System.out.println("registerObserver");
        IObserver o = null;
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.registerObserver(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeObserver method, of class GuestBooking.
     */
    @Test
    public void testRemoveObserver() {
        System.out.println("removeObserver");
        IObserver o = null;
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.removeObserver(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingID method, of class GuestBooking.
     */
    @Test
    public void testGetBookingID() {
        System.out.println("getBookingID");
        GuestBooking instance = new GuestBooking();
        Integer expResult = null;
        Integer result = instance.getBookingID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicket method, of class GuestBooking.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        GuestBooking instance = new GuestBooking();
        Ticket expResult = null;
        Ticket result = instance.getTicket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicket method, of class GuestBooking.
     */
    @Test
    public void testSetTicket() {
        System.out.println("setTicket");
        Ticket ticket = null;
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.setTicket(ticket);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class GuestBooking.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        GuestBooking instance = new GuestBooking();
        Integer expResult = null;
        Integer result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class GuestBooking.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Integer qty = null;
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.setQuantity(qty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingTime method, of class GuestBooking.
     */
    @Test
    public void testGetBookingTime() {
        System.out.println("getBookingTime");
        GuestBooking instance = new GuestBooking();
        Date expResult = null;
        Date result = instance.getBookingTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookingTime method, of class GuestBooking.
     */
    @Test
    public void testSetBookingTime() {
        System.out.println("setBookingTime");
        Date time = null;
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.setBookingTime(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuestEmail method, of class GuestBooking.
     */
    @Test
    public void testGetGuestEmail() {
        System.out.println("getGuestEmail");
        GuestBooking instance = new GuestBooking();
        String expResult = "";
        String result = instance.getGuestEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuestEmail method, of class GuestBooking.
     */
    @Test
    public void testSetGuestEmail() {
        System.out.println("setGuestEmail");
        String email = "";
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.setGuestEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuestAddress method, of class GuestBooking.
     */
    @Test
    public void testGetGuestAddress() {
        System.out.println("getGuestAddress");
        GuestBooking instance = new GuestBooking();
        String expResult = "";
        String result = instance.getGuestAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuestAddress method, of class GuestBooking.
     */
    @Test
    public void testSetGuestAddress() {
        System.out.println("setGuestAddress");
        String address = "";
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.setGuestAddress(address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuestPostcode method, of class GuestBooking.
     */
    @Test
    public void testGetGuestPostcode() {
        System.out.println("getGuestPostcode");
        GuestBooking instance = new GuestBooking();
        String expResult = "";
        String result = instance.getGuestPostcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuestPostcode method, of class GuestBooking.
     */
    @Test
    public void testSetGuestPostcode() {
        System.out.println("setGuestPostcode");
        String postcode = "";
        GuestBooking instance = new GuestBooking();
        Boolean expResult = null;
        Boolean result = instance.setGuestPostcode(postcode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
