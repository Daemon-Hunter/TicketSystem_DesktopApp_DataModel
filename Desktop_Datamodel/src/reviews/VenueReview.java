/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;

import java.util.Date;

/**
 * The type Venue review represents a record in the VenueReview table in the database.
 *
 * @author Joshua Kellaway
 * @author Charles Gillions
 */
public class VenueReview extends Review {

    private Integer baseID;

    /**
     * Use this constructor when creating a review from the database.
     * ID known.
     *
     * @param baseID     the base id
     * @param customerID the customer id
     * @param rating     the rating
     * @param date       the date
     * @param body       the body
     * @param verified   the verified
     * @throws IllegalArgumentException the illegal argument exception
     */
    public VenueReview(Integer baseID, Integer customerID, Integer rating, Date date, String body, Boolean verified) throws IllegalArgumentException {
        super(baseID, customerID, rating, date, body, verified);
        table = DatabaseTable.VENUE_REVIEW;
    }
}