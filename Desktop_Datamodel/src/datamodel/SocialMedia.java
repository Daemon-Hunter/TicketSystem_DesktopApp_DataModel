/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class SocialMedia implements ISocial {
    
    private Integer id;
    private String  facebook, twitter, instagram, soundcloud, website, spotify;
    private BufferedImage image;
    private final DatabaseTable table = DatabaseTable.SOCIAL_MEDIA;
    private LinkedList<IObserver> observers;
    
    public SocialMedia(Integer id, BufferedImage img, String fb, String tw, 
            String insta, String sc, String web, String sp) {
        this.id    = id;
        image      = img;
        facebook   = fb;
        twitter    = tw;
        instagram  = insta;
        soundcloud = sc;
        website    = web;
        spotify    = sp;
        observers = new LinkedList<>();
    }
    
    public SocialMedia(){
    }
    

    @Override
    public Integer getSocialId() {
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
    public Boolean setSocialId(Integer id) {
        Boolean valid = Validator.idValidator(id);
        if (valid) {
            this.id = id;
            notifyObservers();
        }
        return valid;
    }

    @Override
    public BufferedImage getImage() {
        if (image == null) {
            throw new NullPointerException();
        } else return image;
    }

    @Override
    public Boolean setImage(BufferedImage img) {
        if (img == null) {
            throw new NullPointerException("Null image");
        } else {
            image = img;
            return true;
        }
    }

    @Override
    public String getFacebook() {
        if (facebook == null) {
            throw new NullPointerException();
        } else {
            return facebook;
        }
    }

    @Override
    public Boolean setFacebook(String fb) {
        Boolean valid = Validator.URLValidator(fb);
        if (valid) {
            facebook = fb;
        }
        return valid;
    }

    @Override
    public String getTwitter() {
        if (twitter == null) {
            throw new NullPointerException();
        } else {
            return twitter;
        }
    }

    @Override
    public Boolean setTwitter(String tw) {
        Boolean valid = Validator.URLValidator(tw);
        if (valid) {
            twitter = tw;
        }
        return valid;
    }

    @Override
    public String getInstagram() {
        if (instagram == null) {
            throw new NullPointerException();
        } else {
            return instagram;
        }
    }

    @Override
    public Boolean setInstagram(String insta) {
        Boolean valid = Validator.URLValidator(insta);
        if (valid) {
            instagram = insta;
        }
        return valid;
    }

    @Override
    public String getSoundcloud() {
        if (soundcloud == null) {
            throw new NullPointerException();
        }
        return soundcloud;
    }

    @Override
    public Boolean setSoundcloud(String sc) {
        Boolean valid = Validator.URLValidator(sc);
        if (valid) {
            soundcloud = sc;
        }
        return valid;
    }

    @Override
    public String getWebsite() {
        if (website == null) {
            throw new NullPointerException();
        }
        return website;
    }

    @Override
    public Boolean setWebsite(String web) {
        Boolean valid = Validator.URLValidator(web);
        if (valid) {
            website = web;
        }
        return valid;
    }

    @Override
    public String getSpotify() {
        if (spotify == null) {
            throw new NullPointerException();
        } else {
            return spotify;
        }
    }

    @Override
    public Boolean setSpotify(String sp) {
        Boolean valid = Validator.URLValidator(sp);
        if (valid) {
            spotify = sp;
        }
        return valid;
    }

    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> { observer.update(this); });
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Observer is null");
        } else if (observers.contains(o)) {
            throw new IllegalArgumentException("Observer already exists in list");
        } else {
            observers.add(o);
            return true;
        }
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Observer is null");
        } else if (!observers.contains(o)) {
            throw new IllegalArgumentException("Observer doesn't exist in list");
        } else {
            observers.remove(o);
            return true;
        }
    }
}
