/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import database.Table;
import utilities.observer.ISubject;

/**
 *
 * @author 10512691
 */
public class ChildEvent implements ISubject {

    private final Table table = Table.CHILDEVENT;
    @Override
    public ISubject notifyObservers() {
        return this;
    }

    @Override
    public Table getTable() {
        return table;
    }
    
}
