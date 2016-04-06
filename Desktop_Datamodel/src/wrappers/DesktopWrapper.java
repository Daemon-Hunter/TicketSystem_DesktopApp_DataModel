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
import people.IAdmin;
import people.IUser;
/**
 *
 * @author 10512691
 */
public class DesktopWrapper implements IDesktopWrapper {
    List<IParentEvent> parentEventArray;
    List<IVenue>       venueArray;
    List<IArtist>      artistArray;
    List<IUser>        userArray;
    List<IAdmin>       adminArray;

    public DesktopWrapper(){}
    
    @Override
    public Boolean addUser(IUser user) {
        if (userArray == null){
            userArray = new ArrayList();
        }
        if (user == null){
            throw new IllegalArgumentException("Cannot add null user.");
        }
        return userArray.add(user);
    }

    @Override
    public List<IUser> getUsers() {
        return new ArrayList(userArray);
    }

    @Override
    public Boolean removeUser(IUser user) {
        if (user == null){
            throw new IllegalArgumentException("Cannot remove a null user");
        }
        return userArray.remove(user);
    }

    @Override
    public IUser getUser(Integer index) {
        return userArray.get(index);
    }

    @Override
    public Boolean addAdmin(IAdmin admin) {
        if (adminArray == null){
            adminArray = new ArrayList();
        }
        if (admin == null){
            throw new IllegalArgumentException("Cannot add a null admin");
        }
        return adminArray.add(admin);
    }

    @Override
    public IAdmin getAdmin(Integer adminID) {
        return adminArray.get(adminID);
    }

    @Override
    public List<IAdmin> getAdmins() {
        return new ArrayList(adminArray);
    }

    @Override
    public Boolean removeAdmin(IAdmin admin) {
        if(admin == null){
            throw new IllegalArgumentException("Cannot remove a null admin.");
        }
        return adminArray.remove(admin);
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
    public Boolean addArtist(IArtist artist) {
        if (artistArray == null){
            artistArray = new ArrayList();
        }
        if(artist == null){
            throw new IllegalArgumentException("Cannot add a null artist.");
        }
        return artistArray.add(artist);
    }

    @Override
    public IArtist getArtist(Integer artistID) {
        return artistArray.get(artistID);
    }

    @Override
    public List<IArtist> getArtists() {
        return new ArrayList(artistArray);
    }

    @Override
    public Boolean removeArtist(IArtist artist) {
        if (artist == null){
            throw new IllegalArgumentException("Cannot remove a null artist.");
        }
        return artistArray.remove(artist);
    }
}
