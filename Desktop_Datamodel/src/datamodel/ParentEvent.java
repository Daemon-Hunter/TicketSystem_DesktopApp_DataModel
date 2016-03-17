/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.net.URL;
import java.util.LinkedList;
import reviews.Review;
import reviews.ReviewBase;
import reviews.IReviewFactory;
import utilities.observer.IObserver;
import utilities.observer.ISubject;

/**
 *
 * @author 10512691
 */
public class ParentEvent extends ReviewBase {
    
    // Initialise 'Social' variables
    private Integer socialId;
    private URL     image, instagram, soundcloud, 
                    spotify, twitter, website;
    
    private LinkedList<ChildEvent> childEvents;
    
    /**
     * Empty constructor initializes it's review factory and child event list.
     */
    public ParentEvent() {
        // Initialize table variable, which matches Java object to database table
        table = DatabaseTable.PARENTEVENT;
    }
    
    public ParentEvent createEvent() {
        return this;
    }

    public Integer getSocialId() {
        return socialId;
    }

    public void setSocialId(Integer socialId) {
        this.socialId = socialId;
    }

    public LinkedList<ChildEvent> getChildEvents() {
        return childEvents;
    }

    public void setChildEvents(LinkedList<ChildEvent> childEvents) {
        this.childEvents = childEvents;
    }
    
    @Override
    public ISubject notifyObservers() {
        return this;
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setImage(URL img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getFacebook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setFacebook(URL fb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getTwitter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setTwitter(URL tw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getInstagram() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setInstagram(URL insta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getSoundcloud() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setSoundcloud(URL sc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getWebsite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setWebsite(URL web) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public URL getSpotify() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setSpotify(URL sp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Review getReview(Integer custId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteReview(Review review) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IReviewFactory getReviewFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
