/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

import database.DatabaseTable;
import java.util.Date;
import java.util.LinkedList;
import people.User;
import tickets.Ticket;
import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public abstract class Booking implements IBooking {
    
    protected DatabaseTable table;
    protected User user;
    protected Integer bookingID;
    protected Ticket  ticket;
    protected Integer ticketQuantity;
    protected Date    bookingDateTime;
    protected LinkedList<IObserver> observers;
    
    /**
     * Use this constructor when creating a new object.
     * @param newTicket
     * @param user
     * @param ticketQty
     * @param dateTime 
     */
    public Booking(Ticket newTicket, User user, Integer ticketQty, Date dateTime) {
        bookingID = 0;
        this.user = user;
        ticket = newTicket;
        ticketQuantity = ticketQty;
        bookingDateTime = dateTime;
    }
    
    /**
     * Use this constructor when creating an object from the database.
     * @param ID
     * @param newTicket
     * @param user
     * @param ticketQty
     * @param dateTime 
     */
    public Booking(Integer ID, Ticket newTicket, User user, Integer ticketQty, Date dateTime) {
        bookingID = ID;
        this.user = user;
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
        if (ticket == null) {
            throw new NullPointerException("Null ticket");
        } else {
            return ticket;
        }
    }
    @Override
    public Boolean setTicket(Ticket ticket) {
        if (ticket == null) {
            throw new NullPointerException("Null ticket");
        } else {
            this.ticket = ticket;
            return true;
        }
    }
    
    @Override
    public Integer getQuantity() {
        if (ticketQuantity == null) {
            throw new NullPointerException("Null quantity");
        } else {
            return ticketQuantity;
        }
    }
    @Override
    public Boolean setQuantity(Integer qty) {
        if (qty == null) {
            throw new NullPointerException("Null quantity");
        } else {
            Boolean valid = Validator.quantityValidator(qty);
            if (valid) {
                ticketQuantity = qty;
                notifyObservers();
            }
            return valid;
        }
    }
    
    @Override
    public Date getBookingTime() {
        if (bookingDateTime == null) {
            throw new NullPointerException("Null booking date / time");
        } else {
            return bookingDateTime;
        }
    }
    @Override
    public Boolean setBookingTime(Date time) {
        if (time == null) {
            throw new NullPointerException("Null date / time");
        } else {
            Boolean valid = Validator.dateTimeValidator(time);
            if (valid) {
                bookingDateTime = time;
                notifyObservers();
            }
            return valid;
        }
    }    

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> { observer.update(this); });
        
        /*
            for (IObserver o : observers) {
                o.update(this);
            }
        */
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer");
        } else if (observers.contains(o)) {
            throw new IllegalArgumentException("Observer already exists in list");
        } else {
            observers.add(o);
            return true;
        }
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer");
        } else if (!observers.contains(o)) {
            throw new IllegalArgumentException("Observer doesn't exist in list");
        } else {
            observers.remove(o);
            return true;
        }
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Boolean setUser(User user) {
        if (user == null) {
            throw new NullPointerException("Cannot set user to null");
        } else {
            this.user = user;
            return this.user == user;
        }
    }
}
