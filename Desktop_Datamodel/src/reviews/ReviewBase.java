/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
import datamodel.ISocial;
import datamodel.SocialMedia;
import java.util.LinkedList;

/**
 *
 * @author 10512691
 */
public abstract class ReviewBase implements ISocial, IReviewable {
    
    protected IReviewFactory     reviewFactory;
    protected LinkedList<Review> reviews;
    protected SocialMedia        socialMedia;
    protected Integer            ID, socialMediaID;
    protected String             name;
    protected DatabaseTable      table;
    
    @Override
    public Review createReview(Integer customerID, Integer rating, String body) {
        return reviewFactory.createReview( ID, customerID,
            rating, body, table);
    }
    
    @Override
    public LinkedList<Review> getReviews() {
        return reviews;
    }
    
    @Override
    public DatabaseTable getTable() {
        return table;
    }
}
