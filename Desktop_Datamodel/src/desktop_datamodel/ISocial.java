/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 *
 * @author 10512691
 */
interface ISocial {
    
    URL getFacebook();
    Boolean setFacebook(URL fb);
    
    URL getTwitter();
    Boolean setTwitter(URL tw);
    
    Image getImage();
    Boolean setImage(Image img);
    
    URL getInstagram();
    Boolean setInstagram(URL insta);
    
    URL getSpotify();  
    Boolean setSpotify(URL spotify);
    
    URL getSoundcloud();
    Boolean setSoundcloud(URL sc);
    
    URL getWebsite();
    Boolean setWebsite(URL web);
}
