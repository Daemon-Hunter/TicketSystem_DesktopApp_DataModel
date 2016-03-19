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
public interface IHaveReviews extends IDbSubject {
    
    public LinkedList<Review> getReviews();
    public Review getReview(Integer custId);
    public Boolean deleteReview(Review review);
}