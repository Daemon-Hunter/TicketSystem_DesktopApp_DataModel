/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import database.DatabaseTable;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import utilities.Validator;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class SocialMedia implements ISocial {
    
    private Integer id;
    private String  facebook, twitter, instagram, soundcloud, website, spotify;
    private List<BufferedImage> images;
    private final DatabaseTable table = DatabaseTable.SOCIAL_MEDIA;
    private LinkedList<IObserver> observers;
    
    public SocialMedia() {}

    public SocialMedia(Integer id, List<BufferedImage> images, String facebook, String twitter,
                       String instagram, String soundcloud, String website, String spoify){

        this.id = id;
        this.images = images;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.soundcloud = soundcloud;
        this.website = website;
        this.spotify = spoify;
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
    public List<BufferedImage> getImages() {
        return new LinkedList<BufferedImage>(images);
    }

    @Override
    public BufferedImage getImage(int index) {
        return images.get(index);
    }

    @Override
    public Boolean addImage(BufferedImage img) {
        if (images.toArray().length >= 5)
            throw new IllegalArgumentException("Cannot add more than 5 images.");
        else
            return images.add(img);
    }

    @Override
    public Boolean removeImage(int index) {
    images.remove(index);
    return !images.contains(index);
    }

    @Override
    public Boolean setImages(List<BufferedImage> images) {
        this.images = new LinkedList<>(images);
        return this.images == new LinkedList<>(images);
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
        if (observers == null) {
            observers = new LinkedList();
        } else {
            for (IObserver o : observers) {
                o.update(this);
            }
        }
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
