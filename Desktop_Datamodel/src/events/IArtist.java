/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author 10467841
 */
public interface IArtist extends ISocial {
    
    Integer getID();
    String getName();
    Boolean setName(String name) throws IllegalArgumentException;
    List<String> getTags();
    Boolean addTag(String tag) throws IllegalArgumentException;
    Boolean removeTag(String tag);
    String getDescription();
    Boolean setDescription(String decription) throws IllegalArgumentException;
    String getType() throws IOException;
    Boolean setType(String type) throws IllegalArgumentException;
    Integer getTypeID();

    void setSocialMedia(SocialMedia socialMedia);
    SocialMedia getSocialMedia();

    List<IChildEvent> getChildEvents() throws IOException;
    IChildEvent getChildEvent(Integer childEventID) throws IOException;

    Boolean newContract(IChildEvent childEvent) throws IOException;
}
