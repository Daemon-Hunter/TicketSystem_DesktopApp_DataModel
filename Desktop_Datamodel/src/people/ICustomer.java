/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import bookings.IOrder;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 10467841
 */
public interface ICustomer {
    List<IOrder> getOrderList() throws IOException;
    IOrder getOrder(int orderID);
    Boolean addOrder(IOrder order);
    Boolean addOrderList(List<IOrder> orderList);
    Boolean removeOrder(IOrder order);

    List<IBooking> getBookings() throws IOException;
    
}
