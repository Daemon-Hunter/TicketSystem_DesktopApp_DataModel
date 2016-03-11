/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import desktop_datamodel.ISocial;
import utilities.observer.ISubject;
import java.util.LinkedList;

/**
 *
 * @author 10512691
 */
public abstract class ReviewBase implements ISubject, ISocial {
    
    ReviewFactory reviewFactory;
    LinkedList<Review> reviews;
    
    public LinkedList<Review> getReviews() {
        return reviews;
    }
    
    public ReviewFactory getReviewFactory() {
        return reviewFactory;
    }
}
