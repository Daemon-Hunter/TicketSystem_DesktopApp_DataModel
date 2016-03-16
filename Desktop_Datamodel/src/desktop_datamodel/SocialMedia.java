/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import utilities.Validator;
import java.net.URL;

/**
 *
 * @author 10512691
 */
public class SocialMedia implements ISocial {
    
    Validator validator;
    Integer id;
    URL image;
    URL facebook;
    URL twitter;
    URL instagram;
    URL soundcloud;
    URL website;
    URL spotify;
    
    public SocialMedia(Integer id, URL img, URL fb, URL tw, URL insta,
                    URL sc, URL web, URL sp) {
        this.id    = id;
        image      = img;
        facebook   = fb;
        twitter    = tw;
        instagram  = insta;
        soundcloud = sc;
        website    = web;
        spotify    = sp;
        validator  = new Validator();
    }

    @Override
    public Integer getId() {
        if (id == null) {
            throw new NullPointerException();
        } else return id;
    }

    /**
     * Checks the given integer against a regular expression that defines
     * the rules for an identification number.
     * @param id
     * @return 
     */
    @Override
    public Boolean setId(Integer id) {
        Boolean valid = validator.idValidator(id);
        if (valid) {
            this.id = id;
        }
        return valid;
    }

    @Override
    public URL getImage() {
        if (image == null) {
            throw new NullPointerException();
        } else return image;
    }

    @Override
    public Boolean setImage(URL img) {
        Boolean valid = validator.URLValidator(img);
        if (valid) {
            image = img;
        }
        return valid;
    }

    @Override
    public URL getFacebook() {
        if (facebook == null) {
            throw new NullPointerException();
        } else {
            return facebook;
        }
    }

    @Override
    public Boolean setFacebook(URL fb) {
        Boolean valid = validator.URLValidator(fb);
        if (valid) {
            facebook = fb;
        }
        return valid;
    }

    @Override
    public URL getTwitter() {
        if (twitter == null) {
            throw new NullPointerException();
        } else {
            return twitter;
        }
    }

    @Override
    public Boolean setTwitter(URL tw) {
        Boolean valid = validator.URLValidator(tw);
        if (valid) {
            twitter = tw;
        }
        return valid;
    }

    @Override
    public URL getInstagram() {
        if (instagram == null) {
            throw new NullPointerException();
        } else {
            return instagram;
        }
    }

    @Override
    public Boolean setInstagram(URL insta) {
        Boolean valid = validator.URLValidator(insta);
        if (valid) {
            instagram = insta;
        }
        return valid;
    }

    @Override
    public URL getSoundcloud() {
        if (soundcloud == null) {
            throw new NullPointerException();
        }
        return soundcloud;
    }

    @Override
    public Boolean setSoundcloud(URL sc) {
        Boolean valid = validator.URLValidator(sc);
        if (valid) {
            soundcloud = sc;
        }
        return valid;
    }

    @Override
    public URL getWebsite() {
        if (website == null) {
            throw new NullPointerException();
        }
        return website;
    }

    @Override
    public Boolean setWebsite(URL web) {
        Boolean valid = validator.URLValidator(web);
        if (valid) {
            website = web;
        }
        return valid;
    }

    @Override
    public URL getSpotify() {
        if (spotify == null) {
            throw new NullPointerException();
        } else {
            return spotify;
        }
    }

    @Override
    public Boolean setSpotify(URL sp) {
        Boolean valid = validator.URLValidator(sp);
        if (valid) {
            spotify = sp;
        }
        return valid;
    }
    
}
