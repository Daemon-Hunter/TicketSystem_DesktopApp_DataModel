/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import events.IArtist;
import events.IParentEvent;
import events.IVenue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 10467841
 */
public interface IWrapper {

    LinkedList getParentEvents() throws IOException;
    List<IParentEvent> loadMoreParentEvents() throws IOException;
    IParentEvent       getParentEvent(Integer id);
    Boolean            removeParentEvent(IParentEvent pEvent);
    List<IParentEvent> refreshParentEvents() throws IOException;
    List<IParentEvent> searchParentEvents(String string) throws IOException;


    List<IVenue> getVenues() throws IOException;
    IVenue       getVenue(Integer id);
    List<IVenue> loadMoreVenues() throws IOException;
    Boolean      removeVenue(IVenue venue);
    List<IVenue> refreshVenues() throws IOException;
    List<IVenue> searchVenues(String string) throws IOException;


    List<IArtist>  getArtists() throws IOException;
    List<IArtist>  loadMoreArtists() throws IOException;
    IArtist        getArtist(Integer id);
    Boolean        removeArtist(IArtist artist);
    List<IArtist>  refreshArtists() throws IOException;
    List<IArtist>  searchArtists(String string) throws IOException;

    Boolean setAmountToLoad(Integer amountToLoad);
}
