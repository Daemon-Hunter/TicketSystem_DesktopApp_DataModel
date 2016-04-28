/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import java.io.IOException;
import java.util.Date;

import tickets.ITicket;
import tickets.Ticket;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface IBooking extends IDbSubject {
    Integer getBookingID();

    Integer getTicketID();
    ITicket getTicket() throws IOException;
    Boolean setTicket(ITicket ticket);
    
    Integer getQuantity();
    Boolean setQuantity(Integer qty) throws IOException;
    
    Date    getBookingTime();
    Boolean setBookingTime(Date time) throws IOException;
}
