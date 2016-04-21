/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import java.util.List;
import people.IUser;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10467841
 */
public interface IOrder extends IDbSubject {
    
    
    public Integer getOrderID();
    public IUser getUser();
    public List<IBooking> getBookingList();
    public IBooking getBooking(Integer bookingID);
    public Boolean removeBooking(IBooking booking);
    public Boolean addBooking(IBooking booking);
    public void addBookingList(List<IBooking> bookingList);
}
