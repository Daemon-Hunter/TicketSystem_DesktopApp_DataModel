/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import java.util.Date;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public abstract class Booking implements IBooking {
    
    protected Integer bookingID;
    protected Ticket  ticket;
    protected Integer ticketQuantity;
    protected Date    bookingDateTime;
    
    @Override
    public Integer getBookingID() {
        return bookingID;
    }
    
    @Override
    public Ticket getTicket() {
        return ticket;
    }
    @Override
    public Boolean setTicket(Ticket ticket) {
        this.ticket = ticket;
        return true;
    }
    
    @Override
    public Integer getQuantity() {
        return ticketQuantity;
    }
    @Override
    public Boolean setQuantity(Integer qty) {
        ticketQuantity = qty;
        return true;
    }
    
    @Override
    public Date getBookingTime() {
        return bookingDateTime;
    }
    @Override
    public Boolean setBookingTime(Date time) {
        bookingDateTime = time;
        return true;
    }
}
