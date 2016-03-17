/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.net.URL;

/**
 *
 * @author 10512691
 */
public interface ISocial {
    
    Integer getId();
    Boolean setId(Integer id);
    
    URL getImage();
    Boolean setImage(URL img);
    
    URL getFacebook();
    Boolean setFacebook(URL fb);
    
    URL getTwitter();
    Boolean setTwitter(URL tw);
    
    URL getInstagram();
    Boolean setInstagram(URL insta);
    
    URL getSoundcloud();
    Boolean setSoundcloud(URL sc);
    
    URL getWebsite();
    Boolean setWebsite(URL web);
    
    URL getSpotify();
    Boolean setSpotify(URL sp);
}
