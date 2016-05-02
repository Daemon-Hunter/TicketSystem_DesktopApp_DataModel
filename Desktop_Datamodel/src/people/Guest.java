/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import bookings.IBooking;
import database.DatabaseTable;
import utilities.Validator;

import java.io.IOException;

import static utilities.HashString.Encrypt;

/**
 *
 * @author 10512691
 */
public class Guest implements IGuest {

    private String email, address, postcode, password;
    private DatabaseTable table;
    private Integer ID;
    private IBooking booking;

    /**
     * Use this constructor when creating a new Guest object.
     * ID is unknown.
     * @param email
     * @param address
     * @param postcode
     */
    public Guest(String email, String address, String postcode)
    {
        this.ID = -1;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        table = DatabaseTable.GUEST_BOOKING;
    }
    
    /**
     * Use this constructor when creating an object from the database.
     * ID is known.
     * @param ID
     * @param email
     * @param address
     * @param postcode
     */
    public Guest(Integer ID, String email, String address, String postcode)
    {
        // Check email. Email can be null.
        if (email != null) {
            if (Validator.emailValidator(email)) {
                this.email = email;
            } else {
                throw new IllegalArgumentException("Invalid email address");
            }
        } else {
            this.email = null;
        }

        // Check address. Users don't have to have an address, so it can be set to null
        if (address != null) {
            if (Validator.addressValidator(address)) {
                this.address = address;
            } else {
                throw new IllegalArgumentException("Invalid address.");
            }
        } else {
            this.address = null;
        }

        // Check the users postcode. Users don't have to have a postcode - so can be null
        if (postcode != null) {
            if (Validator.postcodeValidator(postcode)) {
                this.postcode = postcode;
            } else {
                throw new IllegalArgumentException("Invalid postcode");
            }
        } else {
            this.postcode = null;
        }

        this.password = Encrypt(password);
        table = DatabaseTable.GUEST_BOOKING;
    }

    @Override
    public Boolean setFirstName(String name) {
        return false;
    }

    @Override
    public Boolean setLastName(String name) {
        return false;
    }

    @Override
    public Boolean setPassword(String password) {
        return false;
    }

    @Override
    public IBooking getBooking() {
        return this.booking;
    }

    @Override
    public boolean setBooking(IBooking booking) {
        if (booking == null){
            throw new IllegalArgumentException("Booking cannot be null");
        } else {
            this.booking = booking;
            return this.booking == booking;
        }
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
    public Boolean setEmail(String email) throws IOException {
        if (email == null) {
            throw new NullPointerException("Cannot set email to null");
        } else {
            Boolean valid = Validator.emailValidator(email);
            if (valid) {
                this.email = email;
            }
            return valid;
        }
    }

    @Override
    public Integer getID() {
        if (ID == null) {
            throw new NullPointerException("ID is null");
        } else {
            return this.ID;
        }
    }

    @Override
    public String getFirstName() {

            return "GUEST";
    }

    @Override
    public String getLastName() {
        return "ACCOUNT";
    }

    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public String getAddress() {
        if (address == null) {
            throw new NullPointerException("Null address");
        } else {
            return address;
        }
    }

    @Override
    public Boolean setAddress(String address) throws IOException {
        if (address == null) {
            throw new NullPointerException("Cannot set address to null");
        } else {
            Boolean valid = Validator.addressValidator(address);
            if (valid) {
                this.address = address;
            }
            return valid;
        }
    }

    @Override
    public String getPostcode() {
        if (postcode == null) {
            throw new NullPointerException("Null postcode");
        } else {
            return postcode;
        }
    }

    @Override
    public Boolean setPostcode(String postcode) throws IOException {
        if (postcode == null) {
            throw new NullPointerException("Cannot set postcode to null");
        } else {
            Boolean valid = Validator.postcodeValidator(postcode);
            if (valid) {
                this.postcode = postcode;
            }
            return valid;
        }
    }

    @Override
    public String getPassword(){
        return password;
    }
}