/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.Booking;
import java.util.LinkedList;

/**
 *
 * @author 10512691
 */
public abstract class User implements IUser {
    
    protected LinkedList<Booking> bookings;
    protected String name, email, address, postcode;
    
    @Override
    public LinkedList<Booking> getBookings() {
        return bookings;
    }
}
