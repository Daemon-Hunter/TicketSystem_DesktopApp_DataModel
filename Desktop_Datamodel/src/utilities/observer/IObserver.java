/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.observer;

import database.DatabaseTable;

import java.io.IOException;

/**
 *
 * @author 10512691
 */
public interface IObserver {
    
    void update(ISubject object, DatabaseTable table) throws IOException;
}
