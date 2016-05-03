/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.APIHandle;
import database.DatabaseTable;
import people.IUser;
import utilities.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 10467841
 */
public class Order implements IOrder {
   
    private Integer orderID;
    private Integer userID;
    private IUser user;
    private List<IBooking> bookingList;
    private DatabaseTable table = DatabaseTable.ORDER;
    
    /**
     * Use this constructor when creating an order object from the database.
     * @param ID
     * @param user
     * @param bList 
     */
    public Order(Integer ID, IUser user, List<IBooking> bList) {
        this.orderID = ID;
        this.user = user;
        if (bList != null){
            this.bookingList = bList;
        } else {
            this.bookingList = new LinkedList<>();
        }

    }

    /**
     * Use this constructor when create a new order object
     * @param ID
     * @param userID
     */
    public Order(Integer ID, Integer userID) {
        if (Validator.idValidator(ID)) {
            this.orderID = ID;

            if (Validator.idValidator(userID)) {
                this.userID = userID;
            } else {
                throw new IllegalArgumentException("Invalid user ID");
            }
        } else {
            throw new IllegalArgumentException("Invalid order ID");
        }
    }
    
    /**
     * Gets the order's unique ID
     * @return 
     */
    @Override
    public Integer getOrderID() {
        return orderID;
    }

    /**
     * Returns the user that made the order
     * @return 
     */
    @Override
    public IUser getUser() throws IOException {
        user = (IUser)APIHandle.getSingle(userID, DatabaseTable.CUSTOMER);
        userID = user.getID();
        return user;
    }

    @Override
    public Integer getUserID() {
        return userID;
    }

    /**
     * Gets the list of bookings related to the order
     * @return 
     */
    @Override
    public List<IBooking> getBookingList() throws IOException {
        bookingList = (List<IBooking>) (Object)APIHandle.getObjectsFromObject(this.orderID, DatabaseTable.BOOKING, DatabaseTable.ORDER);
        return new ArrayList(bookingList);
    }

    /**
     * Returns a single booking, get via booking ID.
     * @param bookingID
     * @return 
     */
    @Override
    public IBooking getBooking(Integer bookingID) {
        return bookingList.get(bookingID);
    }

    @Override
    public Boolean addBooking(IBooking booking) {
        if (booking == null){
            throw new IllegalArgumentException("Booking cannot be null");
        }
        return bookingList.add(booking);
    }
}
