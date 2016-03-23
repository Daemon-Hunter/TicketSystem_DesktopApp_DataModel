/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import datamodel.Artist;
import datamodel.IArtist;
import datamodel.SocialMedia;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import people.Customer;
import reviews.ArtistReviewFactory;
import reviews.IReview;

/**
 *
 * @author Dominic
 */
public class MapToObject {


    
    public MapToObject()
    {
        
    }
    
  
    public static Customer ConvertCustomer(Map<String,String> custMap)
  {
     String firstName, lastName,address, email, postcode; 
     firstName = custMap.get("CUSTOMER_FIRST_NAME");
     lastName  = custMap.get("CUSTOMER_LAST_NAME");
     int ID    = Integer.parseInt(custMap.get("CUSTOMER_ID"));
     address   = custMap.get("CUSTOMER_ADDRESS");
     email     = custMap.get("CUSTOMER_EMAIL");
     postcode  = custMap.get("CUSTOMER_POSTCODE");
     
     Customer cust = new Customer(ID,firstName, lastName, email, address, postcode);
     
       return cust;
    }
    
    public static IArtist ConvertArtist(Map<String,String> artistMap)
    {
        IArtist artist;
        SocialMedia social = new SocialMedia();
        APIConnection socialConn = new APIConnection(social.getTable());
        try {
           social = ConvertSocialMedia(socialConn.readSingle(Integer
                                                 .parseInt(artistMap
                                                 .get("SOCIAL_MEDIA_ID")))); 
           Integer ID  = Integer.parseInt(artistMap.get("ARTIST_ID"));
           String name = artistMap.get("ARTIST_NAME");
           String tags = artistMap.get("ARTIST_TAGS");
           String[] tempArr = tags.split("#");
           
           LinkedList<String>  listOfTags    = new LinkedList<>();
           LinkedList<IReview> listOfReviews = new LinkedList<>();
           List<Map<String,String>> allReviews;
           
           allReviews = MapToObject.getListOfReviews(DatabaseTable.ARTIST);
           
           listOfTags.addAll(Arrays.asList(tempArr));
           for(Map<String,String> currReview : allReviews)
           {
              if(ID == Integer.parseInt(currReview.get("ARTIST_ID")))
              {
                  listOfReviews.add(ConvertArtistReview(currReview));
              }
           }
           artist = new Artist(ID,name,listOfTags,social,listOfReviews);
           return artist;
        } 
        catch(Exception ex) {
            
        }
        // Return null if the artist was not created properly.
        return null;
    }
    
    public static SocialMedia ConvertSocialMedia(Map<String,String> socialMap)
    {
        SocialMedia social = new SocialMedia();
        
        
        
        
        return social;
    }
    
    private  static List<Map<String,String>> getListOfReviews(DatabaseTable table)
    {
        List<Map<String,String>> listOfReviews;
        
        APIConnection   conn = new APIConnection(table);
        listOfReviews = conn.readAll();
        
        
        return listOfReviews;
    }
        private static IReview ConvertArtistReview(Map<String, String> reviewMap) {
            
            ArtistReviewFactory factory = new ArtistReviewFactory();
            Integer artistID   = Integer.parseInt(reviewMap.get("ARTIST_ID"));
            Integer customerID = Integer.parseInt(reviewMap.get("CUSTOMER_ID"));
            Integer rating     = Integer.parseInt(reviewMap.get("ARTIST_REVIEW_RATING"));
            String  body       = reviewMap.get("ARTIST_REVIEW_BODY");
            
            IReview review     = factory.createReview(artistID, customerID, rating, body);
            return  review;
            
    }
    
}
