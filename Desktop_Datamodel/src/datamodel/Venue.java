/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.util.LinkedList;
import reviews.IReview;
import reviews.ReviewBase;
import reviews.VenueReviewFactory;
import utilities.Validator;

/**
 *
 * @author 10512691
 */
public class Venue extends ReviewBase implements IVenue {

    /*
        Inherits:
        IReviewFactory        reviewFactory;
        LinkedList<Review>    reviews;
        LinkedList<IObserver> observers;
        SocialMedia           socialMedia;
        Integer               ID, socialMediaID;
        String                name;
        DatabaseTable         table;
     */
    
    private String  phoneNumber,
                    email,
                    address,
                    postcode;
    private Integer capacitySeating,
                    capacityStanding,
                    parkingSpaces;
    private Boolean disabledAccess;
    private String  facilities;
    
    public Venue() {
        super();
        // Initialize table variable -> matches Java object to database table
        table            = DatabaseTable.VENUE;
        
        // Initialize all other variables to default values
        this.description = "Default Venue";
        capacitySeating  = null;
        capacityStanding = null;
        disabledAccess   = null;
        this.facilities  = "None";
        parkingSpaces    = null;
        phoneNumber      = null;
        this.email       = null;
        this.address     = null;
        this.postcode    = null;
        reviewFactory    = new VenueReviewFactory();
    }
    
    /**
     * For use when creating new Venues on the Administrators application.
     * No ID is given, it will be assigned from a returning call to the API.
     * in the setID() method.
     * @param social
     * @param description
     * @param capSeating
     * @param capStanding
     * @param access
     * @param facilities
     * @param parking
     * @param phoneNo
     * @param email
     * @param address
     * @param postcode
     * @param name 
     * @param reviews 
     */
    public Venue(SocialMedia social, String description, Integer capSeating, Integer capStanding, Boolean access, 
            String facilities, Integer parking, String phoneNo, String email, String address, String postcode,
            String name, LinkedList<IReview> reviews) 
    {
        // Initialize table variable -> matches Java object to database table
        table            = DatabaseTable.VENUE;
        
        // Initialize all other variables with method arguments
        ID               = 0;
        socialMedia      = social;
        this.description = description;
        capacitySeating  = capSeating;
        capacityStanding = capStanding;
        disabledAccess   = access;
        this.facilities  = facilities;
        parkingSpaces    = parking;
        phoneNumber      = phoneNo;
        this.email       = email;
        this.address     = address;
        this.postcode    = postcode;
        this.name        = name;
        this.reviews     = reviews;
        reviewFactory    = new VenueReviewFactory();
    }
    
    /**
     * For use when creating venues that already exist in the database.
     * ID is given and assigned.
     * @param id
     * @param social
     * @param description
     * @param capSeating
     * @param capStanding
     * @param access
     * @param facilities
     * @param parking
     * @param phoneNo
     * @param email
     * @param address
     * @param postcode
     * @param name 
     * @param reviews 
     */
    public Venue(Integer id, SocialMedia social, String description, Integer capSeating, Integer capStanding, 
            Boolean access, String facilities, Integer parking, String phoneNo, String email, String address, 
            String postcode, String name, LinkedList<IReview> reviews) 
    {
        if (id == null) {
            throw new NullPointerException("Wrong constructor use. Do not pass a null ID - instead, do not put one at all"
                    + "and one will be automatically assigned from the database.");
        }
        // Initialize table variable -> matches Java object to database table
        table            = DatabaseTable.VENUE;
        
        // Initialize all other variables with method arguments
        ID               = id;
        socialMedia      = social;
        this.description = description;
        capacitySeating  = capSeating;
        capacityStanding = capStanding;
        disabledAccess   = access;
        this.facilities  = facilities;
        parkingSpaces    = parking;
        phoneNumber      = phoneNo;
        this.email       = email;
        this.address     = address;
        this.postcode    = postcode;
        this.name        = name;
        this.reviews     = reviews;
        reviewFactory    = new VenueReviewFactory();
    }

    /**
     * ID = 0 if not a fully constructed database object.
     * @return 
     */
    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public String getName() {
        if (name == null) {
            throw new NullPointerException("Null venue name");
        } else {
            return name;
        }
    }

    @Override
    public String getDescription() {
        if (description == null) {
            throw new NullPointerException("Null venue description");
        } else {
            return description;
        }
    }

    @Override
    public Integer getStandingCapacity() {
        if (capacityStanding == null) {
            throw new NullPointerException("Null standing capacity");
        } else {
            return capacityStanding;
        }
    }

    @Override
    public Integer getSeatingCapacity() {
        if (capacitySeating == null) {
            throw new NullPointerException("Null seating capacity");
        } else {
            return capacitySeating;
        }
    }

    @Override
    public Boolean getDisabledAccess() {
        if (disabledAccess == null) {
            throw new NullPointerException("Null disabled access variable");
        } else {
            return disabledAccess;
        }
    }

    @Override
    public String getFacilites() {
        if (facilities == null) {
            throw new NullPointerException("Null facililites variable");
        } else {
            return facilities;
        }
    }

    @Override
    public Integer getParking() {
        if (parkingSpaces == null) {
            throw new NullPointerException("Null parking spaces variable");
        } else {
            return parkingSpaces;
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
    public String getPhoneNumber() {
        if (phoneNumber == null) {
            throw new NullPointerException("Null phone number");
        } else {
            return phoneNumber;
        }
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
    public String getPostcode() {
        if (postcode == null) {
            throw new NullPointerException("Null postcode");
        } else {
            return postcode;
        }
    }

    @Override
    public Boolean setName(String name) {
        if (name == null) {
            throw new NullPointerException("Cannot set name null");
        } else {
            Boolean valid = Validator.nameValidator(name);
            if (valid) {
                this.name = name;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setDescription(String description) {
        if (description == null) {
            throw new NullPointerException("Cannot set description null");
        } else {
            Boolean valid = Validator.descriptionValidator(description);
            if (valid) {
                this.description = description;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setStandingCapacity(Integer standing) {
        if (standing == null) {
            throw new NullPointerException("Cannot set capacity to null");
        } else {
            Boolean valid = Validator.capacityValidator(standing);
            if (valid) {
                capacityStanding = standing;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setSeatingCapacity(Integer seating) {
        if (seating == null) {
            throw new NullPointerException("Cannot set capacity to null");
        } else {
            Boolean valid = Validator.capacityValidator(seating);
            if (valid) {
                capacitySeating = seating;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setDisabledAccess(Boolean access) {
        if (access == null) {
            throw new NullPointerException("Cannot set access to null");
        } else {
            disabledAccess = access;
            notifyObservers();
            return true;
        }
    }

    @Override
    public Boolean setFacilites(String facilities) {
        if (facilities == null) {
            throw new NullPointerException("Cannot set facilities to null");
        } else {
            Boolean valid = Validator.facilitiesValidator(facilities);
            if (valid) {
                this.facilities = facilities;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setParking(Integer parking) {
        if (parking == null) {
            throw new NullPointerException("Cannot set parking spaces to null");
        } else {
            Boolean valid = Validator.parkingSpaceValidator(parking);
            if (valid) {
                parkingSpaces = parking;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Cannot set email to null");
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
    public Boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            throw new NullPointerException("Cannot set phone number to null");
        } else {
            Boolean valid = Validator.phoneNumberValidator(phoneNumber);
            if (valid) {
                this.phoneNumber = phoneNumber;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setAddress(String address) {
        if (address == null) {
            throw new NullPointerException("Cannot set address to null");
        } else {
            Boolean valid = Validator.addressValidator(address);
            if (valid) {
                this.address = address;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setPostcode(String postcode) {
        if (postcode == null) {
            throw new NullPointerException("Cannot set postcode to null");
        } else {
            Boolean valid = Validator.postcodeValidator(postcode);
            if (valid) {
                this.postcode = postcode;
                notifyObservers();
            }
            return valid;
        }
    }
}
