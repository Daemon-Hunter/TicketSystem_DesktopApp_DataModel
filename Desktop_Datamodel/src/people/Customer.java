/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import database.DatabaseTable;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;
import reviews.IHaveReviews;
import reviews.IReview;
import reviews.Review;
import tickets.Ticket;
import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class Customer extends User implements IHaveReviews {
    
    private Integer ID;
    private DatabaseTable table = DatabaseTable.CUSTOMER;
    
    /**
     * Use this when creating a customer object from the database.
     * @param ID is known.
     * @param firstName
     * @param lastName
     * @param email
     * @param address
     * @param postcode 
     */
    public Customer(Integer ID, String firstName, String lastName,
            String email, String address, String postcode) {
      this.ID = ID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.address = address;
      this.postcode = postcode;
      validator = new Validator();
    }
    
    /**
     * Use this when creating a new customer object.
     * ID is unknown.
     * @param firstName
     * @param lastName
     * @param email
     * @param address
     * @param postcode 
     */
    public Customer(String firstName, String lastName,
            String email, String address, String postcode) {
      this.ID = 0;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.address = address;
      this.postcode = postcode;
      validator = new Validator();
    }

//    public Customer() {
//      this.customerID = 0;
//      this.firstName = "";
//      this.lastName = "";
//      this.email = "";
//      this.address = "";
//      this.postcode = "";
//      validator = new Validator();
//    }

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
                                                        .filter     //filter bookings array where current booking's ticket = parameter
                                                        (booking -> booking.getTicket().equals(ticket));
            
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
            Boolean valid = validator.emailValidator(email);
            if (valid) {
                this.email = email;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public void notifyObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<IReview> getReviews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Review getReview(Integer uniqueID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteReview(IReview review) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setAddress(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPostcode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setPostcode(String postcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setLastName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}