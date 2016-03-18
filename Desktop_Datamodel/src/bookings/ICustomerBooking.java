/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import people.Customer;

/**
 *
 * @author 10512691
 */
public interface ICustomerBooking {
    
    public Customer getCustomer();
    public Boolean  setCustomer(Customer c);
}
