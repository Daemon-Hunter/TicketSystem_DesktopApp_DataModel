/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets;

import events.ChildEvent;

/**
 *
 * @author 10512691
 */
public class TicketFactory implements ITicketFactory {

    @Override
    public Ticket createTicket(ChildEvent event, Double price, String description, Integer remaining, String type) throws IllegalArgumentException {
        return new Ticket(event, price, description, remaining, type);
    }
    
}
