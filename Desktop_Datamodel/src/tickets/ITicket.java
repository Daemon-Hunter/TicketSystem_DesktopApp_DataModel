/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;

import datamodel.ChildEvent;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface ITicket extends IDbSubject {
    
    public Integer getID();
    
    public ChildEvent getEvent();
    public Boolean    setEvent(ChildEvent event);
    
    public Integer getPrice();
    public Boolean setPrice(Integer price);
    
    public String  getDescription();
    public Boolean setDescription(String description);
    
    /**
     * Gets the amount of tickets of that ticket type remaining.
     * Child event can have multiple ticket types, so remaining
     * is stored in that ticket type.
     * @return 
     */
    public Integer getRemaining();
    public Boolean setRemaining(Integer remaining);
    
    public String  getType();
    public Boolean setType(String type);
}
