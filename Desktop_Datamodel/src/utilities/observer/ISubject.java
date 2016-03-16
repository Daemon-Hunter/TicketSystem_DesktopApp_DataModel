/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.observer;

/**
 *
 * @author 10512691
 */
public interface ISubject {
    
    /**
     * Notify the observers of a change in this object.
     * Returns 'this' object in order to push changes to the database.
     * @return This object.
    **/
    ISubject notifyObservers();
    
    Boolean registerObserver(IObserver o);
    
    Boolean removeObserver(IObserver o);
}
