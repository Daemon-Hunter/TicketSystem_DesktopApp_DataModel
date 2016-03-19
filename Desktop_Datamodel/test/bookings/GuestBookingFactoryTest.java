/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import people.Customer;
import tickets.Ticket;

/**
 *
 * @author 10467841
 */
public class GuestBookingFactoryTest {
    
    public GuestBookingFactoryTest() {
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
     * Test of createBooking method, of class GuestBookingFactory.
     */
    @Test
    public void testCreateBooking() {
        System.out.println("createBooking");
        Ticket ticket = null;
        Customer customer = null;
        Integer quantity = null;
        GuestBookingFactory instance = new GuestBookingFactory();
        Booking expResult = null;
        Booking result = instance.createBooking(ticket, customer, quantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
