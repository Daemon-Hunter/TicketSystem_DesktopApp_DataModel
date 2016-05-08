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
public interface ITicketFactory {
    
    public ITicket createTicket(Double price, String description, Integer remaining, String type);
}
