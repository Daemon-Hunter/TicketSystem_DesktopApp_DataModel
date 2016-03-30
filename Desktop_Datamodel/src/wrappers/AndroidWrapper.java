/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

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
public class AndroidWrapper implements IUserWrapper {
    List<IParentEvent>  parentEventArray;
    List<IVenue>        venueArray;
    List<IArtist>       artistArray;
    IUser               currentUser;

    @Override
    public Boolean setUser(IUser user) {
        
        if (user == null){
            throw new NullPointerException("Cannot set user to null.");
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
        if (pEvent == null){
            throw new NullPointerException("Cannot set user to null.");
        }
        
        this.parentEventArray.add(pEvent);
        
        return (this.parentEventArray.contains(pEvent));
    }

    @Override
    public IParentEvent getParentEvent(Integer index) {
        return parentEventArray.get(index);
    }

    @Override
    public List<IParentEvent> getParentEvents() {
        List<IParentEvent> array = new ArrayList(parentEventArray);
        return array;
    }

    @Override
    public Boolean removeParentEvent(IParentEvent pEvent) {
        return parentEventArray.remove(pEvent);
    }

    @Override
    public Boolean addVenue(IVenue venue) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean addArtist(IArtist artist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IArtist getArtist(Integer artistID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IArtist> getArtists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeArtist(IArtist artist) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
