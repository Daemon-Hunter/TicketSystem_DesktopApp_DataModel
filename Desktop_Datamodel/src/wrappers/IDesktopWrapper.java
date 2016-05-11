/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import bookings.GuestBooking;
import bookings.IOrder;
import people.IAdmin;
import people.ICustomer;
import people.IGuest;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import tickets.ITicket;

/**
 *
 * @author 10467841
 */
public interface IDesktopWrapper extends IWrapper {
    Boolean      addCustomer(ICustomer customer);
    List<ICustomer>  getCustomers()throws IOException;
    ICustomer    getCustomer(Integer index) throws IOException;
    Boolean      removeCustomer(ICustomer customer);
    List<ICustomer>  loadMoreCustomers() throws IOException;
    List<ICustomer>  refreshCustomers() throws IOException;
    List<ICustomer> searchCustomers(String string) throws IOException;
    
    Boolean      addAdmin(IAdmin admin);
    IAdmin       getAdmin(Integer index) throws IOException;
    List<IAdmin> getAdmins() throws IOException;
    Boolean      removeAdmin(IAdmin admin);
    List<IAdmin>  loadMoreAdmins() throws IOException;
    List<IAdmin>  refreshAdmins() throws IOException;
    
    IOrder makeCustomerBooking(ICustomer customer ,ITicket ticket,Integer quantity) throws IOException;
    
    Boolean      addGuestBooking(GuestBooking guest);
    List<GuestBooking>  getGuestBookings()throws IOException;
    GuestBooking    getGuestBooking(Integer index) throws IOException;
    Boolean      removeGuestBooking(GuestBooking customer);
    List<GuestBooking>  loadMoreGuestBookings() throws IOException;
    List<GuestBooking>  refreshGuestBookings() throws IOException;
    List<GuestBooking> searchGuestBookings(String string) throws IOException;

    Boolean loginAdmin(String email, String password) throws IOException;
    Boolean checkAdminPassword(String email, String password) throws IOException;
    IAdmin  getCurrentAdmin();
}
