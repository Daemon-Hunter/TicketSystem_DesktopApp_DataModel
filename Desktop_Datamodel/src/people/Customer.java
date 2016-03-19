/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

/**
 *
 * @author 10512691
 */
public class Customer {
    private int customer_ID;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerAddress;
    private String customerPostcode;
    private String customerPassword; // needs to be hashed / ciphered;
         
    
    
    public Customer(int ID, String firstName, String lastName,
            String email, String address, String postcode,
            String password)      
    {
      this.customer_ID = ID;
      this.customerFirstName = firstName;
      this.customerLastName = lastName;
      this.customerEmail = email;
      this.customerAddress = address;
      this.customerPostcode = postcode;
      this.customerPassword = password;
              
    }
    
}
