/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
import java.util.Date;
import people.User;

/**
 *
 * @author 10512691
 */
public class VenueReview extends Review {

    private Integer baseID;
    
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
    public VenueReview(Integer baseID, Integer customerID, Integer rating, 
            Date date, String body, Boolean verified) 
    {
        super(baseID, customerID, rating, date, body, verified);
        table = DatabaseTable.VENUEREVIEW;
    }    
    
    /**
     * Use this constructor when creating a new review object.
     * ID unknown.
     * @param baseID
     * @param customerID
     * @param rating
     * @param date
     * @param body
     */
    public VenueReview(Integer baseID, Integer customerID, Integer rating,
            Date date, String body) 
    {
        super(baseID, customerID, rating, date, body);
        table = DatabaseTable.VENUEREVIEW;
        this.baseID = baseID;
    }
}