/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import database.APIHandle;
import database.DatabaseTable;
import java.awt.image.BufferedImage;
import reviews.IReview;
import reviews.IReviewFactory;
import reviews.VenueReviewFactory;
import utilities.observer.IObserver;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static utilities.Validator.addressValidator;
import static utilities.Validator.capacityValidator;
import static utilities.Validator.descriptionValidator;
import static utilities.Validator.emailValidator;
import static utilities.Validator.facilitiesValidator;
import static utilities.Validator.idValidator;
import static utilities.Validator.nameValidator;
import static utilities.Validator.parkingSpaceValidator;
import static utilities.Validator.phoneNumberValidator;
import static utilities.Validator.postcodeValidator;

/**
 *
 * @author 10512691
 */
public class Venue implements IVenue {

    private IReviewFactory reviewFactory;
    private List<IReview> reviews;
    private List<IChildEvent> childEvents;
    private List<IObserver> observers;
    private Integer socialMediaID;
    private SocialMedia socialMedia;
    private String description;
    private DatabaseTable table;
    private int ID;
    private String name;
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
     * @param reviewsList
     */
    public Venue(SocialMedia social, String description, Integer capSeating, Integer capStanding, Boolean access, 
            String facilities, Integer parking, String phoneNo, String email, String address, String postcode,
            String name, List<IReview> reviewsList)
    {
        this.name = name;
        this.description = description;
        this.socialMedia = social;
        this.reviews = reviewsList;
        this.table = DatabaseTable.VENUE;
        
        // Initialize all other variables with method arguments
        this.capacitySeating  = capSeating;
        this.capacityStanding = capStanding;
        this.disabledAccess   = access;
        this.facilities  = facilities;
        this.parkingSpaces    = parking;
        this.phoneNumber      = phoneNo;
        this.email       = email;
        this.address     = address;
        this.postcode    = postcode;
        this.reviewFactory    = new VenueReviewFactory();
    }
    
    /**
     * For use when creating venues that already exist in the database.
     * ID is given and assigned.
     * @param id
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
     */
    public Venue(Integer id, Integer socialMediaID, String description, Integer capSeating, Integer capStanding,
            Boolean access, String facilities, Integer parking, String phoneNo, String email, String address, 
            String postcode, String name)
    {
        this.ID = id;
        this.name = name;
        this.description = description;
        this.socialMedia = new SocialMedia();
        this.reviews = new LinkedList<>();
        this.table = DatabaseTable.VENUE;
        
        // Initialize all other variables with method arguments
        capacitySeating  = capSeating;
        capacityStanding = capStanding;
        disabledAccess   = access;
        this.facilities  = facilities;
        parkingSpaces    = parking;
        phoneNumber      = phoneNo;
        this.email       = email;
        this.address     = address;
        this.postcode    = postcode;
        reviewFactory    = new VenueReviewFactory();
        this.socialMediaID = socialMediaID;
    }

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
    public List<IChildEvent> getChildEvents() throws IOException {
        this.childEvents = (List<IChildEvent>)(Object)APIHandle.getObjectsFromObject(this.ID, DatabaseTable.CHILD_EVENT, DatabaseTable.VENUE);
        return this.childEvents;
    }

    @Override
    public void setSocialMedia(SocialMedia socialMedia) {
        this.socialMedia = socialMedia;
    }

    @Override
    public Boolean setName(String name) {
        if (name == null) {
            throw new NullPointerException("Cannot set name null");
        } else {
            Boolean valid = nameValidator(name);
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
            Boolean valid = descriptionValidator(description);
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
            Boolean valid = capacityValidator(standing);
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
            Boolean valid = capacityValidator(seating);
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
            Boolean valid = facilitiesValidator(facilities);
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
            Boolean valid = parkingSpaceValidator(parking);
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
            Boolean valid = emailValidator(email);
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
            Boolean valid = phoneNumberValidator(phoneNumber);
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
            Boolean valid = addressValidator(address);
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
            Boolean valid = postcodeValidator(postcode);
            if (valid) {
                this.postcode = postcode;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Integer getSocialId() {
        return socialMediaID;
    }

    /**
     * Checks the validity of the ID before assigning.
     * @param id
     * @return Boolean true if ID set.
     */

    @Override
    public Boolean setSocialId(Integer id) {
        socialMediaID = id;
        return socialMedia.setSocialId(id);
    }



    protected IReviewFactory getReviewFactory() {
        return reviewFactory;
    }

    /**
     * Adds IObserver object to list of objects to notify when a change is made.
     * Checks if the object is null or already exists in the list.
     * @param o
     * @return
     */
    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer");
        } else if (observers.contains(o)) {
            throw new IllegalArgumentException("Observer already exists");
        } else {
            observers.add(o);
            return true;
        }
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Null observer");
        } else if (!observers.contains(o)) {
            throw new IllegalArgumentException("Observer doesn't exist in observers list");
        } else {
            observers.remove(o);
            return true;
        }
    }

    @Override
    public void notifyObservers() {
        if (observers == null) {
            observers = new LinkedList();
        } else {
            for (IObserver o : observers) {
                o.update(this);
            }
        }
    }

    @Override
    public IReview createReview(Integer customerID, Integer rating, String body, Date date, Boolean verified) {
        return reviewFactory.createReview( ID, customerID, rating, date, body, verified);
    }

    @Override
    public IReview getReview(Integer customerID) {
        if (customerID == null) {
            throw new NullPointerException();
        } else {
            Boolean valid = idValidator(customerID);

            if (valid) {
                for (IReview r : reviews) {
                    if (r.getCustomerID().equals(customerID)) {
                        return r;
                    }
                }
                throw new IllegalArgumentException("No customers with that ID have "
                        + "written a review for this venue.");

            } else {
                throw new IllegalArgumentException("Invalid ID");
            }
        }

    }

    @Override
    public List<IReview> getReviews() {
        if (reviews == null) {
            throw new NullPointerException();
        } else {
            return reviews;
        }
    }

    @Override
    public Boolean deleteReview(IReview review) {
        if (review == null) {
            throw new NullPointerException("Review to be deleted was null");
        } else if (!reviews.contains(review)) {
            throw new IllegalArgumentException("Review to be deleted wasn't in list");
        } else {
            reviews.remove(review);
            notifyObservers();
            return true;
        }
    }

    @Override
    public DatabaseTable getTable() {
        if (table == null) {
            throw new NullPointerException();
        } else {
            return table;
        }
    }

    @Override
    public List<BufferedImage> getImages() {
        return socialMedia.getImages();
    }

    @Override
    public BufferedImage getImage(int index) {
        return socialMedia.getImage(index);
    }

    @Override
    public Boolean addImage(BufferedImage img) {
        return socialMedia.addImage(img);
    }

    @Override
    public Boolean removeImage(int index) {
        return socialMedia.removeImage(index);
    }

    @Override
    public Boolean setImages(List<BufferedImage> images) {
        return socialMedia.setImages(images);
    }


    @Override
    public String getFacebook() {
        return socialMedia.getFacebook();
    }

    @Override
    public Boolean setFacebook(String fb) {
        return socialMedia.setFacebook(fb);
    }

    @Override
    public String getTwitter() {
        return socialMedia.getTwitter();
    }

    @Override
    public Boolean setTwitter(String tw) {
        return socialMedia.setTwitter(tw);
    }

    @Override
    public String getInstagram() {
        return socialMedia.getInstagram();
    }

    @Override
    public Boolean setInstagram(String insta) {
        return socialMedia.setInstagram(insta);
    }

    @Override
    public String getSoundcloud() {
        return socialMedia.getSoundcloud();
    }

    @Override
    public Boolean setSoundcloud(String sc) {
        return socialMedia.setSoundcloud(sc);
    }

    @Override
    public String getWebsite() {
        return socialMedia.getWebsite();
    }

    @Override
    public Boolean setWebsite(String web) {
        return socialMedia.setWebsite(web);
    }

    @Override
    public String getSpotify() {
        return socialMedia.getSpotify();
    }

    @Override
    public Boolean setSpotify(String sp) {
        return socialMedia.setSpotify(sp);
    }
}
