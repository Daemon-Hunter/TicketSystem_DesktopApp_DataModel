/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import java.util.ArrayList;
import java.util.List;
import people.Customer;
import people.IUser;

/**
 *
 * @author 10467841
 */
public class Order implements IOrder{
   
    private Integer orderID;
    private IUser user;
    private List<Booking> bookingList;
    
    
    public Order(Integer ID, IUser user, List<Booking> bList){
        this.orderID = ID;
        this.user = user;
        if (bList != null){
            this.bookingList = bList;
        } else {
            this.bookingList = new ArrayList();
        }
        
    }

    @Override
    public Integer getOrderID() {
        return orderID;
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public List<Booking> getBookingList() {
        return new ArrayList(bookingList);
    }

    @Override
    public Booking getBooking(Integer bookingID) {
        return bookingList.get(bookingID);
    }

    @Override
    public Boolean removeBooking(Booking booking) {
        return bookingList.remove(booking);
    }

    @Override
    public Boolean addBooking(Booking booking) {
        return bookingList.add(booking);
    }
}
