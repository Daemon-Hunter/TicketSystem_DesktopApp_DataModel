/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.util.LinkedList;
import java.util.List;
import reviews.ArtistReviewFactory;
import reviews.IReview;
import reviews.ReviewBase;
import utilities.Validator;

/**
 *
 * @author 10512691
 */
public class Artist extends ReviewBase implements IArtist {
    
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
        super();
        // Initialize table variable - matches Java object to database table
        setTable(DatabaseTable.ARTIST);
        tags = new LinkedList<>();
        reviewFactory = new ArtistReviewFactory();
    }

    public Artist(Integer ID, String name, String description, LinkedList<String> tags, SocialMedia social,
            LinkedList<IReview> reviews) {
        super(ID, name, description, social, reviews);
        // Initialize table variable - matches Java object to database table
        setTable(DatabaseTable.ARTIST);
        
        // Initialise default values for rest of attributes
        this.tags = tags;
        reviewFactory = new ArtistReviewFactory();
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
}
