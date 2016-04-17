/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;

/**
 *
 * @author 10467841
 */
public interface IGuest {
    public IBooking getBooking();
    public boolean setBooking(IBooking booking);
}
