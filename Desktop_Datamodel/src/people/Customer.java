/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import database.DatabaseTable;
import java.util.LinkedList;
import java.util.Optional;
import reviews.IHaveReviews;
import reviews.IReview;
import utilities.Validator;

/**
 *
 * @author 10512691
 */
public class Customer extends User implements IHaveReviews {

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
            String email, String address, String postcode) 
    {
        super(ID, firstName, lastName, email, address, postcode);
        table = DatabaseTable.CUSTOMER;
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
            String email, String address, String postcode) 
    {
        super(firstName, lastName, email, address, postcode);
        table = DatabaseTable.CUSTOMER;
        this.ID = 0;
    }

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
            Boolean valid = Validator.idValidator(customerID);
            
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
                
//              ***** JAVA 7 (NON-LAMBDA) *****
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
    public Boolean setFirstName(String name) {
        if (name == null) {
            throw new NullPointerException("Cannot set name to null");
        } else {
            Boolean valid = Validator.nameValidator(name);
            if (valid) {
                firstName = name;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setLastName(String name) {
        if (name == null) {
            throw new NullPointerException("Cannot set name to null");
        } else {
            Boolean valid = Validator.nameValidator(name);
            if (valid) {
                lastName = name;
                notifyObservers();
            }
            return valid;
        }
    }
}
