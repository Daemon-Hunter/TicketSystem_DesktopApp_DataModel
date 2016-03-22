/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import reviews.ArtistReviewFactory;
import reviews.IReview;
import reviews.ReviewBase;
import reviews.IReviewFactory;
import utilities.Validator;

/**
 *
 * @author 10512691
 */
public class Artist extends ReviewBase implements IArtist {
    
    private LinkedList<String> tags;
    
    public Artist() {
        super();
        // Initialize table variable - matches Java object to database table
        table = DatabaseTable.ARTIST;
        tags = new LinkedList<>();
        reviewFactory = new ArtistReviewFactory();
    }

    public Artist(Integer ID, String name, LinkedList<String> tags, SocialMedia social,
            LinkedList<IReview> reviews) {
        // Initialize table variable - matches Java object to database table
        table = DatabaseTable.ARTIST;
        
        // Initialise default values for rest of attributes
        this.tags = tags;
        this.ID = ID;
        socialMedia = social;
        this.reviews = reviews;
        this.name = name;
        reviewFactory = new ArtistReviewFactory();
        observers = new LinkedList<>();
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public IReviewFactory getReviewFactory() {
        return reviewFactory;
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
        
        Optional<String> value = tags.stream()
                                     .findAny()
                                     .filter(t -> t.equals(tag));
        if (value.isPresent()) {
            tags.remove(value.get());
            return true;
        } else {
            return false;
        }
    }
}
