/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import database.APIConnection;
import database.DatabaseTable;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dominic
 */
public class APIConnectionTest {
    Map<String,String> customer = new HashMap<>();
    APIConnection custConn = new APIConnection(DatabaseTable.CUSTOMER);
    public APIConnectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        customer.put("CUSTOMER_ID", "0");
        customer.put("CUSTOMER_FIRST_NAME", "EMINIEM");
        customer.put("CUSTOMER_LAST_NAME", "JOKER");
        customer.put("CUSTOMER_POSTCODE", "PL48EG");
        customer.put("CUSTOMER_EMAIL", "D@G.COM");
        customer.put("CUSTOMER_PASSWORD", "HERO");
        customer.put("CUSTOMER_ADDRESS", "BACK AND BEYOND");

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd()
    {
                custConn.add(customer);

    }
    
}
