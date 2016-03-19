/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.Date;

/**
 *
 * @author 10512691
 */
interface IChildEvent extends ILineup {
    
    public Integer getChildEventID();
    public String  getChildEventName();
    public String  getChildEventDescription();
    public Date    getChildEventStartDateTime();
    public Date    getChildEventEndDateTime();
    public Boolean getChildEventCanceled();
    
    public Boolean setChildEventName(String name);
    public Boolean setChildEventDescription(String description);
    public Boolean setChildEventStartDateTime(Date startDateTime);
    public Boolean setChildEventEndDateTime(Date endDateTime);
    public Boolean setChildEventCanceled(Boolean canceled);
    
    public Boolean setVenue(IVenue venue);
    public IVenue getVenue();
    
    public Boolean setLineup(ILineup lineup);
}
