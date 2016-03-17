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
    
    String getVenueID();
    String getVenueName();
    String getVenueDescription();
    Integer getVenueStandingCapacity();
    Integer getVenueSeatingCapacity();
    Boolean getVenueDisabledAccess();
    Boolean getVenueFacilites();
    Integer getVenueParking();
    String getVenueEmail();
    String getVenuePhoneNumber();
    String getVenueAddress();
    String getVenuePostcode();
    
    Boolean setVenueName(String name);
    Boolean setVenueDescription(String description);
    Boolean setVenueStandingCapacity(Integer standing);
    Boolean setVenueSeatingCapacity(Integer seating);
    Boolean setVenueDisabledAccess(Boolean access);
    Boolean setVenueFacilites(Boolean facilites);
    Boolean setVenueParking(Integer parking);
    Boolean setVenueEmail(String email);
    Boolean setVenuePhoneNumber(String phoneNumber);
    Boolean setVenueAddress(String address);
    Boolean setVenuePostcode(String postcode);
}
