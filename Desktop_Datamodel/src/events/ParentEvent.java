/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import database.DatabaseTable;
import reviews.IReview;
import reviews.IReviewFactory;
import reviews.ParentEventReviewFactory;
import utilities.observer.IObserver;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static database.APIHandle.getObjectsFromObject;
import java.awt.image.BufferedImage;
import static utilities.Validator.idValidator;

/**
 *
 * @author 10512691
 */
public class ParentEvent implements IParentEvent {

    private IReviewFactory reviewFactory;
    private List<IReview> reviews;
    private List<IObserver> observers;
    private SocialMedia socialMedia;
    private Integer socialMediaID;
    private String description;
    private DatabaseTable table;
    private int ID;
    private String name;
    
    private List<IChildEvent> childEvents;
    
    /**
     * Empty constructor initializes it's review factory and child event list.
     */
    public ParentEvent() {
        super();
        // Initialize table variable, which matches Java object to database table
        table = DatabaseTable.PARENT_EVENT;
        reviewFactory = new ParentEventReviewFactory();
    }
    
    public ParentEvent(Integer ID, Integer social, String name, String description)
    {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.table = DatabaseTable.PARENT_EVENT;
        this.reviewFactory = new ParentEventReviewFactory();
        this.socialMediaID = social;

    }

    @Override
    public List<IChildEvent> getChildEvents() throws IOException {
        if (childEvents == null) {
            childEvents = (List<IChildEvent>) (Object)getObjectsFromObject(this.ID, DatabaseTable.CHILD_EVENT, DatabaseTable.PARENT_EVENT);
        }
        return childEvents;
    }

    @Override
    public Boolean addChildEvent(IChildEvent childEvent) {
        if (childEvent == null) {
            throw new NullPointerException("Null child event");
        }
        return childEvents.add(childEvent);
    }

    @Override
    public IChildEvent getChildEvent(Integer childEventID) throws IOException {
        if (childEventID == null) {
            throw new NullPointerException("Null child event ID");
        } else {
            if (childEvents == null) {
                childEvents = getChildEvents();
            }
            for (IChildEvent childEvent : childEvents) {
                if (childEvent.getID().equals(childEventID))
                    return childEvent;
            }
            throw new NullPointerException("No child event with this ID");
        }
    }

    @Override
    public Boolean removeChildEvent(IChildEvent childEvent) {
        if (childEvent == null) {
            throw new NullPointerException("Null child event");
        } else {
            childEvents.remove(childEvent);
            return true;
        }
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        if (description == null) {
            throw new NullPointerException("Parent Event description is null");
        } else {
            return description;
        }
    }

    @Override
    public Boolean setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Name cannot be null.");
        } else {
            this.name = name;
            return true;
        }
    }

    @Override
    public Boolean setDescription(String description) {
        if (description == null){
            throw new IllegalArgumentException("Description cannot be null");
        } else {
            this.description = description;
            return true;

        }
    }

    @Override
    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMediaID = socialMedia.getSocialId();
        this.socialMedia = socialMedia;
    }

    @Override
    public SocialMedia getSocialMedia() {
        return this.socialMedia;
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
    public Boolean setSocialId(Integer id) throws IOException {
        this.socialMediaID = id;
        return socialMedia.setSocialId(id);
    }



    protected IReviewFactory getReviewFactory() {
        return reviewFactory;
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
    public Boolean deleteReview(IReview review) throws IOException {
        if (review == null) {
            throw new NullPointerException("Review to be deleted was null");
        } else if (!reviews.contains(review)) {
            throw new IllegalArgumentException("Review to be deleted wasn't in list");
        } else {
            reviews.remove(review);
            return true;
        }
    }

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
