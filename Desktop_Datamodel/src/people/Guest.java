/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import database.DatabaseTable;
import utilities.Validator;

/**
 *
 * @author 10512691
 */
public class Guest extends User {

    DatabaseTable table = DatabaseTable.GUESTBOOKING;
    
    public Guest(String fName, String lName, String email_, String address_, String pcode) {
        ID        = 0;
        firstName = "GUEST";
        lastName  = "ACCOUNT";
        email     = email_;
        address   = address_;
        postcode  = pcode;
    }
    
    @Override
    public String getEmail() {
        if (email == null) {
            throw new NullPointerException("Null email");
        } else {
            return email;
        }
    }

    @Override
    public Boolean setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Null email");
        } else {
            Boolean valid = Validator.emailValidator(email);
            if (valid) {
                this.email = email;
                notifyObservers();
            }
            return valid;
        }
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
        return (this.address.equals(address));
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public Boolean setPostcode(String postcode) {
        this.postcode = postcode;
        notifyObservers();
        return (this.postcode.equals(postcode));
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public Boolean setFirstName(String name) {
        return false;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public Boolean setLastName(String name) {
        return false;
    }
}
