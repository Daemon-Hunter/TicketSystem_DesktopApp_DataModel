/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import datamodel.Artist;
import datamodel.IArtist;
import datamodel.IParentEvent;
import datamodel.IVenue;
import java.util.ArrayList;
import java.util.List;
import people.IUser;

/**
 *
 * @author 10512691
 */
public class UserWrapper implements IUserWrapper {
    List<IParentEvent>  parentEventArray;
    List<IVenue>        venueArray;
    List<Artist>        artistArray;
    IUser               currentUser;

    
    
    public UserWrapper(){}
    
    public UserWrapper(IUser user){
        this.currentUser = user;
    }
    
    @Override
    public Boolean setUser(IUser user) {
        if (user == null){
            throw new IllegalArgumentException("Cannot set user to null.");
        }
        this.currentUser = user;
        return (this.currentUser == user);
    }

    @Override
    public IUser getUser() {
        return this.currentUser;
    }

    @Override
    public Boolean addParentEvent(IParentEvent pEvent) {
        if (parentEventArray == null){
            parentEventArray = new ArrayList();
        }
        if (pEvent == null){
            throw new IllegalArgumentException("Cannot set user to null.");
        }
        return this.parentEventArray.add(pEvent);
    }

    @Override
    public IParentEvent getParentEvent(Integer index) {
        return parentEventArray.get(index);
    }

    @Override
    public List<IParentEvent> getParentEvents() {
        return new ArrayList(parentEventArray);
    }

    @Override
    public Boolean removeParentEvent(IParentEvent pEvent) {
        if (pEvent == null){
            throw new IllegalArgumentException("Cannot remove null value.");
        }
        return parentEventArray.remove(pEvent);
    }

    @Override
    public Boolean addVenue(IVenue venue) {
        if (venueArray == null){
            venueArray = new ArrayList();
        }
        if (venue == null){
            throw new IllegalArgumentException("Cannot add null venue.");
        }
        return venueArray.add(venue);
    }

    @Override
    public IVenue getVenue(Integer index) {
        return venueArray.get(index);
    }

    @Override
    public List<IVenue> getVenues() {
        return new ArrayList(venueArray);
    }

    @Override
    public Boolean removeVenue(IVenue venue) {
        if(venue == null){
            throw new IllegalArgumentException("Cannot remove a null venue.");
        }
        return venueArray.remove(venue);
    }

    @Override
    public Boolean addArtist(Artist artist) {
        if (artistArray == null){
            artistArray = new ArrayList();
        }
        if(artist == null){
            throw new IllegalArgumentException("Cannot add a null artist.");
        }
        return artistArray.add(artist);
    }

    @Override
    public Artist getArtist(Integer artistID) {
        return artistArray.get(artistID);
    }

    @Override
    public List<Artist> getArtists() {
        return new ArrayList(artistArray);
    }

    @Override
    public Boolean removeArtist(Artist artist) {
        if (artist == null){
            throw new IllegalArgumentException("Cannot remove a null artist.");
        }
        return artistArray.remove(artist);
    }
}
