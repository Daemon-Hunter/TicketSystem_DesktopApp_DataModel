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

/**
 *
 * @author 10512691
 */
public class Customer extends User implements IHaveReviews {

    private final DatabaseTable table = DatabaseTable.CUSTOMER;
    private LinkedList<IReview> reviews;
    
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
        super(ID, firstName, lastName, email, address, postcode);
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
      super(firstName, lastName, email, address, postcode);
      this.ID = 0;
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
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public LinkedList<IReview> getReviews() {
        if (reviews == null) {
            throw new NullPointerException();
        } else {
            return reviews;
        }
    }

    @Override
    public IReview getReview(Integer customerID) {
        if (customerID == null) {
            throw new NullPointerException();
        } else {
            Boolean valid = validator.idValidator(customerID);
            
            if (valid) {
                Optional<IReview> value = reviews.stream()
                                                .findAny()
                                                .filter(r -> r.getCustomerID()
                                                .equals(customerID));
                if (value.isPresent()) {
                    return value.get();
                } else {
                    throw new IllegalArgumentException("No customers with that ID have "
                        + "written a review for this venue.");
                }
                
//              ***** JAVA 7 VERSION (NON-LAMBDA) *****
//                for (Review r : reviews) {
//                    if (r.getCustomerID().equals(customerID)) {
//                        return r;
//                    }
//                }
//                throw new IllegalArgumentException("No customers with that ID have "
//                     + "written a review for this venue.");

            } else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }
        
    }

    @Override
    public Boolean deleteReview(IReview review) {
        if (review == null) {
            throw new NullPointerException("Review to be deleted was null");
        } else if (!reviews.contains(review)) {
            throw new IllegalArgumentException("Review to be deleted wasn't in list");
        } else {
            reviews.remove(review);
            notifyObservers();
            return true;
        }
    }

    @Override
    public String getAddress() {
        if (address == null) {
            throw new NullPointerException("Null address");
        } else {
            return address;
        }
    }

    @Override
    public Boolean setAddress(String address) {
        if (address == null) {
            throw new NullPointerException("Cannot set address to null");
        } else {
            Boolean valid = validator.addressValidator(address);
            if (valid) {
                this.address = address;
                notifyObservers();
            }
            return valid;
        }
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