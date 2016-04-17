/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.List;


/**
 *
 * @author 10467841
 */
public interface IParentEvent {
    public Integer getParentEventID();
    public String getParentEventName();
    public String getParentEventDescription();
    public Boolean setParentEventName(String name);
    public Boolean setParentEventDescription(String description);

    
    public Boolean addChildEvent(ChildEvent childEvent);
    public ChildEvent getChildEvent(Integer childEventID);
    public Boolean removeChildEvent(ChildEvent childEvent);
    public List<ChildEvent> getChildEvents();
}
