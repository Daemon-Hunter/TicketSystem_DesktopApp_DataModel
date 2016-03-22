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

    DatabaseTable table = DatabaseTable.GUESTBOOKING;
    
    public Guest(String fName, String lName, String email_, String address_, String pcode) {
        super(fName, lName, email_, address_, pcode);
    }
    
    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Boolean setEmail(String email) {
        this.email = email;
        notifyObservers();
        return (this.email == email);
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public Boolean setAddress(String address) {
        this.address = address;
        notifyObservers();
        return (this.address == address);
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public Boolean setPostcode(String postcode) {
        this.postcode = postcode;
        notifyObservers();
        return (this.postcode == postcode);
    }

    @Override
    public String getFirstName() {
        return "Guest";
    }

    @Override
    public Boolean setFirstName(String name) {
        return false;
    }

    @Override
    public String getLastName() {
        return "Account";
    }

    @Override
    public Boolean setLastName(String name) {
        return false;
    }
}
