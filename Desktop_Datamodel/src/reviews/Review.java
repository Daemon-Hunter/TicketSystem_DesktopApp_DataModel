/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;
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
    protected User          user;
    protected Date          dateTime;
    protected Integer       rating;
    protected String        reviewBody;
    protected Boolean       verified;
    protected DatabaseTable table;
    protected LinkedList<IObserver> observers;
    
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
        if (user == null) {
            throw new NullPointerException("Null user");
        } else {
            return user.getCustomerID();
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
