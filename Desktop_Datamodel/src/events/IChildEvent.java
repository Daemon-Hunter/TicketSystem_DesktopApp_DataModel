/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import tickets.ITicket;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import tickets.ITicketFactory;

/**
 *
 * @author 10512691
 */
public interface IChildEvent extends ISocial {
    
    Integer getID();
    String  getName();
    String  getDescription();
    Date    getStartDateTime();
    Date    getEndDateTime();
    Boolean getCancelled();
    
    Boolean setName(String name) throws IllegalArgumentException;
    Boolean setDescription(String description) throws IllegalArgumentException;
    Boolean setStartDateTime(Date startDateTime) throws IllegalArgumentException;
    Boolean setEndDateTime(Date endDateTime) throws IllegalArgumentException;
    Boolean setCancelled(Boolean cancelled) throws IllegalArgumentException;

    Integer getVenueID();
    Boolean setVenue(IVenue venue);
    IVenue  getVenue();
    
    List<IArtist> getArtistList() throws IOException;

    Integer getParentEventID();
    IParentEvent getParentEvent() throws IOException;
    Boolean setParentEvent(IParentEvent event);

    public ITicketFactory getTicketFactory();
    ITicket getTicket(Integer id);
    List<ITicket> getTickets() throws IOException;
    Boolean addTicket(ITicket ticket);
    Boolean removeTicket(ITicket ticket);


    void setVenueID(Integer venue);

    void setSocialMedia(SocialMedia socialMedia);

    Boolean newContract(IArtist artist) throws IOException;
}
