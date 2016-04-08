/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import database.DatabaseTable;

/**
 *
 * @author 10512691
 */
public class Guest extends User {
    
    /**
     * Use this constructor when creating a new Guest object.
     * ID is unknown.
     * @param fName
     * @param lName
     * @param email
     * @param address
     * @param pcode 
     */
    public Guest(String fName, String lName, String email, String address, String pcode) 
    {
        super("GUEST", "ACCOUNT", email, address, pcode);
        table = DatabaseTable.GUESTBOOKING;
    }
    
    /**
     * Use this constructor when creating an object from the database.
     * ID is known.
     * @param ID
     * @param fName
     * @param lName
     * @param email
     * @param address
     * @param pcode 
     */
    public Guest(Integer ID, String fName, String lName, String email, String address, String pcode) 
    {
        super(ID, "GUEST", "ACCOUNT", email, address, pcode);
        table = DatabaseTable.GUESTBOOKING;
    }

    @Override
    public Boolean setFirstName(String name) {
        return false;
    }

    @Override
    public Boolean setLastName(String name) {
        return false;
    }
}