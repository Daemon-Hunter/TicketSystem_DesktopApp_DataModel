/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.observer;

import database.DatabaseTable;

/**
 *
 * @author 10512691
 */
public interface IDbSubject extends ISubject {
    
    /**
     * Get the database table which this object maps.
     * @return Table enumeration.
     */
    DatabaseTable getTable();
}
