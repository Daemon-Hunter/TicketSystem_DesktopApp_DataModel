/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import reviews.IReviewable;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 10467841
 */
public interface IArtist extends ISocial, IReviewable {
    
    Integer getID();
    String getName();
    void setName(String name);
    List<String> getTags();
    Boolean addTag(String tag);
    Boolean removeTag(String tag);
    String getDescription();
    void setDescription(String decription);
    String getType();
    Boolean setType(String type);
    Integer getTypeID();

    void setSocialMedia(SocialMedia socialMedia);

    List<IChildEvent> getChildEvents() throws IOException;
}
