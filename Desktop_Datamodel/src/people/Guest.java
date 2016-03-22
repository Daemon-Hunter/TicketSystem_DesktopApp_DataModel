/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import database.DatabaseTable;
import java.util.LinkedList;
import tickets.Ticket;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class Guest extends User {

    DatabaseTable table = DatabaseTable.GUESTBOOKING;
    
    public Guest(String fName, String lName, String email_, String address_, String pcode) {
        super(fName, lName, email_, address_, pcode);
    }
    
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Boolean setEmail(String email) {
        this.email = email;
        notifyObservers();
        return (this.email == email);
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public Boolean setAddress(String address) {
        this.address = address;
        notifyObservers();
        return (this.address == address);
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public Boolean setPostcode(String postcode) {
        this.postcode = postcode;
        notifyObservers();
        return (this.postcode == postcode);
    }

    @Override
    public Boolean getCustomerID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFirstName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setFirstName(String name) {
        this.firstName = name;
        notifyObservers();
        return (this.firstname == name);
    }

    @Override
    public String getLastName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setLastName(String name) {
        this.lastName = name;
        notifyObservers();
        return (this.lastName == name);
    }
    
}
