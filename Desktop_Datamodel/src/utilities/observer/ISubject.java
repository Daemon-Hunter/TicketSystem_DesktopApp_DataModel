/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.observer;

import java.io.IOException;

/**
 *
 * @author 10512691
 */
public interface ISubject {
    
    /**
     * Notify the observers of a change in this object.
    **/
    void notifyObservers() throws IOException;
    
    Boolean registerObserver(IObserver o);
    
    Boolean removeObserver(IObserver o);
}
