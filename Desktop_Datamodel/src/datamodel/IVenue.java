/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

/**
 *
 * @author 10467841
 */
public interface IVenue {
    
    public Integer getStandingCapacity();
    public Integer getSeatingCapacity();
    public Boolean getDisabledAccess();
    public String getFacilites();
    public Integer getParking();
    public String getEmail();
    public String getPhoneNumber();
    public String getAddress();
    public String getPostcode();
    
    public Boolean setStandingCapacity(Integer standing);
    public Boolean setSeatingCapacity(Integer seating);
    public Boolean setDisabledAccess(Boolean access);
    public Boolean setFacilites(String facilities);
    public Boolean setParking(Integer parking);
    public Boolean setEmail(String email);
    public Boolean setPhoneNumber(String phoneNumber);
    public Boolean setAddress(String address);
    public Boolean setPostcode(String postcode);
}
