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
public interface IGuest extends IUser {
    IBooking getBooking();
    boolean setBooking(IBooking booking);
}
