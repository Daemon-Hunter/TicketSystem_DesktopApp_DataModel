/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;

import events.IChildEvent;
import java.io.IOException;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface ITicket extends IDbSubject {
    
    public Integer getID();
    
    public IChildEvent getEvent() throws IOException;
    public Boolean    setEvent(IChildEvent event);
    
    public Double getPrice();
    public Boolean setPrice(Double price);
    
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
