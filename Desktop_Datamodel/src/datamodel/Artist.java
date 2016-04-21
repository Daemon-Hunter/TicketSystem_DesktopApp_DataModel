/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.awt.image.BufferedImage;
import reviews.ArtistReviewFactory;
import reviews.IReview;
import reviews.IReviewFactory;
import utilities.Validator;
import utilities.observer.IObserver;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static utilities.Validator.idValidator;

/**
 *
 * @author 10512691
 */
public class Artist implements IArtist {


    private List<Integer> childEventIDs;
    private List<IChildEvent> childEvents;
    private List<IReview> reviews;

    private Integer socialMediaID;
    private SocialMedia socialMedia;

    private IReviewFactory reviewFactory;
    private List<IObserver> observers;
    private String description;
    private DatabaseTable table;
    private int ID;
    private String name;

    /*
        Inherits:
        IReviewFactory        reviewFactory;
        LinkedList<Review>    reviews;
        LinkedList<IObserver> observers;
        SocialMedia           socialMedia;
        Integer               socialMediaID
        DatabaseTable         table;
     */
    
    private LinkedList<String> tags;
    
    public Artist() {
        this.table = DatabaseTable.ARTIST;
        tags = new LinkedList<>();
        reviewFactory = new ArtistReviewFactory();
        childEventIDs = new LinkedList<>();
        childEvents = new LinkedList<>();
    }

    public Artist(Integer ID, String name, String description, LinkedList<String> tags, SocialMedia social,
                  List<IReview> reviewsList, List<Integer> childEventIDs) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.socialMedia = social;
        this.reviews = reviewsList;
        this.table = DatabaseTable.ARTIST;

        // Initialise default values for rest of attributes
        this.tags = tags;
        reviewFactory = new ArtistReviewFactory();
        this.childEventIDs = childEventIDs;
        this.childEvents = new LinkedList<>();
    }

    public Artist(Integer ID, String name, String description, LinkedList<String> tags, Integer socialMediaID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.socialMedia = new SocialMedia();
        this.reviews = new LinkedList<>();
        this.table = DatabaseTable.ARTIST;
        this.socialMediaID = socialMediaID;

        // Initialise default values for rest of attributes
        this.tags = tags;
        reviewFactory = new ArtistReviewFactory();
        this.childEventIDs = new LinkedList<>();
        this.childEvents = new LinkedList<>();
    }

    @Override
    public List<String> getArtistTags() {
        return tags;
    }

    @Override
    public Boolean addArtistTag(String tag) {
        if (tag == null) {
            throw new NullPointerException();
        } else {
            Boolean valid = Validator.tagValidator(tag);
            if (valid) {
                tags.add(tag);
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean removeArtistTag(String tag) {
        
        return tags.remove(tag);
            
    }

    @Override
    public Integer getArtistID() {
        return ID;
    }

    @Override
    public String getArtistName() {
        return name;
    }

    @Override
    public void setArtist(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        if (description == null) {
            throw new NullPointerException("Artist description is null");
        } else {
            return description;
        }
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    @Override
    public List<IChildEvent> getChildEvents() {
        return new LinkedList<>(childEvents);
    }

    @Override
    public Boolean removeChildEvent(IChildEvent childEvent) {
        return childEvents.remove(childEvent);
    }

    @Override
    public Boolean addChildEvent(IChildEvent childEvent) {
        return childEvents.add(childEvent);
    }

    @Override
    public List<Integer> getChildEventIDs() {
        return new LinkedList<>(childEventIDs);
    }

    @Override
    public Boolean removeChildEventID(Integer childEventID) {
        return childEventIDs.remove(childEventID);
    }

    @Override
    public Boolean addChildEventID(Integer childEventID) {
        return childEventIDs.add(childEventID);
    }

    @Override
    public Integer getSocialId() {
        return socialMediaID;
    }

    /**
     * Checks the validity of the ID before assigning.
     * @param id
     * @return Boolean true if ID set.
     */

    @Override
    public Boolean setSocialId(Integer id) {
        socialMediaID = id;
        return socialMedia.setSocialId(id);
    }



    protected IReviewFactory getReviewFactory() {
        return reviewFactory;
    }

    /**
     * Adds IObserver object to list of objects to notify when a change is made.
     * Checks if the object is null or already exists in the list.
     * @param o
     * @return
     */
    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer");
        } else if (observers.contains(o)) {
            throw new IllegalArgumentException("Observer already exists");
        } else {
            observers.add(o);
            return true;
        }
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer");
        } else if (!observers.contains(o)) {
            throw new IllegalArgumentException("Observer doesn't exist in observers list");
        } else {
            observers.remove(o);
            return true;
        }
    }

    @Override
    public void notifyObservers() {
        if (observers == null) {
            observers = new LinkedList();
        } else {
            for (IObserver o : observers) {
                o.update(this);
            }
        }
    }

    @Override
    public IReview createReview(Integer customerID, Integer rating, String body, Date date, Boolean verified) {
        return reviewFactory.createReview( ID, customerID, rating, date, body, verified);
    }

    @Override
    public IReview getReview(Integer customerID) {
        if (customerID == null) {
            throw new NullPointerException();
        } else {
            Boolean valid = idValidator(customerID);

            if (valid) {
                for (IReview r : reviews) {
                    if (r.getCustomerID().equals(customerID)) {
                        return r;
                    }
                }
                throw new IllegalArgumentException("No customers with that ID have "
                        + "written a review for this venue.");

            } else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }

    }

    @Override
    public List<IReview> getReviews() {
        if (reviews == null) {
            throw new NullPointerException();
        } else {
            return reviews;
        }
    }

    @Override
    public Boolean deleteReview(IReview review) {
        if (review == null) {
            throw new NullPointerException("Review to be deleted was null");
        } else if (!reviews.contains(review)) {
            throw new IllegalArgumentException("Review to be deleted wasn't in list");
        } else {
            reviews.remove(review);
            notifyObservers();
            return true;
        }
    }

    @Override
    public DatabaseTable getTable() {
        if (table == null) {
            throw new NullPointerException();
        } else {
            return table;
        }
    }

    @Override
    public List<BufferedImage> getImages() {
        return socialMedia.getImages();
    }

    @Override
    public BufferedImage getImage(int index) {
        return socialMedia.getImage(index);
    }

    @Override
    public Boolean addImage(BufferedImage img) {
        return socialMedia.addImage(img);
    }

    @Override
    public Boolean removeImage(int index) {
        return socialMedia.removeImage(index);
    }

    @Override
    public Boolean setImages(List<BufferedImage> images) {
        return socialMedia.setImages(images);
    }


    @Override
    public String getFacebook() {
        return socialMedia.getFacebook();
    }

    @Override
    public Boolean setFacebook(String fb) {
        return socialMedia.setFacebook(fb);
    }

    @Override
    public String getTwitter() {
        return socialMedia.getTwitter();
    }

    @Override
    public Boolean setTwitter(String tw) {
        return socialMedia.setTwitter(tw);
    }

    @Override
    public String getInstagram() {
        return socialMedia.getInstagram();
    }

    @Override
    public Boolean setInstagram(String insta) {
        return socialMedia.setInstagram(insta);
    }

    @Override
    public String getSoundcloud() {
        return socialMedia.getSoundcloud();
    }

    @Override
    public Boolean setSoundcloud(String sc) {
        return socialMedia.setSoundcloud(sc);
    }

    @Override
    public String getWebsite() {
        return socialMedia.getWebsite();
    }

    @Override
    public Boolean setWebsite(String web) {
        return socialMedia.setWebsite(web);
    }

    @Override
    public String getSpotify() {
        return socialMedia.getSpotify();
    }

    @Override
    public Boolean setSpotify(String sp) {
        return socialMedia.setSpotify(sp);
    }
}
