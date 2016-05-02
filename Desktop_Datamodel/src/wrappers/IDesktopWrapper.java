/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import people.IAdmin;
import people.ICustomer;
import people.IGuest;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 10467841
 */
public interface IDesktopWrapper extends IWrapper {
    Boolean      addCustomer(ICustomer customer);
    List<ICustomer>  getCustomers()throws IOException;
    ICustomer    getCustomer(Integer index);
    Boolean      removeCustomer(ICustomer customer);
    List<ICustomer>  loadMoreCustomers() throws IOException;
    List<ICustomer>  refreshCustomers() throws IOException;
    
    Boolean      addAdmin(IAdmin admin);
    IAdmin       getAdmin(Integer index);
    List<IAdmin> getAdmins() throws IOException;
    Boolean      removeAdmin(IAdmin admin);
    List<IAdmin>  loadMoreAdmins() throws IOException;
    List<IAdmin>  refreshAdmins() throws IOException;

    Boolean      addGuest(IGuest guest);
    List<IGuest>  getGuests()throws IOException;
    IGuest    getGuest(Integer index);
    Boolean      removeGuest(IGuest customer);
    List<IGuest>  loadMoreGuests() throws IOException;
    List<IGuest>  refreshGuests() throws IOException;

    Boolean loginAdmin(String email, String password) throws IOException;
    IAdmin  getCurrentAdmin();
}
