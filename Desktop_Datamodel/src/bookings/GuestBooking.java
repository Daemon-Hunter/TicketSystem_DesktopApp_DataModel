/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.DatabaseTable;
import java.util.Date;
import people.Guest;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public class GuestBooking extends Booking {
    
    /**
     * Use this constructor when creating object from the database.
     * ID is known.
     * @param ID
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param email
     * @param address
     * @param postcode 
     */
    public GuestBooking (Integer ID, Ticket ticket, Integer ticketQty, Date dateTime,
            IOrder order) 
    {
        super(ID, ticket, order, ticketQty, dateTime);
        table = DatabaseTable.GUESTBOOKING;
    }
    
    /**
     * Use this constructor when creating a new GuestBooking.
     * ID is unknown.
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param email
     * @param address
     * @param postcode 
     */
    public GuestBooking (Ticket ticket, Integer ticketQty, Date dateTime,
            IOrder order) 
    {
        super(ticket, order, ticketQty, dateTime);
        table = DatabaseTable.GUESTBOOKING;
    } 
}
