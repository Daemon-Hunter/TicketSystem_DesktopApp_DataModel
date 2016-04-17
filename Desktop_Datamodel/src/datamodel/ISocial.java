/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.awt.image.BufferedImage;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface ISocial extends IDbSubject {
    
    Integer getSocialId();
    Boolean setSocialId(Integer id);
    
    BufferedImage getImage();
    Boolean setImage(BufferedImage img);
    
    String getFacebook();
    Boolean setFacebook(String fb);
    
    String getTwitter();
    Boolean setTwitter(String tw);
    
    String getInstagram();
    Boolean setInstagram(String insta);
    
    String getSoundcloud();
    Boolean setSoundcloud(String sc);
    
    String getWebsite();
    Boolean setWebsite(String web);
    
    String getSpotify();
    Boolean setSpotify(String sp);
}
