/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bookings.Booking;
import bookings.CustomerBooking;
import bookings.GuestBooking;
import bookings.Order;
import static database.DatabaseTable.BOOKING;
import static database.DatabaseTable.CUSTOMER;
import datamodel.Artist;
import datamodel.ChildEvent;
import datamodel.IArtist;
import datamodel.ILineup;
import datamodel.IVenue;
import datamodel.Lineup;
import datamodel.ParentEvent;
import datamodel.SocialMedia;
import datamodel.Venue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.System.err;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import people.Customer;
import people.Guest;
import people.IUser;
import reviews.ArtistReviewFactory;
import reviews.IReview;
import reviews.ParentEventReviewFactory;
import reviews.VenueReviewFactory;
import tickets.Ticket;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;

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
     postcode  = custMap. get("CUSTOMER_POSTCODE");
     
     Customer cust = new Customer(ID,firstName, lastName, email, address, postcode);
     
       return cust;
    }
    
    public static Artist ConvertArtist(Map<String,String> artistMap)
    {
        Artist artist;
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
           String description = artistMap.get("ARTIST_DESCRIPTION"); //DOMINIC DO SOMTHING HERE ONCE API UPDATED
           
           LinkedList<String>  listOfTags    = new LinkedList<>();
           LinkedList<IReview> listOfReviews = new LinkedList<>();
           List<Map<String,String>> allReviews;
           listOfTags.addAll(Arrays.asList(tempArr));

           allReviews = MapToObject.getListOfReviews(DatabaseTable.ARTIST_REVIEW);
           
           for(Map<String,String> currReview : allReviews)
           {
              if(ID.equals(Integer.parseInt(currReview.get("ARTIST_ID"))))
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
    
    private static List<Map<String,String>> getListOfReviews(DatabaseTable table)
    {
        List<Map<String,String>> listOfReviews;
        
        APIConnection   conn = new APIConnection(table);
        listOfReviews = conn.readAll();
            
        
        
        return listOfReviews;
    }
    public static IReview ConvertArtistReview(Map<String, String> reviewMap) {
            
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
        
    public static IVenue ConvertVenue(Map<String,String> venueMap){
            
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
            
        if(venueMap.get("VENUE_DISABLED_ACCESS").equals("true"));
            {
                disabledAccess = true;
            
            }   
        List<Map<String,String>> allReviews;  
        allReviews = MapToObject.getListOfReviews(DatabaseTable.VENUE_REVIEW);
           
        for(Map<String,String> currReview : allReviews)
           {
              if(venueID.equals(Integer.parseInt(currReview.get("VENUE_ID"))))
              {
                  reviews.add(ConvertArtistReview(currReview));
              }
           }

            
        
        Venue ven = new Venue(venueID,social,description,capSeating,capStanding,disabledAccess,facilities,
        parking, phoneNumber,email,address,postcode,name,reviews);
            
        return ven;
    }
        
public static Ticket ConvertTicket(Map<String,String> ticketMap)
    {
        Map<String,String> eventMap;
        Integer ticketID, remaining, childEventID; 
        ChildEvent event = new ChildEvent();
        Double price;  
        String desc, type; 
            
        ticketID = Integer.parseInt(ticketMap.get("TICKET_ID"));
        price = Double.parseDouble(ticketMap.get("TICKET_PRICE"));
        remaining = Integer.parseInt(ticketMap.get("TICKET_AMOUNT_REMAINING"));
        type = ticketMap.get("TICKET_TYPE");
        desc = ticketMap.get("TICKET_DESCRIPTION");
        childEventID = Integer.parseInt(ticketMap.get("CHILD_EVENT_ID"));
            
        try
        {
           APIConnection eventConn = new APIConnection(DatabaseTable.CHILD_EVENT);
           eventMap = eventConn.readSingle(childEventID);
            event = ConvertEvent(eventMap);

        }
        catch(Exception ex)
        {
                
        }
            
        Ticket retTicker = new Ticket(ticketID, event,price, desc,remaining,type );
            
                    
            
        return retTicker;
    }
        
        
public static ChildEvent ConvertEvent(Map<String, String> eventMap) {
        Integer eventID, venueID, lineupID;
        String description,name;
        Date startTime, endTime;
        IVenue venue;
        ILineup lineup;
        Boolean cancelled = false;
        
        eventID = Integer.parseInt(eventMap.get("CHILD_EVENT_ID"));
        name = eventMap.get("CHILD_EVENT_NAME");
        description = eventMap.get("CHILD_EVENT_DESCRIPTION");
        venueID = Integer.parseInt(eventMap.get("VENUE_ID"));
        lineupID = Integer.parseInt(eventMap.get("LINEUP_ID"));
        APIConnection venueConn = new APIConnection(DatabaseTable.VENUE);
        APIConnection lineupConn = new APIConnection(DatabaseTable.LINEUP);
        venue = ConvertVenue(venueConn.readSingle(venueID));
        lineup = ConvertLineup(lineupConn.readSingle(lineupID));
        if(eventMap.get("CHILD_EVENT_CANCELED").equals("true"))
        {
            cancelled = true;
        }

        startTime = ConvertDate(eventMap.get("START_DATE_TIME"));
        endTime = ConvertDate(eventMap.get("END_DATE_TIME"));
        
        
        
                       
                
        ChildEvent event = new ChildEvent(eventID,name,description,startTime,endTime,venue,lineup,cancelled);
        
      return event;
                
    }

public static ILineup ConvertLineup(Map<String,String> lineupMap)
{
    List<IArtist> artists = new ArrayList<>();
    Integer lineupID; 
    
    lineupID = Integer.parseInt(lineupMap.get("LINEUP_ID"));
    String artistID = "ARTIST";
    String _ID = "_ID";
    APIConnection artistConn = new APIConnection(DatabaseTable.ARTIST);
    
    for(int i = 1; i < 11; i++)
    {
     if(!lineupMap.get(artistID + String.valueOf(i)+ _ID).equals("null")) // Might not need inversion
     {
         artists.add(ConvertArtist(artistConn.readSingle(
                 Integer.parseInt(lineupMap.get(artistID+String.valueOf(i) + _ID)))));
     }
    }
    
    Lineup lineup = new Lineup(lineupID,artists);
    
    return lineup;
}   


private static Date ConvertDate(String dateTime) {
    Date thisDate = new Date();
    String[] dateTimeArray = dateTime.split("T");
    String[]   dateArray = dateTimeArray[0].split("-");
    String[]  timeArray = dateTimeArray[1].split(":");
    
    thisDate.setYear(Integer.parseInt(dateArray[0]));
    thisDate.setMonth(Integer.parseInt(dateArray[1]));
    thisDate.setDate(Integer.parseInt(dateArray[2]));
   
    thisDate.setHours(Integer.parseInt(timeArray[0]));
    thisDate.setMinutes(Integer.parseInt(timeArray[1]));
    thisDate.setSeconds(Integer.parseInt(timeArray[2]));
    
    return thisDate;
    }

public static CustomerBooking ConvertCustomerBooking(Map<String,String> bookingMap)
{
    Integer bookingID, ticketID, orderID,quantity,customerID;
    Ticket ticket;
    Date date;
    Order order;
    
    bookingID = Integer.parseInt(bookingMap.get("BOOKING_ID"));
    ticketID = Integer.parseInt(bookingMap.get("TICKET_ID"));
    orderID = Integer.parseInt(bookingMap.get("ORDER_ID"));
    quantity = Integer.parseInt(bookingMap.get("BOOKING_QUANTITY"));
    
    
    APIConnection ticketConn = new APIConnection(DatabaseTable.TICKET);
    APIConnection orderConn = new APIConnection(DatabaseTable.ORDER);
    
    date = ConvertDate(bookingMap.get("BOOKING_DATE_TIME"));
    
    ticket = ConvertTicket(ticketConn.readSingle(ticketID));
    
    order = ConvertOrder(orderConn.readSingle(orderID));
    
    CustomerBooking booking = new CustomerBooking(bookingID, ticket, quantity, date, order);
    
    
    return booking;
}

public static Order ConvertOrder(Map<String,String> orderMap){
    
    Integer orderID, userID;
    List<Integer> bIDlist = new LinkedList();
    IUser user;
    List<Booking> bList = new LinkedList();
    List<Map<String,String>> allBookings;  
    
    orderID = parseInt(orderMap.get("ORDER_ID"));
    userID = parseInt(orderMap.get("CUSTOMER_ID"));
    
    APIConnection customerConn = new APIConnection(CUSTOMER);
    
    user = ConvertCustomer(customerConn.readSingle(userID));
    
    try{
        
    allBookings = getListOfReviews(BOOKING);
    for(Map<String,String> currBooking: allBookings)
    {
      if(orderID.equals(parseInt(currBooking.get("ORDER_ID"))))
      {
          bList.add(ConvertCustomerBooking(currBooking));
      }
             
    }
    }
    catch(Exception ex)
    {
            err.println("No child events for this parent event");
    }
    
    Order order = new Order(orderID, user, bList);
    
    return order;
}

public static GuestBooking ConvertGuestBooking(Map<String,String> bookingMap)
{
    Integer bookingID, ticketID, quantity;
    String email, address, postcode;
    Date dateTime;
    Ticket ticket;
    
    bookingID = Integer.parseInt(bookingMap.get("GUEST_BOOKING_ID"));
    ticketID = Integer.parseInt(bookingMap.get("TICKET_ID"));
    quantity = Integer.parseInt(bookingMap.get("GUEST_BOOKING_QUANTITY"));
    email = bookingMap.get("GUEST_EMAIL");
    address = bookingMap.get("GUEST_ADDRESS");
    postcode = bookingMap.get("GUEST_POSTCODE");
    dateTime = ConvertDate(bookingMap.get("GUEST_BOOKING_DATE_TIME"));

    APIConnection ticketConn = new APIConnection(DatabaseTable.TICKET);
    ticket = ConvertTicket(ticketConn.readSingle(ticketID));
    

    
    
    
    GuestBooking booking = new GuestBooking( bookingID, ticket, quantity,dateTime, new Guest("GUEST","ACCOUNT",  email, address, postcode));
    
    
    
    
    return booking;
}

public static ParentEvent ConvertParentEvent(Map<String,String> eventMap)
{
    Integer eventID, socialMediaID;
    String name, description;
    SocialMedia social;
    LinkedList<IReview> reviewsList = new LinkedList<>();
    LinkedList<ChildEvent> childEvents= new LinkedList<>();
    List<Map<String,String>> allReviews; 
    List<Map<String,String>> allEvents;  


    
    eventID = Integer.parseInt(eventMap.get("PARENT_EVENT_ID"));
    name  = eventMap.get("PARENT_EVENT_NAME");
    description = eventMap.get("PARENT_EVENT_DESCRIPTION");
    socialMediaID = Integer.parseInt(eventMap.get("SOCIAL_MEDIA_ID"));
    APIConnection socialConn = new APIConnection(DatabaseTable.SOCIAL_MEDIA);
    socialConn.readSingle(socialMediaID);
        try {
           social = ConvertSocialMedia(socialConn.readSingle(socialMediaID));
        } catch (IOException ex) {
            social = new SocialMedia();
        }
    try{
     
       allReviews = MapToObject.getListOfReviews(DatabaseTable.EVENT_REVIEW);
          for(Map<String,String> currReview : allReviews)
           {
              if(eventID == Integer.parseInt(currReview.get("PARENT_EVENT_ID")))
              {
                  reviewsList.add(ConvertEventReview(currReview));
              }
           }
        
    }
    catch(Exception ex)
    {
        System.out.println("No Reviews for event");
    }
    
    try{
        
    allEvents = MapToObject.getListOfReviews(DatabaseTable.CHILD_EVENT);
    for(Map<String,String> currEvent: allEvents)
    {
      if(eventID.equals(Integer.parseInt(currEvent.get("PARENT_EVENT_ID"))))
      {
          childEvents.add(ConvertEvent(currEvent));
      }
             
    }
    }
    catch(Exception ex)
    {
        System.out.println("No child events for this parent event");
    }
    
   


    ParentEvent parentEvent = new ParentEvent(eventID, social, name, description, reviewsList, childEvents);

    return parentEvent;    
}
        

}
