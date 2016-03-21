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
    
    /**
     * Use this constructor when creating a new object object.
     * @param newTicket
     * @param ticketQty
     * @param dateTime 
     */
    public Booking(Ticket newTicket, Integer ticketQty, Date dateTime) {
        bookingID = 0;
        ticket = newTicket;
        ticketQuantity = ticketQty;
        bookingDateTime = dateTime;
    }
    
    /**
     * Use this constructor when creating an object from the database.
     * @param ID
     * @param newTicket
     * @param ticketQty
     * @param dateTime 
     */
    public Booking(Integer ID, Ticket newTicket, Integer ticketQty, Date dateTime) {
        bookingID = ID;
        ticket = newTicket;
        ticketQuantity = ticketQty;
        bookingDateTime = dateTime;
    }
    
    @Override
    public Integer getBookingID() {
        if (bookingID == null) {
            throw new NullPointerException("Null booking ID");
        } else {
            return bookingID;
        }
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
