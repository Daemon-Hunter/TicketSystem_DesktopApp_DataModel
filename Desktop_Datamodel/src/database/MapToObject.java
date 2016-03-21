/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Map;
import people.Customer;

/**
 *
 * @author Dominic
 */
public class MapToObject {
    
    public MapToObject()
    {
        
    }
    
  
    public Customer Convert(Map<String,String> custMap)
  {
     Customer cust = new Customer();
     cust.setFirstName(custMap.get("CUSTOMER_FIRST_NAME"));
     cust.setLastName(custMap.get("CUSTOMER_LAST_NAME"));
     cust.setCustomerID(Integer.parseInt(custMap.get("CUSTOMER_ID")));
     cust.setAddress(custMap.get("CUSTOMER_ADDRESS"));
     cust.setEmail(custMap.get("CUSTOMER_EMAIL"));
     cust.setPostcode(custMap.get("CUSTOMER_POSTCODE"));
       return cust;
    }
}
