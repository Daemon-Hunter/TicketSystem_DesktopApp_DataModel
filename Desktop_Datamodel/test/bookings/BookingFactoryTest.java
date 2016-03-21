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
 * @author 10512691
 */
public class BookingFactoryTest {
    
    public BookingFactoryTest() {
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
     * Test of createBooking method, of class BookingFactory.
     */
    @Test
    public void testCreateBookingCustomer() {
        System.out.println("createBooking - customer");
        Ticket ticket = null;
        Customer customer = null;
        Integer quantity = null;
        BookingFactory instance = new BookingFactory();
        CustomerBooking expResult = null;
        CustomerBooking result = instance.createBooking(ticket, customer, quantity);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBooking method, of class BookingFactory.
     */
    @Test
    public void testCreateBookingGuest() {
        System.out.println("createBooking - guest");
        Ticket ticket = new Ticket(null, null, null, null, null, null);
        Integer quantity = 1;
        String email = "johnforde@plymouth.ac.uk";
        String address = "Plymouth University";
        String postcode = "PL48LD";
        BookingFactory instance = new BookingFactory();
        GuestBooking result = instance.createBooking(ticket, quantity, email, address, postcode);
        if (result.
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of createBooking method, of class GuestBookingFactory.
     */
    @Test
    public void testCreateBooking() {
        System.out.println("createBooking");
        Ticket ticket = new Ticket(null, null, null, null, null, null);
        BookingFactory instance = new BookingFactory();
        Booking result = instance.createBooking(ticket, null, null, null, "PL48LD");
        
        if (!result.getCustomerPostcode().equals("PL48LD")) {
            fail("The booking was not made correctly");
        }
    }
    
}
