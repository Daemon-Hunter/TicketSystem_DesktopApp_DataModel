/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.DatabaseTable;
import java.util.Date;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public class CustomerBooking extends Booking {
    
    /**
     * Use this constructor when creating a booking object from the database.
     * @param ID
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param order 
     */
    public CustomerBooking (Integer ID, Ticket ticket, Integer ticketQty, Date dateTime,
            IOrder order) {
        super(ID, ticket, order, ticketQty, dateTime);
        table = DatabaseTable.BOOKING;
    }
    
    /**
     * Use this constructor when creating a new customer booking object.
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param order 
     */
    public CustomerBooking (Ticket ticket, Integer ticketQty, Date dateTime,
            IOrder order) {
        super(ticket, order, ticketQty, dateTime);
        table = DatabaseTable.BOOKING;
    }
}
