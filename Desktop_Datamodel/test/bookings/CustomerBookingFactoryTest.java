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
 * This test class requires methods to be functional prior to testing.
 * The Booking classes method getCustomer()
 * The Customer classes method getPostcode()
 * @author 10467841
 */
public class CustomerBookingFactoryTest {
    
    public CustomerBookingFactoryTest() {
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
     * Test of createBooking method, of class CustomerBookingFactory.
     */
    @Test
    public void testCreateBooking() {
        System.out.println("createBooking");
        Ticket ticket = new Ticket(null, null, null, null, null, null);
        Customer customer = new Customer(null, null, null, null, null, "PL48LD");
        Integer quantity = 1;
        CustomerBookingFactory instance = new CustomerBookingFactory();
        CustomerBooking result = instance.createBooking(ticket, customer, quantity);
        
        if (!result.getCustomer().getPostcode().equals("PL48LD")) {
            fail("The booking was not made correctly");
        }
    }
}
