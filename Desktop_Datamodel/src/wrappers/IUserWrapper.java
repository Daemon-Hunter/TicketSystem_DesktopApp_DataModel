/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import bookings.IBooking;
import bookings.IOrder;
import people.IUser;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 10467841
 */
public interface IUserWrapper extends IWrapper {

    Boolean loginUser(String email, String password) throws IOException;
    IUser   getUser();
    IUser registerUser(IUser customer) throws IOException;

    IOrder makeBooking(List<IBooking> bookings) throws IOException;
}
