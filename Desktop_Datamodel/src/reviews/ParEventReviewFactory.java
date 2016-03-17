/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;

/**
 *
 * @author 10512691
 */
public class ParEventReviewFactory implements IReviewFactory {

    @Override
    public Review createReview(Integer ID, Integer customerID, Integer rating, String body, DatabaseTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
