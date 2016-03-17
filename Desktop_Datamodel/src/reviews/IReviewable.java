/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import java.util.LinkedList;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface IReviewable extends IDbSubject {
    
    LinkedList<Review> getReviews();
    Review getReview(Integer custId);
    Review createReview(Integer customerID, Integer rating, String body);
    Boolean deleteReview(Review review);
    IReviewFactory getReviewFactory();
}
