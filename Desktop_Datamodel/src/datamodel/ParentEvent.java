/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.util.LinkedList;
import java.util.Optional;
import reviews.IReview;
import reviews.ReviewBase;
import reviews.ParentEventReviewFactory;
import utilities.Validator;

/**
 *
 * @author 10512691
 */
public class ParentEvent extends ReviewBase implements IParentEvent {
    
    /*
        Inherits:
        IReviewFactory        reviewFactory;
        LinkedList<Review>    reviews;
        LinkedList<IObserver> observers;
        SocialMedia           socialMedia;
        Integer               socialMediaID;
        DatabaseTable         table;
     */
    
    private LinkedList<ChildEvent> childEvents;
    
    /**
     * Empty constructor initializes it's review factory and child event list.
     */
    public ParentEvent() {
        super();
        // Initialize table variable, which matches Java object to database table
        setTable(DatabaseTable.PARENT_EVENT);
        childEvents = new LinkedList<>();
        reviewFactory = new ParentEventReviewFactory();
    }
    
    public ParentEvent(Integer ID, SocialMedia social, String name, String description,
                        LinkedList<IReview> reviewsList,LinkedList<ChildEvent> events)
    {
        super(ID, name, description, social, reviewsList);
        setTable(DatabaseTable.PARENT_EVENT);
        childEvents = events; 
        reviewFactory = new ParentEventReviewFactory();

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
    public Boolean addChildEvent(ChildEvent childEvent) {
        if (childEvent == null) {
            throw new NullPointerException("Null child event");
        }
        return childEvents.add(childEvent);
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

    @Override
    public Integer getParentEventID() {
        return ID;
    }

    @Override
    public String getParentEventName() {
        return name;
    }

    @Override
    public String getParentEventDescription() {
        if (description == null) {
            throw new NullPointerException("Parent Event description is null");
        } else {
            return description;
        }
    }

    @Override
    public Boolean setParentEventName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean setParentEventDescription(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
