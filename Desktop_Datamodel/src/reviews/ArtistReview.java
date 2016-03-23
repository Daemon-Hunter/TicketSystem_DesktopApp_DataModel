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
public class ArtistReview extends Review {
    
    /**
     * Use this constructor when creating a review from the database.
     * ID known.
     * @param baseID
     * @param user
     * @param rating
     * @param date
     * @param body
     * @param verified 
     */
    public ArtistReview(Integer baseID, User user, Integer rating, Date date, String body,
            Boolean verified) 
    {
        super(baseID, user, rating, date, body, verified);
        table = DatabaseTable.ARTISTREVIEW;
    }
    
    /**
     * Use this constructor when creating a new review object.
     * ID unknown.
     * @param user
     * @param rating
     * @param date
     * @param body
     * @param verified 
     */
    public ArtistReview(User user, Integer rating, Date date, String body,
            Boolean verified) 
    {
        super(user, rating, date, body, verified);
        table = DatabaseTable.ARTISTREVIEW;
    }
}