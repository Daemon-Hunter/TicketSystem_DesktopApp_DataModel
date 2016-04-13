/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.DatabaseTable;
import java.util.Date;
import people.Guest;
import people.IUser;
import tickets.Ticket;

/**
 *
 * @author 10512691
 */
public class GuestBooking extends Booking {
    
    private IUser guest;
    
    /**
     * Use this constructor when creating object from the database.
     * ID is known.
     * @param ID
     * @param ticket
     * @param ticketQty
     * @param dateTime
     * @param guest 
     */
    public GuestBooking (Integer ID, Ticket ticket, Integer ticketQty, Date dateTime,
            IUser guest) 
    {
        super(ID, ticket, ticketQty, dateTime);
        this.guest = guest;
        table = DatabaseTable.GUESTBOOKING;
    }
    
    /**
     * Use this constructor when creating a new GuestBooking.
     * ID is unknown.
     * @param ticket
     * @param ticketQty
     * @param dateTime 
     * @param guest 
     */
    public GuestBooking (Ticket ticket, Integer ticketQty, Date dateTime,
            IUser guest) 
    {
        super(ticket, ticketQty, dateTime);
        this.guest = guest;
        table = DatabaseTable.GUESTBOOKING;
    } 

    public IUser getGuest() {
        return guest;
    }

    public Boolean setGuest(Guest guest) {
        if (guest == null) {
            throw new NullPointerException("Cannot set user to null");
        } else {
            this.guest = guest;
            return this.guest == guest;
        }
    }
}
