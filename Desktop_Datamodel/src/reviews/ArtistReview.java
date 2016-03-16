/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import utilities.observer.ISubject;
import database.DatabaseTable;
import utilities.observer.IObserver;

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

    @Override
    public Boolean registerObserver(IObserver o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}