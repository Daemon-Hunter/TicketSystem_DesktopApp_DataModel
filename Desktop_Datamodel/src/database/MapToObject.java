/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bookings.CustomerBooking;
import bookings.GuestBooking;
import bookings.IBooking;
import bookings.IOrder;
import bookings.Order;
import events.Artist;
import events.ChildEvent;
import events.IChildEvent;
import events.IParentEvent;
import events.IVenue;
import events.ParentEvent;
import events.SocialMedia;
import events.Venue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import people.Admin;
import people.Customer;
import people.Guest;
import people.IAdmin;
import people.IUser;
import reviews.ArtistReviewFactory;
import reviews.IReview;
import reviews.IReviewFactory;
import reviews.ParentEventReviewFactory;
import reviews.VenueReviewFactory;
import tickets.ITicket;
import tickets.Ticket;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.lang.Integer.parseInt;
import javax.imageio.ImageIO;
import static javax.xml.bind.DatatypeConverter.parseBase64Binary;

/**
 *
 *
 */
final class MapToObject {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);

    public static IUser MapToCustomer(Map<String, String> custMap) {
        String firstName, lastName, address, email, postcode;
        int ID = Integer.parseInt(custMap.get("CUSTOMER_ID"));

        firstName = custMap.get("CUSTOMER_FIRST_NAME");
        lastName = custMap.get("CUSTOMER_LAST_NAME");
        address = custMap.get("CUSTOMER_ADDRESS");
        email = custMap.get("CUSTOMER_EMAIL");
        postcode = custMap.get("CUSTOMER_POSTCODE");

        return new Customer(ID, firstName, lastName, email, address, postcode);
    }

    public static Artist MapToArtist(Map<String, String> artistMap) {

        Integer ID = Integer.parseInt(artistMap.get("ARTIST_ID"));
        String name = artistMap.get("ARTIST_NAME");
        String tags = artistMap.get("ARTIST_TAGS");
        String[] tempArr = tags.split(",");
        String description = artistMap.get("ARTIST_DESCRIPTION");
        Integer socialID = Integer.parseInt(artistMap.get("SOCIAL_MEDIA_ID"));
        Integer type = Integer.parseInt(artistMap.get("ARTIST_TYPE_ID"));

        LinkedList<String> listOfTags = new LinkedList<>();
        listOfTags.addAll(Arrays.asList(tempArr));

        return new Artist(ID, name, description, listOfTags, socialID, type);
    }

    public static String MapToArtistType(Map<String, String> artistTypeMap) {
        return artistTypeMap.get("ARTIST_TYPE1");
    }

    public static SocialMedia MapToSocialMedia(Map<String, String> socialMap) throws IOException {
        Integer socialMediaID;
        String facebook, twitter, instagram, soundcloud, website, spotify;
        byte[] decodedBytes;
        List<BufferedImage> images = new LinkedList<>();

        socialMediaID = Integer.parseInt(socialMap.get("SOCIAL_MEDIA_ID"));
        facebook = socialMap.get("FACEBOOK");
        if (facebook.equals("null") || facebook.equals("")) {
            facebook = null;
        }
        twitter = socialMap.get("TWITTER");
        if (twitter.equals("null") || twitter.equals("")) {
            twitter = null;
        }
        instagram = socialMap.get("INSTAGRAM");
        if (instagram.equals("null") || instagram.equals("")) {
            instagram = null;
        }
        soundcloud = socialMap.get("SOUNDCLOUD");
        if (soundcloud.equals("null") || soundcloud.equals("")) {
            soundcloud = null;
        }
        website = socialMap.get("WEBSITE");
        if (website.equals("null") || website.equals("")) {
            website = null;
        }
        spotify = socialMap.get("SPOTIFY");
        if (spotify.equals("null") || spotify.equals("")) {
            spotify = null;
        }
        images.add(ImageIO.read(new ByteArrayInputStream(parseBase64Binary(socialMap.get("IMAGE")))));
        images.add(ImageIO.read(new ByteArrayInputStream(parseBase64Binary(socialMap.get("IMAGE2")))));
        images.add(ImageIO.read(new ByteArrayInputStream(parseBase64Binary(socialMap.get("IMAGE3")))));
        images.add(ImageIO.read(new ByteArrayInputStream(parseBase64Binary(socialMap.get("IMAGE4")))));
        images.add(ImageIO.read(new ByteArrayInputStream(parseBase64Binary(socialMap.get("IMAGE5")))));

        return new SocialMedia(socialMediaID, images, facebook, twitter, instagram, soundcloud, website, spotify);
    }

    public static IReview MapToArtistReview(Map<String, String> reviewMap) {

        ArtistReviewFactory factory = new ArtistReviewFactory();

        Integer artistID = Integer.parseInt(reviewMap.get("ARTIST_ID"));
        Integer customerID = Integer.parseInt(reviewMap.get("CUSTOMER_ID"));
        Integer rating = Integer.parseInt(reviewMap.get("ARTIST_REVIEW_RATING"));
        String body = reviewMap.get("ARTIST_REVIEW_BODY");
        Date dateTime = new Date();
        Boolean verified = reviewMap.get("ARTIST_REVIEW_VERIFIED").equals("true");

        try {
            dateTime = formatter.parse(reviewMap.get("ARTIST_REVIEW_DATE_TIME"));
        } catch (ParseException ex) {
            System.err.println(ex.toString());
        }

        return factory.createReview(artistID, customerID, rating, dateTime, body, verified);
    }

    public static IReview MapToVenueReview(Map<String, String> reviewMap, DatabaseTable table) {

        IReviewFactory factory;
        if (table == DatabaseTable.VENUE) factory = new VenueReviewFactory();
        else if (table == DatabaseTable.ARTIST) factory = new ArtistReviewFactory();
        else if (table == DatabaseTable.PARENT_EVENT_REVIEW)
            factory = new ParentEventReviewFactory();
        else throw new IllegalArgumentException(table.toString() + " is not a valid table.");

        String sTable = table.toString().toUpperCase();

        Integer ID = Integer.parseInt(reviewMap.get(sTable + "_ID"));
        Integer customerID = Integer.parseInt(reviewMap.get("CUSTOMER_ID"));
        Integer rating = Integer.parseInt(reviewMap.get(sTable + "_RATING"));
        String body = reviewMap.get(sTable + "_BODY");
        Date dateTime = new Date();
        Boolean verified;

        verified = reviewMap.get(sTable + "_VERIFIED").equals("true");

        try {
            dateTime = formatter.parse(reviewMap.get(sTable + "_DATE_TIME"));
        } catch (ParseException ex) {
            System.err.println(ex.toString());
        }

        return factory.createReview(ID, customerID, rating, dateTime, body, verified);

    }

    public static IReview MapToParentEventEventReview(Map<String, String> reviewMap) {

        ParentEventReviewFactory factory = new ParentEventReviewFactory();

        Integer eventID = Integer.parseInt(reviewMap.get("PARENT_EVENT_ID"));
        Integer customerID = Integer.parseInt(reviewMap.get("CUSTOMER_ID"));
        Integer rating = Integer.parseInt(reviewMap.get("EVENT_REVIEW_RATING"));
        String body = reviewMap.get("EVENT_REVIEW_BODY");
        Date dateTime = new Date();
        Boolean verified;

        verified = reviewMap.get("EVENT_REVIEW_VERIFIED").equals("true");

        try {
            dateTime = formatter.parse(reviewMap.get("EVENT_REVIEW_DATE_TIME"));
        } catch (ParseException ex) {
            System.err.println(ex.toString());
        }

        return factory.createReview(eventID, customerID, rating, dateTime, body, verified);
    }

    public static IVenue MapToVenue(Map<String, String> venueMap) {

        Integer venueID, capSeating, capStanding, parking, socialMediaID;
        String description, facilities, phoneNumber, email, address, city, postcode, name;
        Boolean disabledAccess;

        venueID = Integer.parseInt(venueMap.get("VENUE_ID"));
        description = venueMap.get("VENUE_DESCRIPTION");
        capSeating = Integer.parseInt(venueMap.get("VENUE_CAPACITY_SEATING"));
        capStanding = Integer.parseInt(venueMap.get("VENUE_CAPACITY_STANDING"));
        parking = Integer.parseInt(venueMap.get("VENUE_PARKING"));
        facilities = venueMap.get("VENUE_FACILITES");
        phoneNumber = venueMap.get("VENUE_PHONE_NUMBER");
        email = venueMap.get("VENUE_EMAIL");
        address = venueMap.get("VENUE_ADDRESS");
        city = venueMap.get("VENUE_CITY");
        postcode = venueMap.get("VENUE_POSTCODE");
        name = venueMap.get("VENUE_NAME");
        socialMediaID = Integer.parseInt(venueMap.get("SOCIAL_MEDIA_ID"));

        disabledAccess = venueMap.get("VENUE_DISABLED_ACCESS").equals("true");


        return new Venue(venueID, socialMediaID, description, capSeating, capStanding, disabledAccess, facilities, parking, phoneNumber, email, address, city, postcode, name);
    }

    public static ITicket MapToTicket(Map<String, String> ticketMap) {
        Integer ticketID, remaining, childEventID;
        Double price;
        String desc, type;

        ticketID = Integer.parseInt(ticketMap.get("TICKET_ID"));
        price = Double.parseDouble(ticketMap.get("TICKET_PRICE"));
        remaining = Integer.parseInt(ticketMap.get("TICKET_AMOUNT_REMAINING"));
        type = ticketMap.get("TICKET_TYPE");
        desc = ticketMap.get("TICKET_DESCRIPTION");
        childEventID = Integer.parseInt(ticketMap.get("CHILDEVENT_ID"));

        return new Ticket(ticketID, childEventID, price, desc, remaining, type);
    }

    public static IChildEvent MapToChildEvent(Map<String, String> childEventMap) throws IOException {

        Integer childEventID, venueID, parentEventID;
        String description, name;
        String startTime;
        String endTime;
        Boolean cancelled = false;

        childEventID = Integer.parseInt(childEventMap.get("CHILD_EVENT_ID"));
        parentEventID = Integer.parseInt(childEventMap.get("PARENT_EVENT_ID"));
        venueID = Integer.parseInt(childEventMap.get("VENUE_ID"));
        name = childEventMap.get("CHILD_EVENT_NAME");
        description = childEventMap.get("CHILD_EVENT_DESCRIPTION");

        if (childEventMap.get("CHILD_EVENT_CANCELED").equals("true")) cancelled = true;
        startTime = childEventMap.get("START_DATE_TIME");
        endTime = childEventMap.get("END_DATE_TIME");
        return new ChildEvent(childEventID, venueID, name, description, startTime, endTime, cancelled, parentEventID);
    }

    public static IBooking MapToCustomerBooking(Map<String, String> bookingMap) {
        Integer bookingID, quantity, ticketID, orderID;
        String date;

        bookingID = Integer.parseInt(bookingMap.get("BOOKING_ID"));
        quantity = Integer.parseInt(bookingMap.get("BOOKING_QUANTITY"));
        ticketID = Integer.parseInt(bookingMap.get("TICKET_ID"));
        orderID = Integer.parseInt(bookingMap.get("ORDER_ID"));
         date = bookingMap.get("BOOKING_DATE_TIME");

        return new CustomerBooking(bookingID, ticketID, orderID, quantity, date);
    }

    public static IOrder MapToOrder(Map<String, String> orderMap) {

        Integer orderID, userID;

        orderID = parseInt(orderMap.get("ORDER_ID"));
        userID = parseInt(orderMap.get("CUSTOMER_ID"));

        return new Order(orderID, userID);
    }

    public static IBooking MapToGuestBooking(Map<String, String> bookingMap) {
        Integer bookingID, ticketID, quantity;
        String email, address, postcode, dateTime;

        bookingID = Integer.parseInt(bookingMap.get("GUEST_BOOKING_ID"));
        ticketID = Integer.parseInt(bookingMap.get("TICKET_ID"));
        quantity = Integer.parseInt(bookingMap.get("GUEST_BOOKING_QUANTITY"));
        email = bookingMap.get("GUEST_EMAIL");
        address = bookingMap.get("GUEST_ADDRESS");
        postcode = bookingMap.get("GUEST_POSTCODE");
        dateTime = bookingMap.get("GUEST_BOOKING_DATE_TIME");

        return new GuestBooking(bookingID, ticketID, quantity, dateTime, new Guest(email, address, postcode));
    }

    public static IParentEvent MapToParentEvent(Map<String, String> eventMap) {
        Integer eventID, socialMediaID;
        String name, description;

        eventID = Integer.parseInt(eventMap.get("PARENT_EVENT_ID"));
        name = eventMap.get("PARENT_EVENT_NAME");
        description = eventMap.get("PARENT_EVENT_DESCRIPTION");
        socialMediaID = Integer.parseInt(eventMap.get("SOCIAL_MEDIA_ID"));

        return new ParentEvent(eventID, socialMediaID, name, description);
    }

    public static IAdmin MapToAdmin(Map<String, String> adminMap) {
        Integer adminID = Integer.parseInt(adminMap.get("ADMIN_ID"));
        String email = adminMap.get("ADMIN_EMAIL");

        return new Admin(adminID, "ADMIN", "ADMIN", email);
    }

    public static Integer[] MapToContract(Map<String, String> contractMap) {
        Integer artistID = Integer.parseInt(contractMap.get("ADMIN_ID"));
        Integer child_event_id = Integer.parseInt(contractMap.get("CHILD_EVENT_ID"));
        return new Integer[]{artistID, child_event_id};
    }
}
