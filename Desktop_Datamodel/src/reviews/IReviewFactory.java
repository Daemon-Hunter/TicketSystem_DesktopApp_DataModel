/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import java.util.Date;

/**
 * The interface Review factory is implemented by a factory of a review type.
 *
 * @author Joshua Kellaway
 * @author Charles Gillions
 */
public interface IReviewFactory {

    /**
     * Create review review.
     *
     * @param reviewBaseID the review base id
     * @param customerID   the customer id
     * @param rating       the rating
     * @param date         the date
     * @param body         the body
     * @param verified     the verified
     * @return the review
     */
    IReview createReview(Integer reviewBaseID, Integer customerID, Integer rating, Date date, String body, Boolean verified);
}