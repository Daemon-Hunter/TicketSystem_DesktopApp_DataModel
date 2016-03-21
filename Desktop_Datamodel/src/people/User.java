/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import java.util.LinkedList;

/**
 *
 * @author 10512691
 */
public abstract class User implements IUser {
    
    protected LinkedList<IBooking> bookings;
    protected String firstName, lastName, email, address, postcode;
    
    @Override
    public LinkedList<IBooking> getBookings() {
        return bookings;
    }
}
