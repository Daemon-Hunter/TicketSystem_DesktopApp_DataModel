/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
import java.util.Date;

/**
 *
 * @author 10512691
 */
public class ParentEventReview extends Review {
    
    /**
     * Use this constructor when creating a review from the database.
     * ID known.
     * @param baseID
     * @param customerID
     * @param rating
     * @param date
     * @param body
     * @param verified 
     */
    public ParentEventReview(Integer baseID, Integer customerID, Integer rating, 
            Date date, String body, Boolean verified) 
    {
        super(baseID, customerID, rating, date, body, verified);
        table = DatabaseTable.EVENT_REVIEW;
    }    
    
    /**
     * Use this constructor when creating a new review object.
     * ID unknown.
     * @param baseID
     * @param customerID
     * @param rating
     * @param body
     */
    public ParentEventReview(Integer baseID, Integer customerID, Integer rating, String body) 
    {
        super(baseID, customerID, rating, body);
        table = DatabaseTable.EVENT_REVIEW;
    }  
}