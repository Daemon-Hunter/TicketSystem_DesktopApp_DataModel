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
import people.Guest;
import people.User;
import tickets.Ticket;

/**
 *
 * @author 10512691
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
        Ticket ticket = new Ticket(null, null, null, null, null, null);
        User guest = new Guest("some", "name", "email@email.com", "address", "postcode");
        Integer quantity = 1;
        IBookingFactory instance = new GuestBookingFactory();
        Booking result = instance.createBooking(ticket, guest, quantity);
        if (!result.getUser().getFirstName().equals("GUEST")) {
            fail("The booking wasn't made correctly.");
        }
    }
}