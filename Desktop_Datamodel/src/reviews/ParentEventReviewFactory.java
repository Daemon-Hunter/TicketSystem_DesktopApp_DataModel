/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

/**
 *
 * @author 10512691
 */
public class ParentEventReviewFactory implements IReviewFactory {

    @Override
    public IReview createReview(Integer reviewBaseID, Integer customerID, 
            Integer rating, String body) 
    {
        return new ParentEventReview(reviewBaseID, customerID, rating, body);
    }

}