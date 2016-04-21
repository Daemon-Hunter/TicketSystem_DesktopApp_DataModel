/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import database.APIHandle;
import datamodel.IArtist;
import datamodel.IParentEvent;
import datamodel.IVenue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import people.IAdmin;
import people.IUser;
/**
 *
 * @author 10512691
 */
public class DesktopWrapper implements IDesktopWrapper {
    
    private static DesktopWrapper wrapper;

    private final Integer amountToLoad = 27;

    private List<IParentEvent>  parentEventArray;
    private List<IVenue>        venueArray;
    private List<IArtist>       artistArray;
    private List<IUser>         userArray;
    private List<IAdmin>        adminArray;

    private  DesktopWrapper(){}
    
    public static DesktopWrapper getInstance(){
        if (wrapper == null){
            wrapper = new DesktopWrapper();
        }
        return wrapper;
    }

    @Override
    public List<IParentEvent> getParentEvents() throws IOException {
        if (parentEventArray != null){
            return new ArrayList(parentEventArray);
        } else {
            //parentEventArray = APIHandle.getParentAmount(amountToLoad, parentEventArray.get(parentEventArray.size()).getParentEventID());
            parentEventArray = new ArrayList<>(APIHandle.getParentAmount(amountToLoad, 0));
            return new ArrayList(parentEventArray);
        }
    }

    @Override
    public List<IParentEvent> loadMoreParentEvents() throws IOException {
        int lowestID = 99999999;
        for (IParentEvent parentEvent : parentEventArray){
            if (parentEvent.getParentEventID() < lowestID)
                lowestID = parentEvent.getParentEventID();
        }
        List<IParentEvent> newData = APIHandle.getParentAmount(amountToLoad, lowestID);
        parentEventArray.addAll(newData);
        return new ArrayList(newData);
    }

    @Override
    public IParentEvent getParentEvent(Integer id) {
        for (IParentEvent parentEvent : parentEventArray){
            if(parentEvent.getParentEventID().equals(id));
            return parentEvent;
        }
        throw new NullPointerException("No item in the list has this id :/.");
    }

    @Override
    public Boolean removeParentEvent(IParentEvent pEvent) {
        if (pEvent == null){
            throw new IllegalArgumentException("Cannot remove null value.");
        }
        return parentEventArray.remove(pEvent);
    }

    @Override
    public List<IParentEvent> refreshParentEvents() throws IOException {
        parentEventArray = new ArrayList<>(APIHandle.getParentAmount(amountToLoad, 0));
        return new ArrayList(parentEventArray);
    }

    @Override
    public List<IParentEvent> searchParentEvents(String searchString) throws IOException {
        return new LinkedList<>(APIHandle.searchParentEvents(searchString));
    }

    @Override
    public List<IVenue> getVenues() throws IOException {
        if (venueArray != null){
            return new ArrayList(venueArray);
        } else {
            //venueArray = APIHandle.getVenueAmount(amountToLoad, venueArray.get(venueArray.size()).getVenueID());
            venueArray = new ArrayList<>(APIHandle.getVenueAmount(amountToLoad, 0));
            return new ArrayList(venueArray);
        }
    }

    @Override
    public IVenue getVenue(Integer id) {
        for (IVenue venue : venueArray){
            if(venue.getVenueID().equals(id));
                return venue;
        }
        throw new NullPointerException("No item in the list has this id :/.");
    }

    @Override
    public List<IVenue> loadMoreVenues() throws IOException {
        int lowestID = 0;
        for (IVenue venue : venueArray){
            if (venue.getVenueID() < lowestID || lowestID == 0)
                lowestID = venue.getVenueID();
        }
        List<IVenue> newData = APIHandle.getVenueAmount(amountToLoad, lowestID);
        venueArray.addAll(newData);
        return new ArrayList(newData);
    }

    @Override
    public Boolean removeVenue(IVenue venue) {
        if(venue == null){
            throw new IllegalArgumentException("Cannot remove a null venue.");
        }
        return venueArray.remove(venue);
    }

    @Override
    public List<IVenue> refreshVenues() throws IOException {
        venueArray = new ArrayList<>(APIHandle.getVenueAmount(amountToLoad, 0));
        return new ArrayList(venueArray);
    }

    @Override
    public List<IVenue> searchVenues(String searchString) throws IOException {
        return APIHandle.searchVenues(searchString);
    }

    @Override
    public List<IArtist> getArtists() throws IOException {
        if (artistArray != null){
            return new LinkedList(artistArray);
        } else {
            //artistArray = APIHandle.getArtistAmount(amountToLoad, artistArray.get(artistArray.size() - 1).getArtistID());
            artistArray = APIHandle.getArtistAmount(amountToLoad, 0);
            return new ArrayList<>(artistArray);
        }
    }

    @Override
    public List<IArtist> loadMoreArtists() throws IOException {
        int lowestID = 0;
        for (IArtist artist : artistArray){
            if (artist.getArtistID() < lowestID || lowestID == 0)
                lowestID = artist.getArtistID();
        }
        List<IArtist> newData = APIHandle.getArtistAmount(amountToLoad, lowestID);
        artistArray.addAll(newData);
        return new ArrayList(newData);
    }

    @Override
    public IArtist getArtist(Integer id) {
        for (IArtist artist : artistArray){
            if(artist.getArtistID().equals(id));
            return artist;
        }
        throw new NullPointerException("No item in the list has this id :/.");
    }

    @Override
    public Boolean removeArtist(IArtist artist) {
        if (artist == null){
            throw new IllegalArgumentException("Cannot remove a null artist.");
        }
        return artistArray.remove(artist);
    }

    @Override
    public List<IArtist> refreshArtists() throws IOException {
        artistArray = APIHandle.getArtistAmount(amountToLoad, 0);
        return new ArrayList<>(artistArray);
    }

    @Override
    public List<IArtist> searchArtists(String searchString) throws IOException {
        return APIHandle.searchArtists(searchString);
    }

    @Override
    public Boolean addUser(IUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IUser> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IUser getUser(Integer index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeUser(IUser user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean addAdmin(IAdmin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IAdmin getAdmin(Integer index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IAdmin> getAdmins() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeAdmin(IAdmin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
