/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
import datamodel.ISocial;
import datamodel.SocialMedia;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public abstract class ReviewBase implements ISocial, IReviewable {
    
    protected IReviewFactory        reviewFactory;
    protected LinkedList<IReview>   reviews;
    protected LinkedList<IObserver> observers;
    protected SocialMedia           socialMedia;
    protected Integer               ID;
    protected String                name, description;
    protected DatabaseTable         table;
    protected Validator             validator;
    
    public ReviewBase() {
        reviews = new LinkedList<>();
        observers = new LinkedList<>();
        socialMedia = new SocialMedia(0, null, null, null, null, null, null, null);
        ID = 0;
        name = "UNKNOWN";
    }
    
    @Override
    public Integer getSocialId() {
        return socialMedia.getSocialId();
    }
    
    /**
     * Checks the validity of the ID before assigning.
     * @param id
     * @return Boolean true if ID set.
     */
    @Override
    public Boolean setSocialId(Integer id) {
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
        observers.stream()
                 .forEach((o) -> {
                           o.update(this);
                 });
    }
    
    @Override
    public IReview createReview(Integer customerID, Integer rating, String body) {
        return reviewFactory.createReview( ID, table, customerID, rating, body);
    }
    
    @Override
    public IReview getReview(Integer customerID) {
        if (customerID == null) {
            throw new NullPointerException();
        } else {
            Boolean valid = Validator.idValidator(customerID);
            
            if (valid) {
                Optional<IReview> value = reviews.stream()
                                                .findAny()
                                                .filter(r -> r.getCustomerID()
                                                .equals(customerID));
                if (value.isPresent()) {
                    return value.get();
                } else {
                    throw new IllegalArgumentException("No customers with that ID have "
                        + "written a review for this venue.");
                }
                
//              ***** JAVA 7 VERSION (NON-LAMBDA) *****
//                for (Review r : reviews) {
//                    if (r.getCustomerID().equals(customerID)) {
//                        return r;
//                    }
//                }
//                throw new IllegalArgumentException("No customers with that ID have "
//                     + "written a review for this venue.");

            } else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }
        
    }
    
    @Override
    public LinkedList<IReview> getReviews() {
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
    public URL getImage() {
        return socialMedia.getImage();
    }

    @Override
    public Boolean setImage(URL img) {
        return socialMedia.setImage(img);
    }

    @Override
    public URL getFacebook() {
        return socialMedia.getFacebook();
    }

    @Override
    public Boolean setFacebook(URL fb) {
        return socialMedia.setFacebook(fb);
    }

    @Override
    public URL getTwitter() {
        return socialMedia.getTwitter();
    }

    @Override
    public Boolean setTwitter(URL tw) {
        return socialMedia.setTwitter(tw);
    }

    @Override
    public URL getInstagram() {
        return socialMedia.getInstagram();
    }

    @Override
    public Boolean setInstagram(URL insta) {
        return socialMedia.setInstagram(insta);
    }

    @Override
    public URL getSoundcloud() {
        return socialMedia.getSoundcloud();
    }

    @Override
    public Boolean setSoundcloud(URL sc) {
        return socialMedia.setSoundcloud(sc);
    }

    @Override
    public URL getWebsite() {
        return socialMedia.getWebsite();
    }

    @Override
    public Boolean setWebsite(URL web) {
        return socialMedia.setWebsite(web);
    }

    @Override
    public URL getSpotify() {
        return socialMedia.getSpotify();
    }

    @Override
    public Boolean setSpotify(URL sp) {
        return socialMedia.setSpotify(sp);
    }
}
