/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import bookings.IOrder;
import database.APIHandle;
import database.DatabaseTable;
import reviews.IReview;
import utilities.Validator;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static utilities.HashString.Encrypt;
import static utilities.Validator.idValidator;

/**
 *
 * @author 10512691
 */
public class Customer implements ICustomer {

    private String firstName, lastName, email, address, postcode, password;
    private DatabaseTable table;
    private Integer ID;
    private List<IReview> reviews;
    private List<IOrder> orders;
    
    
    
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
                    String email, String address, String postcode){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.table = DatabaseTable.CUSTOMER;
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
            String email, String address, String postcode, String password)
    {
        // Check if names are null or valid. All users must have a valid name.
        if (firstName == null || lastName == null) {
            throw new NullPointerException("Cannot set first or last name to null");
        }
        if (Validator.nameValidator(firstName) || Validator.nameValidator(lastName)) {
            this.firstName = firstName;
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid admin name");
        }

        // Check email. Email can be null.
        if (email != null) {
            if (Validator.emailValidator(email)) {
                this.email = email;
            } else {
                throw new IllegalArgumentException("Invalid email address");
            }
        } else {
            this.email = null;
        }

        // Check address. Users don't have to have an address, so it can be set to null
        if (address != null) {
            if (Validator.addressValidator(address)) {
                this.address = address;
            } else {
                throw new IllegalArgumentException("Invalid address.");
            }
        } else {
            this.address = null;
        }

        // Check the users postcode. Users don't have to have a postcode - so can be null
        if (postcode != null) {
            if (Validator.postcodeValidator(postcode)) {
                this.postcode = postcode;
            } else {
                throw new IllegalArgumentException("Invalid postcode");
            }
        } else {
            this.postcode = null;
        }

        this.password = Encrypt(password);
        table = DatabaseTable.CUSTOMER;
        this.ID = 0;
    }

    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public List<IReview> getReviews() {
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
            Boolean valid = idValidator(customerID);

            if (valid) {
                for (IReview r : reviews) {
                    if (r.getCustomerID().equals(customerID)) {
                        return r;
                    }
                }
                throw new IllegalArgumentException("No customers with that ID have "
                        + "written a review for this venue.");

            } else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }
    }

    @Override
    public Boolean deleteReview(IReview review) throws IOException {
        if (review == null) {
            throw new NullPointerException("Review to be deleted was null");
        } else if (!reviews.contains(review)) {
            throw new IllegalArgumentException("Review to be deleted wasn't in list");
        } else {
            this.reviews.remove(review);
            return true;
        }
    }

    @Override
    public Boolean setFirstName(String name) throws IOException {
        if (name == null) {
            throw new NullPointerException("Cannot set name to null");
        } else {
            Boolean valid = Validator.nameValidator(name);
            if (valid) {
                this.firstName = name;
            }
            return valid;
        }
    }

    @Override
    public Boolean setLastName(String name) throws IOException {
        if (name == null) {
            throw new NullPointerException("Cannot set name to null");
        } else {
            Boolean valid = Validator.nameValidator(name);
            if (valid) {
                this.lastName = name;
            }
            return valid;
        }
    }

    @Override
    public Boolean setPassword(String password) {
        this.password = password;
        return this.password == password;
    }

    @Override
    public List<IOrder> getOrderList() throws IOException {
        if (orders == null){
            orders = (List<IOrder>) (Object)APIHandle.getObjectsFromObject(this.ID, DatabaseTable.ORDER, DatabaseTable.CUSTOMER);
        }
        return new LinkedList(orders);
    }

    @Override
    public IOrder getOrder(int orderID) {
        return orders.get(orderID);
    }

    @Override
    public Boolean addOrder(IOrder order) {
        if (order == null){
            throw new IllegalArgumentException("Order cannot be Null.");
        } else {
        return orders.add(order);
        }
    }

    @Override
    public Boolean addOrderList(List<IOrder> orderList) {
        if (orderList == null){
            throw new IllegalArgumentException("Cannot add null order list.");
        } else {
        return this.orders.addAll(orderList);
        }
    }

    @Override
    public Boolean removeOrder(IOrder order) {
        if (order == null){
            throw new IllegalArgumentException("Cannot remove null order");
        } else {
        return orders.remove(order);
        }
    }

    @Override
    public List<IBooking> getBookings() throws IOException {
        List<IBooking> bookings = new LinkedList<>();
        getOrderList();
        for (IOrder order : orders){
            bookings.addAll(order.getBookingList());
        }
        return bookings;
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
    public Boolean setEmail(String email) throws IOException {
        if (email == null) {
            throw new NullPointerException("Cannot set email to null");
        } else {
            Boolean valid = Validator.emailValidator(email);
            if (valid) {
                this.email = email;
            }
            return valid;
        }
    }

    @Override
    public Integer getID() {
        if (ID == null) {
            throw new NullPointerException("ID is null");
        } else {
            return ID;
        }
    }

    @Override
    public String getFirstName() {
        if (firstName == null) {
            throw new NullPointerException("Null first name");
        } else {
            return firstName;
        }
    }

    @Override
    public String getLastName() {
        if (lastName == null) {
            throw new NullPointerException("Null last name");
        } else {
            return lastName;
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
    public Boolean setAddress(String address) throws IOException {
        if (address == null) {
            throw new NullPointerException("Cannot set address to null");
        } else {
            Boolean valid = Validator.addressValidator(address);
            if (valid) {
                this.address = address;
            }
            return valid;
        }
    }

    @Override
    public String getPostcode() {
        if (postcode == null) {
            throw new NullPointerException("Null postcode");
        } else {
            return postcode;
        }
    }

    @Override
    public Boolean setPostcode(String postcode) throws IOException {
        if (postcode == null) {
            throw new NullPointerException("Cannot set postcode to null");
        } else {
            Boolean valid = Validator.postcodeValidator(postcode);
            if (valid) {
                this.postcode = postcode;
            }
            return valid;
        }
    }

    @Override
    public String getPassword(){
        return password;
    }
}
