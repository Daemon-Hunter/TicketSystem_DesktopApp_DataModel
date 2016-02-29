/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10512691
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Artist artist = null;
        
        Database db = new Database();
        if (db.createConnection()) {
            ResultSet results = db.getArtistsAll();
            if (results != null) {
                try {
                    Integer id;
                    String name;
                    List<String> tags = new ArrayList();
                    SocialMedia social;
                    while (results.next()) {
                        String result = results.getString("ARTIST_ID");
                        id = Integer.parseInt(result);
                        
                        result = results.getString("ARTIST_NAME");
                        name = result;
                        
                        result = results.getString("ARTIST_TAGS");
                        String[] split = result.split(",");
                        for (String s : split) {
                            tags.add(s);
                        }
                        result = results.getString("SOCIAL_MEDIA_ID");
                        ResultSet socialResults = db.getMedia(Integer.parseInt(result));
                        
                        if (socialResults != null) {
                            while (socialResults.next()) {
                                Integer socId;
                                URL img;
                                URL fb;
                                URL tw;
                                URL sc;
                                URL sp;
                                URL web;
                                URL insta;
                                
                                result = socialResults.getString("SOCIAL_MEDIA_ID");
                                socId = Integer.parseInt(result);
                                
                                img = socialResults.getURL("IMAGE");
                                web = socialResults.getURL("WEBSITE");
                                
                                try {
                                    fb = new URL("http://www.facebook.com/" + socialResults.getString("FACEBOOK"));
                                    try {
                                        tw = new URL("http://www.twitter.com/" + socialResults.getString("TWITTER"));
                                        try {
                                            sc = new URL("http://www.soundcloud.com/" + socialResults.getString("SOUNDCLOUD"));
                                            try {
                                                sp = new URL("http://www.spotify.com/" + socialResults.getString("SPOTIFY"));
                                                try {
                                                    insta = new URL("http://www.instagram.com/" + socialResults.getString("INSTAGRAM"));
                                                    
                                                    SocialMedia soc = new SocialMedia(socId, fb, tw, sc, sp, insta, web, img);
                                                    
                                                    artist = new Artist(id, name, tags, soc);
                                                }
                                                catch (MalformedURLException ex) {

                                                }
                                            }
                                            catch (MalformedURLException ex) {

                                            }
                                        }
                                        catch (MalformedURLException ex) {

                                        }
                                    }
                                    catch (MalformedURLException ex) {

                                    }
                                }
                                catch (MalformedURLException ex) {
                                        
                                }
                            }
                        }
                        
                        
                        
                    }
                }
                catch (SQLException ex) {
                    System.out.println("SQL Exception whilst finding next 'result'.");
                }
            } else {
                System.out.println("Null ResultSet returned -> SQLException creating "
                    + "statement in Database object.");
            }
            
            db.closeConnection();
            
            if (artist != null) {
                System.out.println("ID: " + artist.artistID);
                System.out.println("NAME: " + artist.name);
                System.out.println("SOCIAL ID: " + artist.social.id);
                System.out.println("INSTAGRAM: " + artist.social.instagram);
                System.out.println("FB: " + artist.social.facebook);
                System.out.println("WEB: " + artist.social.website + "\n\n");
            }
            
        } else {
            System.out.println("SQL Exception whilst creating connection.");
        }
        
        
        if (db.createConnection()) {
            ResultSet results = db.getCustomersAll();
            if (results != null) {
                try {
                    while (results.next()) {
                        String result = results.getString("CUSTOMER_ID");
                        System.out.println("Id: " + result);
                        
                        result = results.getString("CUSTOMER_FIRST_NAME");
                        System.out.println("First name: " + result);
                        
                        result = results.getString("CUSTOMER_LAST_NAME");
                        System.out.println("Last name: " + result);
                        
                        result = results.getString("CUSTOMER_EMAIL");
                        System.out.println("Email: " + result);
                        
                        result = results.getString("CUSTOMER_ADDRESS");
                        System.out.println("Address: " + result);
                        
                        result = results.getString("CUSTOMER_POSTCODE");
                        System.out.println("Postcode: " + result);
                        
                        result = results.getString("CUSTOMER_PASSWORD");
                        System.out.println("Password: " + result + "\n\n");
                    }
                }
                catch (SQLException ex) {
                    System.out.println("SQL Exception whilst finding next 'result'.");
                }
            } else {
                System.out.println("Null ResultSet returned -> SQLException creating "
                    + "statement in Database object.");
            }
            
            db.closeConnection();
        } else {
            System.out.println("SQL Exception whilst creating connection.");
        }
        
        
        String[][] k_v = new String[4][2];
        k_v[0][0] = "ARTIST_ID";
        k_v[1][0] = "ARTIST_NAME";
        k_v[2][0] = "ARTIST_TAGS";
        k_v[3][0] = "SOCIAL_MEDIA_ID";
        
        k_v[0][1] = "2";
        k_v[1][1] = "Mungos HiFi";
        k_v[2][1] = "Reggae";
        k_v[3][1] = "2";
        
        db.createConnection();
        db.insert(k_v, "ARTIST");
        db.closeConnection();
    }
    
}
