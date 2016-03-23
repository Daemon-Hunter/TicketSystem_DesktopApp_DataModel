/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import people.User;
import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public abstract class Review implements IReview {
    protected Integer       reviewBaseID;
    protected Integer       customerID;
    protected Date          dateTime;
    protected Integer       rating;
    protected String        reviewBody;
    protected Boolean       verified;
    protected DatabaseTable table;
    protected LinkedList<IObserver> observers;
    
    /**
     * Use this constructor when creating a review object from the database.
     * Validity is is known.
     * @param baseID
     * @param customerID
     * @param rating
     * @param date
     * @param body
     * @param verified 
     */
    public Review(Integer baseID, Integer customerID, Integer rating, 
                    Date date, String body, Boolean verified) 
    {
        reviewBaseID = baseID;
        this.customerID = customerID;
        this.rating = rating;
        dateTime = date;
        reviewBody = body;
        this.verified = verified;
        observers = new LinkedList();
    }
    
    /**
     * Use this constructor when creating a new review object.
     * Verified is automatically set to false.
     * @param baseID
     * @param customerID
     * @param rating
     * @param body
     */
    public Review(Integer baseID, Integer customerID, Integer rating, String body) 
    {
        reviewBaseID = baseID;
        this.customerID = customerID;
        this.rating = rating;
        dateTime = Calendar.getInstance().getTime();
        reviewBody = body;
        this.verified = false;
        observers = new LinkedList();
    }
    
    @Override
    public DatabaseTable getTable() {
        return table;
    }
    
    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> { observer.update(this); });
    }
    
    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Cannot register a null observer");
        } else if (observers.contains(o)) {
            throw new IllegalArgumentException("Observer already exists in list");
        } else {
            return observers.add(o);
        }
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Cannot remove a null observer");
        } else if (!observers.contains(o)) {
            throw new IllegalArgumentException("Observer doesn't exist in list");
        } else {
            return observers.remove(o);
        }
    }

    @Override
    public Integer getReviewBaseID() {
        if (reviewBaseID == null) {
            throw new NullPointerException("Null ID");
        } else {
            return reviewBaseID;
        }
    }

    @Override
    public Integer getCustomerID() {
        if (customerID == null) {
            throw new NullPointerException("Null customer ID");
        } else {
            return customerID;
        }
    }

    @Override
    public Date getDateTime() {
        if (dateTime == null) {
            throw new NullPointerException("Null date / time");
        } else {
            return dateTime;
        }
    }

    @Override
    public Boolean setDateTime(Date datetime) {
        if (datetime == null) {
            throw new NullPointerException("Cannot set date / time to null");
        } else {
            Boolean valid = Validator.dateTimeValidator(datetime);
            if (valid) {
                dateTime = datetime;
                notifyObservers();
            }
            return dateTime == datetime;
        }
    }

    @Override
    public Integer getRating() {
        if (rating == null) {
            throw new NullPointerException("Null rating");
        } else {
            return rating;
        }
    }

    @Override
    public Boolean setRating(Integer rating) {
        if (rating == null) {
            throw new NullPointerException("Cannot set rating to null");
        } else {
            Boolean valid = Validator.ratingValidator(rating);
            if (valid) {
                this.rating = rating;
                notifyObservers();
            }
            return Objects.equals(this.rating, rating);
        }
    }

    @Override
    public String getBody() {
        if (reviewBody == null) {
            throw new NullPointerException("Null review body");
        } else {
            return reviewBody;
        }
    }

    @Override
    public Boolean SetBody(String body) {
        if (body == null) {
            throw new NullPointerException("Cannot set review body to null");
        } else {
            Boolean valid = Validator.reviewBodyValidator(body);
            if (valid) {
                reviewBody = body;
                notifyObservers();
            }
            return reviewBody.equals(body);
        }
    }

    @Override
    public Boolean isVerified() {
        if (verified == null) {
            throw new NullPointerException("Verified equals null");
        } else {
            return verified;
        }
    }

    @Override
    public Boolean setVerified(Boolean verified) {
        if (verified == null) {
            throw new NullPointerException("Cannot set verified as null");
        } else {
            this.verified = verified;
        }
        return Objects.equals(this.verified, verified);
    }
}
