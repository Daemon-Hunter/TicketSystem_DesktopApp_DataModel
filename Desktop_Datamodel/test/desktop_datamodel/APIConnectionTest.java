/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import database.APIConnection;
import database.DatabaseTable;
import database.MapToObject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
    Map<String,String> editedCustomer = new HashMap<>();
    APIConnection custConn = new APIConnection(DatabaseTable.LINEUP);
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
//        customer.put("CUSTOMER_ID","0");
//        customer.put("CUSTOMER_FIRST_NAME", "James");
//        customer.put("CUSTOMER_LAST_NAME", "White");
//        customer.put("CUSTOMER_POSTCODE", "This");
//        customer.put("CUSTOMER_EMAIL", "is");
//        customer.put("CUSTOMER_PASSWORD", "doctor");
//        customer.put("CUSTOMER_ADDRESS", "here and there street");
//        
//        editedCustomer.put("CUSTOMER_ID","48"); // CHANGE THIS TO THE REAL ONE
//        editedCustomer.put("CUSTOMER_FIRST_NAME", "James");
//        editedCustomer.put("CUSTOMER_LAST_NAME", "Green");
//        editedCustomer.put("CUSTOMER_POSTCODE", "DY101ST ");
//        editedCustomer.put("CUSTOMER_EMAIL", "jimNew@googlemail.COM");
//        editedCustomer.put("CUSTOMER_PASSWORD", "passwordcomplex");
//        editedCustomer.put("CUSTOMER_ADDRESS", "mansion drive plymouth");

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAdd()
    {
        System.out.print(custConn.readSingle(0).get("ARTIST3_ID"));

        
    }
//            public void testRead()
//    {
//    }
//    @Test0
//        public void testUpdate()
//    {
//                custConn.add(customer);
//                custConn.update(47,customer);
//
//    }
//        
//           @Test
//        public void testDelete()
//    {
//                custConn.add(customer);
//                custConn.update(47,customer);
//
//    }

}