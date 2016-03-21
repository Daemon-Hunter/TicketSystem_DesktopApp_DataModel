/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.net.URL;
import java.util.LinkedList;
import java.util.Optional;
import reviews.Review;
import reviews.ReviewBase;
import reviews.IReviewFactory;
import reviews.ParentEventReviewFactory;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class ParentEvent extends ReviewBase implements IParentEvent {
    
    private LinkedList<ChildEvent> childEvents;
    
    /**
     * Empty constructor initializes it's review factory and child event list.
     */
    public ParentEvent() {
        super();
        // Initialize table variable, which matches Java object to database table
        table = DatabaseTable.PARENTEVENT;
        childEvents = new LinkedList<>();
        reviewFactory = new ParentEventReviewFactory();
    }

    @Override
    public Integer getSocialId() {
        return socialMedia.getSocialId();
    }

    @Override
    public Boolean setSocialId(Integer socialId) {
        return socialMedia.setSocialId(socialId);
    }

    @Override
    public LinkedList<ChildEvent> getChildEvents() {
        if (childEvents == null) {
            throw new NullPointerException("Null child event list");
        } else {
            return childEvents;
        }
    }

    @Override
    public Integer getParentEventID() {
        if (ID == null) {
            throw new NullPointerException("Null ID");
        } else {
            return ID;
        }
    }

    @Override
    public String getParentEventName() {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            return name;
        }
    }

    @Override
    public String getParentEventDescription() {
        if (description == null) {
            throw new NullPointerException("Null description");
        } else {
            return description;
        }
    }

    @Override
    public Boolean setParentEventName(String name) {
        if (name == null) {
            throw new NullPointerException("Null name");
        } else {
            Boolean valid = validator.nameValidator(name);
            if (valid) {
                this.name = name;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean setParentEventDescription(String description) {
        if (description == null) {
            throw new NullPointerException("Null description");
        } else {
            Boolean valid = validator.descriptionValidator(description);
            if (valid) {
                this.description = description;
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public Boolean addChildEvent(ChildEvent childEvent) {
        if (childEvent == null) {
            throw new NullPointerException("Null child event");
        } else {
            Boolean valid = validator.childEventValidator(childEvent);
            if (valid) {
                childEvents.add(childEvent);
                notifyObservers();
            }
            return valid;
        }
    }

    @Override
    public ChildEvent getChildEvent(Integer childEventID) {
        if (childEventID == null) {
            throw new NullPointerException("Null child event ID");
        } else {
            Optional<ChildEvent> event = childEvents.stream()
                                                    .findFirst()
                                                    .filter(e -> e.getChildEventID().equals(childEventID));
            if (event.isPresent()) {
                return event.get();
            } else {
                throw new IllegalArgumentException("Child event not in events list");
            }
        }
    }

    @Override
    public Boolean removeChildEvent(ChildEvent childEvent) {
        if (childEvent == null) {
            throw new NullPointerException("Null child event");
        } else {
            childEvents.remove(childEvent);
            return true;
        }
    }
    
}
