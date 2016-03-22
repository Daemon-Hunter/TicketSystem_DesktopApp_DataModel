/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import java.util.LinkedList;
import java.util.stream.Stream;
import tickets.Ticket;
import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public abstract class User implements IUser {
    
    protected LinkedList<IBooking> bookings;
    protected LinkedList<IObserver> observers;
    protected String firstName, lastName, email, address, postcode;
    protected Validator validator;
    protected Integer ID;
    
    
    public User(){}
    
    /**
     * Use when creating an object from the database.
     * e.g. ID is known.
     * @param ID
     * @param fName
     * @param lName
     * @param email_
     * @param address_
     * @param pcode 
     */
    public User(Integer ID, String fName, String lName, String email_, String address_, String pcode) {
        this.ID = ID;
        firstName = fName;
        lastName = lName;
        email = email_;
        address = address_;
        postcode = pcode;
    }
    
    /**
     * Use when creating a new object.
     * e.g. ID is unknown.
     * @param fName
     * @param lName
     * @param email_
     * @param address_
     * @param pcode 
     */
    public User(String fName, String lName, String email_, String address_, String pcode) {
        firstName = fName;
        lastName = lName;
        email = email_;
        address = address_;
        postcode = pcode;
    }
    
    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> {observer.update(this);});
    }
    
    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer, cannot register");
        } else if (observers.contains(o)) {
            throw new IllegalArgumentException("Observer already registered");
        } else {
            observers.add(o);
            return true;
        }
    }
    
    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer, cannot remove");
        } else if (!observers.contains(o)) {
            throw new IllegalArgumentException("Observer not in list");
        } else {
            observers.remove(o);
            return true;
        }
    }
    
    @Override
    public LinkedList<IBooking> getBookings() {
        if (bookings == null) {
            throw new NullPointerException("Null bookings list");
        } else return bookings;
    }
    
    @Override
    public LinkedList<IBooking> getBookingByTicket(Ticket ticket) {
        if (ticket == null) {
            throw new NullPointerException("Null ticket");
        } else {
            // Gets a Stream of IBooking objects from Customers list of bookings.
            // Filters by ticket.
            Stream<IBooking> relevantBookingsStream = bookings.stream()
                                                              .filter     
                                                              (booking -> booking.getTicket().equals(ticket));
                                                //filters bookings array where current booking's ticket = parameter
                                                
            // Declare LinkedList and populate with relevant bookings
            LinkedList<IBooking> relevantBookings = new LinkedList<>();
            relevantBookingsStream.forEach(booking -> relevantBookings.add(booking));
            
            return relevantBookings;
        }
    }
    
    @Override
    public String getEmail() {
        if (email == null) {
            throw new NullPointerException("Null email");
        } else {
            return email;
        }
    }

    @Override
    public Boolean setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Cannot set email to null");
        } else {
            Boolean valid = Validator.emailValidator(email);
            if (valid) {
                this.email = email;
                notifyObservers();
            }
            return valid;
        }
    }
    
    @Override
    public Integer getCustomerID() {
        if (ID == null) {
            throw new NullPointerException("ID is null");
        } else {
            return ID;
        }
    }
}
