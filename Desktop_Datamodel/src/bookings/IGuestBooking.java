/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookings;

/**
 *
 * @author 10512691
 */
public interface IGuestBooking {
    
    public String  getGuestEmail();
    public Boolean setGuestEmail(String email);
    
    public String  getGuestAddress();
    public Boolean setGuestAddress(String address);
    
    public String  getGuestPostcode();
    public Boolean setGuestPostcode(String postcode);
}
