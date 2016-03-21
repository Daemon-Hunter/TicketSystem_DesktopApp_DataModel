/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import java.util.Date;
import tickets.Ticket;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface IBooking extends IDbSubject {
    
    public Integer getBookingID();
    
    public Ticket  getTicket();
    public Boolean setTicket(Ticket ticket);
    
    public Integer getQuantity();
    public Boolean setQuantity(Integer qty);
    
    public Date    getBookingTime();
    public Boolean setBookingTime(Date time); // <--- ???
    
    public String  getCustomerAddress();
    public Boolean setCustomerAddress(String address);
    
    public String  getCustomerEmail();
    public Boolean setCustomerEmail(String email);
    
    public String  getCustomerPostcode();
    public Boolean setCustomerPostcode();
}
