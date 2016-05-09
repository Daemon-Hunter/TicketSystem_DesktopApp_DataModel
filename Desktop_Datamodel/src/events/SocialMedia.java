/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import database.DatabaseTable;
import java.awt.image.BufferedImage;
import utilities.Validator;
import utilities.observer.IObserver;

import java.util.LinkedList;
import java.util.List;

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
    
    public SocialMedia() {
        id = 0;
    }

    public SocialMedia(List<BufferedImage> images, String facebook, String twitter, String instagram, String soundcloud, String website, String spotify) throws IllegalArgumentException {

        Validator.URLValidator(facebook);
        Validator.URLValidator(twitter);
        Validator.URLValidator(instagram);
        Validator.URLValidator(soundcloud);
        Validator.URLValidator(website);
        Validator.URLValidator(spotify);

        this.id = 0;
        this.images = images;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.soundcloud = soundcloud;
        this.website = website;
        this.spotify = spotify;
    }

    public SocialMedia(Integer id, List<BufferedImage> images, String facebook, String twitter,
                       String instagram, String soundcloud, String website, String spotify) {

        this.id = id;
        this.images = images;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.soundcloud = soundcloud;
        this.website = website;
        this.spotify = spotify;
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
        this.id = id;
        return this.id.equals(id);
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
        int length = images.size();
        images.remove(index);
        return length - 1 == images.size();
    }

    @Override
    public Boolean setImages(List<BufferedImage> images) {
        this.images = images;
        return this.images == images;
    }

    @Override
    public String getFacebook() {
        return facebook;
    }

    @Override
    public Boolean setFacebook(String fb) throws IllegalArgumentException {
        Validator.URLValidator(fb);
        this.facebook = fb;
        if (fb == null)
            return true;
        return this.facebook.equals(fb);
    }

    @Override
    public String getTwitter() {
        return twitter;
    }

    @Override
    public Boolean setTwitter(String tw) throws IllegalArgumentException {
        Validator.URLValidator(tw);
        twitter = tw;
        if (tw == null)
            return true;
        return this.twitter.equals(tw);
    }

    @Override
    public String getInstagram() {
        return instagram;
    }

    @Override
    public Boolean setInstagram(String insta) throws IllegalArgumentException {
        Validator.URLValidator(insta);
        instagram = insta;
        if (insta == null)
            return true;
        return this.instagram.equals(insta);
    }

    @Override
    public String getSoundcloud() {
        return soundcloud;
    }

    @Override
    public Boolean setSoundcloud(String sc) throws IllegalArgumentException {
        Validator.URLValidator(sc);
        soundcloud = sc;
        if (sc == null)
            return true;
        return this.soundcloud.equals(sc);
    }

    @Override
    public String getWebsite() {
        return website;
    }

    @Override
    public Boolean setWebsite(String web) throws IllegalArgumentException {
        Validator.URLValidator(web);
        website = web;
        if (web == null)
            return true;
        return this.website.equals(web);
    }

    @Override
    public String getSpotify() {
        return spotify;
    }

    @Override
    public Boolean setSpotify(String sp) throws IllegalArgumentException {
        Validator.URLValidator(sp);
        spotify = sp;
        if (sp == null)
            return true;
        return this.spotify.equals(sp);
    }
}
