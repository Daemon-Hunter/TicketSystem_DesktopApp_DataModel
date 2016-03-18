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
        customer.put("CUSTOMER_ID","25");
        customer.put("CUSTOMER_FIRST_NAME", "Declan");
        customer.put("CUSTOMER_LAST_NAME", "HAS THIS WORKED");
        customer.put("CUSTOMER_POSTCODE", "pl5827");
        customer.put("CUSTOMER_EMAIL", "d@g.com");
        customer.put("CUSTOMER_PASSWORD", "I like turtles");
        customer.put("CUSTOMER_ADDRESS", "BIg house street");

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd()
    {
                custConn.update(25,customer);

    }
    
}
