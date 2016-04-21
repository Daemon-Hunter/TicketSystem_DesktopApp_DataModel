/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import reviews.IReviewable;

import java.util.List;


/**
 *
 * @author 10467841
 */
public interface IParentEvent extends ISocial, IReviewable {
    public Integer getParentEventID();
    public String getParentEventName();
    public String getParentEventDescription();
    public Boolean setParentEventName(String name);
    public Boolean setParentEventDescription(String description);

    public void setSocialMedia(SocialMedia socialMedia);
    
    public Boolean addChildEvent(IChildEvent childEvent);
    public Boolean addChildEventList(List<IChildEvent> childEvents);
    public IChildEvent getChildEvent(Integer childEventID);
    public Boolean removeChildEvent(IChildEvent childEvent);
    public List<IChildEvent> getChildEvents();
}
