/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import utilities.observer.IDbSubject;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 10512691
 */
public interface IChildEvent extends IDbSubject, ISocial {
    
    Integer getID();
    String  getName();
    String  getDescription();
    Date    getStartDateTime();
    Date    getEndDateTime();
    Boolean getCancelled();
    
    Boolean setName(String name);
    Boolean setDescription(String description);
    Boolean setStartDateTime(Date startDateTime);
    Boolean setEndDateTime(Date endDateTime);
    Boolean setCancelled(Boolean cancelled);
    
    Boolean setVenue(IVenue venue);
    IVenue  getVenue();
    
    List<IArtist> getArtistList() throws IOException;

    IParentEvent getParentEvent();

    void setVenueID(Integer venue);

    void setSocialMedia(SocialMedia socialMedia);
}
