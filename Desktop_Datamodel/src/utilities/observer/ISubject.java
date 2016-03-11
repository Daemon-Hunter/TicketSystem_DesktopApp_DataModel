/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.observer;

import database.Table;

/**
 *
 * @author 10512691
 */
public interface ISubject {
    ISubject notifyObservers();
    Table getTable();
}
