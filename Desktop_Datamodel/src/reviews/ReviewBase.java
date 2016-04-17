/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
import datamodel.ISocial;
import datamodel.SocialMedia;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import static utilities.Validator.idValidator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public abstract class ReviewBase implements ISocial, IReviewable {
    
    // A person using the datamodel will be accessing the wrapper objects
    protected IReviewFactory      reviewFactory;
    private LinkedList<IReview>   reviews;
    private LinkedList<IObserver> observers;
    private SocialMedia           socialMedia;
    protected String                description;
    private DatabaseTable         table;
    protected int ID;
    protected String name;
    
    public ReviewBase() {
    }
    
    public ReviewBase(int ID, String name, String description, SocialMedia social, LinkedList<IReview> reviews){
        this.ID =ID;
        this.name = name;
        this.description = description;
        this.reviews = reviews;
        this.socialMedia = social;
    }
    
    public void setTable(DatabaseTable table) {
        this.table = table;
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

    @Override
    public BufferedImage getImage() {
        return socialMedia.getImage();
    }

    @Override
    public Boolean setImage(BufferedImage img) {
        return socialMedia.setImage(img);
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
    public IReview createReview(Integer customerID, Integer rating, String body) {
        return reviewFactory.createReview( ID, customerID, rating, body);
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


