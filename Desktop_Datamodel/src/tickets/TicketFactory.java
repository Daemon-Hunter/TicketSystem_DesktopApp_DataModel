/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;

import events.IChildEvent;

/**
 *
 * @author 10512691
 */
public class TicketFactory implements ITicketFactory {
    
    IChildEvent childEvent;
    
    public TicketFactory(IChildEvent childEvent) {
        this.childEvent = childEvent;
    }
    
    /**
     * Creates a ticket for the child event, adding it to the event on creation.
     * @param price
     * @param description
     * @param remaining
     * @param type
     * @return
     * @throws IllegalArgumentException 
     */
    @Override
    public ITicket createTicket(Double price, String description, Integer remaining, String type) throws IllegalArgumentException {
        ITicket ticket = new Ticket(childEvent, price, description, remaining, type);
        childEvent.addTicket(ticket);
        return ticket;
    }
    
}
