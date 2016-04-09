/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import datamodel.Artist;
import datamodel.IArtist;
import datamodel.SocialMedia;
import datamodel.Venue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import people.Customer;
import reviews.ArtistReviewFactory;
import reviews.IReview;
import reviews.ParentEventReviewFactory;
import reviews.VenueReviewFactory;

/**
 *
 * @author Dominic
 */
public class MapToObject {
//TODO ON REVIEWS DATETIME , VERIFIED WITH THE FACTORY

    
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
           String description = null; //DOMINIC DO SOMTHING HERE ONCE API UPDATED
           
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
            artist = new Artist(ID,name, description, listOfTags,social,listOfReviews);
           return artist;
        } 
        catch(Exception ex) {
            
        }
        // Return null if the artist was not created properly.
        return null;
    }
    
    public static SocialMedia ConvertSocialMedia(Map<String,String> socialMap) throws IOException
    {
        // CHECK IF IMAGE OUTPUT WORKS.
        SocialMedia social;
        Integer socialMediaID;
        String  facebook, twitter, instagram, soundcloud, website, spotify;
        
        socialMediaID = Integer.parseInt(socialMap.get("SOCIAL_MEDIA_ID"));
        facebook = socialMap.get("FACEBOOK");
        twitter = socialMap.get("TWITTER");
        instagram = socialMap.get("INSTAGRAM");
        soundcloud = socialMap.get("SOUNDCLOUD");
        website = socialMap.get("WEBSITE");
        spotify = socialMap.get("SPOTIFY");
        byte[] strm = socialMap.get("IMAGE").getBytes();
        final BufferedImage img = ImageIO.read(new ByteArrayInputStream(strm));
        
        social = new SocialMedia(socialMediaID, img, facebook, twitter, instagram,soundcloud, website, spotify);
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
        
        private static IReview ConvertVenueReview(Map<String,String> reviewMap){
            VenueReviewFactory factory = new VenueReviewFactory();
            Integer venueID = Integer.parseInt(reviewMap.get("VENUE_ID"));
            Integer customerID = Integer.parseInt(reviewMap.get("CUSTOMER_ID"));
            Integer rating = Integer.parseInt(reviewMap.get("VENUE_REVIEW_RATING"));
            String body = reviewMap.get("VENUE_REVIEW_BODY");
            
            
            IReview review = factory.createReview(venueID,customerID,rating,body);
            return  review;

        }
        
        private static IReview ConvertEventReview(Map<String,String> reviewMap){
        ParentEventReviewFactory factory = new ParentEventReviewFactory();
        Integer eventID = Integer.parseInt(reviewMap.get("PARENT_EVENT_ID	"));
        Integer customerID = Integer.parseInt(reviewMap.get("CUSTOMER_ID"));
        Integer rating = Integer.parseInt(reviewMap.get("EVENT_REVIEW_RATING"));
        String body = reviewMap.get("EVENT_REVIEW_BODY");
        
        
        IReview review = factory.createReview(eventID,customerID,rating,body);
        return review;
        }
        
        public static Venue ConvertVenue(Map<String,String> venueMap)
        {
            Integer venueID,capSeating, capStanding, parking ;
            SocialMedia social;
            String description,facilities, phoneNumber, email, address, postcode, name;
            Boolean disabledAccess = false;
            LinkedList<IReview> reviews = new LinkedList<>();
            venueID = Integer.parseInt(venueMap.get("VENUE_ID"));
             social = new SocialMedia();
            APIConnection socialConn = new APIConnection(social.getTable());
            try {
           social = ConvertSocialMedia(socialConn.readSingle(Integer
                                                 .parseInt(venueMap
                                                 .get("SOCIAL_MEDIA_ID")))); 
            }catch(Exception x)
            {
                social = new SocialMedia();
            }
            description = venueMap.get("VENUE_DESCRIPTION");
            capSeating = Integer.parseInt(venueMap.get("VENUE_CAPACITY_SEATING"));
            capStanding = Integer.parseInt(venueMap.get("VENUE_CAPACITY_STANDING"));
            parking = Integer.parseInt(venueMap.get("VENUE_PARKING"));
            facilities = venueMap.get("VENUE_FACILITES");
            phoneNumber = venueMap.get("VENUE_PHONE_NUMBER");
            email = venueMap.get("VENUE_EMAIL");
            address = venueMap.get("VENUE_ADDRESS");
            postcode = venueMap.get("VENUE_ADDRESS");
            name = venueMap.get("VENUE_NAME");
            if(Integer.parseInt(venueMap.get("VENUE_DISABLED_ACCESS")) == 1);
            {
                disabledAccess = true;
            }
           List<Map<String,String>> allReviews;
          
           allReviews = MapToObject.getListOfReviews(DatabaseTable.VENUE);
           
           for(Map<String,String> currReview : allReviews)
           {
              if(venueID == Integer.parseInt(currReview.get("VENUE_ID")))
              {
                  reviews.add(ConvertArtistReview(currReview));
              }
           }

            
            Venue ven = new Venue(venueID,social,description,capSeating,capStanding,disabledAccess,facilities,
            parking, phoneNumber,email,address,postcode,name,reviews);
            
            return ven;
        }
    
}
