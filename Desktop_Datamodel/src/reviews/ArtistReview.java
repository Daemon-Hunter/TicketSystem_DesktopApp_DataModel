/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;

import java.util.Date;

/**
 * The type Artist review represents a record in the ArtistReview table in the database.
 *
 * @author Joshua Kellaway
 * @author Charles Gillions
 */
public class ArtistReview extends Review {

    /**
     * Use this constructor when creating a review from the database.
     * Validity is known.
     *
     * @param baseID     the base id
     * @param customerID the customer id
     * @param rating     the rating
     * @param date       the date
     * @param body       the body
     * @param verified   the verified
     * @throws IllegalArgumentException the illegal argument exception
     */
    public ArtistReview(Integer baseID, Integer customerID, Integer rating, Date date, String body, Boolean verified) throws IllegalArgumentException {
        super(baseID, customerID, rating, date, body, verified);
        table = DatabaseTable.ARTIST_REVIEW;
    }
}