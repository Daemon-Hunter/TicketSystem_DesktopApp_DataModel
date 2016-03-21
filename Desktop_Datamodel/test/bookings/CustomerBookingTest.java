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
import people.Customer;
import tickets.Ticket;

/**
 *
 * @author 10467841
 */
public class CustomerBookingTest {
    
    public CustomerBookingTest() {
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
     * Test of getTable method, of class CustomerBooking.
     */
    @Test
    public void testGetTable() {
        System.out.println("getTable");
        CustomerBooking instance = new CustomerBooking();
        DatabaseTable expResult = DatabaseTable.BOOKING;
        DatabaseTable result = instance.getTable();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBookingID method, of class CustomerBooking.
     */
    @Test
    public void testGetBookingID() {
        System.out.println("getBookingID");
        CustomerBooking instance = new CustomerBooking(6, null, null, null, null);
        Integer expResult = null;
        Integer result = instance.getBookingID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicket method, of class CustomerBooking.
     */
    @Test
    public void testGetTicket() {
        System.out.println("getTicket");
        Ticket expResult = new Ticket(null, null, null, null, null, null);
        CustomerBooking instance = new CustomerBooking(null, expResult, null, null, null);
        Ticket result = instance.getTicket();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTicket method, of class CustomerBooking.
     */
    @Test
    public void testSetTicket() {
        System.out.println("setTicket");
        Ticket ticket = new Ticket(null, null, null, null, null, null);
        CustomerBooking instance = new CustomerBooking();
        Boolean expResult = null;
        Boolean result = instance.setTicket(ticket);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class CustomerBooking.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        CustomerBooking instance = new CustomerBooking();
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer method, of class CustomerBooking.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        Customer c = null;
        CustomerBooking instance = new CustomerBooking();
        Boolean expResult = null;
        Boolean result = instance.setCustomer(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuantity method, of class CustomerBooking.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        CustomerBooking instance = new CustomerBooking();
        Integer expResult = null;
        Integer result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class CustomerBooking.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Integer qty = null;
        CustomerBooking instance = new CustomerBooking();
        Boolean expResult = null;
        Boolean result = instance.setQuantity(qty);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookingTime method, of class CustomerBooking.
     */
    @Test
    public void testGetBookingTime() {
        System.out.println("getBookingTime");
        CustomerBooking instance = new CustomerBooking();
        Date expResult = null;
        Date result = instance.getBookingTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookingTime method, of class CustomerBooking.
     */
    @Test
    public void testSetBookingTime() {
        System.out.println("setBookingTime");
        Date time = null;
        CustomerBooking instance = new CustomerBooking();
        Boolean expResult = null;
        Boolean result = instance.setBookingTime(time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
