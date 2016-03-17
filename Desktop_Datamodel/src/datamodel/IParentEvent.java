/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;


/**
 *
 * @author 10467841
 */
public interface IParentEvent {
    
    Integer getParentEventID();
    String getParentEventName();
    String getParentEventDescription();
    void setParentEventName();
    void setParentEventDescription();
    
    
    Boolean addChildEvent(ChildEvent childEvent);
    ChildEvent getChildEvent(Integer childEventID);
    Boolean removeChildEvent(ChildEvent childEvent);
}
