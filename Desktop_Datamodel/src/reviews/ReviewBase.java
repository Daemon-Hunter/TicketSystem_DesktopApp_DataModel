/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import datamodel.ISocial;
import utilities.observer.ISubject;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author 10512691
 */
public abstract class ReviewBase implements ISocial, IReviewable {
    
    protected ReviewFactory      reviewFactory;
    protected LinkedList<Review> reviews;
    protected Stack<String>      updatedColumns;
    
    @Override
    public Review createReview() {
        return reviewFactory.createReview();
    }
    
    @Override
    public LinkedList<Review> getReviews() {
        return reviews;
    }
}
