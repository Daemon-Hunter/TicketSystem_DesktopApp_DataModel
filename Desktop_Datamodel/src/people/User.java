/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import java.util.LinkedList;
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
    
    public User(String fName, String lName, String email_, String address_, String pcode){
        firstName = fName;
        lastName = lName;
        email = email_;
        address = address_;
        postcode = pcode;
    }
    
    @Override
    public LinkedList<IBooking> getBookings() {
        return bookings;
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
}
