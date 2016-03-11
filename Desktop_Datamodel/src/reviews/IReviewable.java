/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import java.util.LinkedList;

/**
 *
 * @author 10512691
 */
public interface IReviewable {
    LinkedList<Review> getReviews();
    Review getReview(Integer custId);
}
