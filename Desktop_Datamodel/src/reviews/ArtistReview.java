/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import utilities.observer.ISubject;
import database.DatabaseTable;

/**
 *
 * @author 10512691
 */
public class ArtistReview extends Review {
    
    DatabaseTable table = DatabaseTable.ARTISTREVIEW;

    @Override
    public ISubject notifyObservers() {
        return this;
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }
    
}