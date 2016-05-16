/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import bookings.IOrder;
import people.IUser;
import tickets.ITicket;

import java.io.IOException;
import java.util.List;

/**
 * The interface User wrapper.
 *
 * @author 10467841
 */
public interface IUserWrapper extends IWrapper {

    /**
     * Login user.
     *
     * @param email    Admin email.
     * @param password Admin password.
     * @return Boolean to indicate success of login.
     * @throws IOException Thrown if connection to the database fails.
     */
    Boolean loginUser(String email, String password) throws IOException;

    /**
     * Gets the current logged in user.
     *
     * @return The logged in user.
     */
    IUser getUser();

    /**
     * Register a user.
     *
     * @param customer The customer to be registered.
     * @return The the registered user.
     * @throws IOException Thrown if connection to the database fails.
     */
    IUser registerUser(IUser customer) throws IOException;

    /**
     * Make customer booking order.
     *
     * @param tickets    The tickets from the order.
     * @param quantities The quantities of tickets.
     * @return The order made.
     * @throws IOException Thrown if connection to the database fails.
     */
    IOrder makeCustomerBooking(List<ITicket> tickets, List<Integer> quantities) throws IOException;

}
