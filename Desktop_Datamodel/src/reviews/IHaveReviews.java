/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import java.io.IOException;
import java.util.List;

/**
 * The interface Have reviews is implemented by a class which represents a entity with reviews.
 *
 * @author Joshua Kellaway
 * @author Charles Gillions1
 */
public interface IHaveReviews {

    /**
     * Gets reviews.
     *
     * @return the reviews
     */
    List<IReview> getReviews();

    /**
     * Gets review.
     *
     * @param uniqueID the unique id
     * @return the review
     */
    IReview getReview(Integer uniqueID);

    /**
     * Delete review boolean.
     *
     * @param review the review
     * @return the boolean
     * @throws IOException the io exception
     */
    Boolean deleteReview(IReview review) throws IOException;
}
