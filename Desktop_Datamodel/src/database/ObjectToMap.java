package database;

import bookings.CustomerBooking;
import bookings.GuestBooking;
import bookings.IBooking;
import bookings.IOrder;
import events.IArtist;
import events.IChildEvent;
import events.IParentEvent;
import events.IVenue;
import events.SocialMedia;
import java.awt.image.BufferedImage;
import people.Customer;
import people.ICustomer;
import people.IUser;
import tickets.ITicket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 *
 */
final class ObjectToMap {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);


    public static Map<String, String> customerBookingToMap(CustomerBooking booking) {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("BOOKING_ID",Integer.toString(booking.getBookingID()));
        returnMap.put("TICKET_ID", Integer.toString(booking.getTicketID()));
        returnMap.put("ORDER_ID",Integer.toString(booking.getOrder().getOrderID()));
        returnMap.put("BOOKING_QUANTITY",Integer.toString(booking.getQuantity()));
        returnMap.put("BOOKING_DATE_TIME",booking.getBookingTime().toString());
        return returnMap;
    }

    public static Map<String, String> customerToMap(IUser customer) {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("CUSTOMER_ID",Integer.toString(customer.getID()));
        returnMap.put("CUSTOMER_FIRST_NAME",customer.getFirstName());
        returnMap.put("CUSTOMER_LAST_NAME",customer.getLastName());
        returnMap.put("CUSTOMER_EMAIL",customer.getEmail());
        returnMap.put("CUSTOMER_ADDRESS", customer.getAddress());
        returnMap.put("CUSTOMER_POSTCODE",customer.getPostcode());
        //May need to add password depending on where the registration is taking place.
        return returnMap;
    }

    public static Map<String, String> orderToMap(IOrder order) {
        Map<String,String> orderMap = new HashMap<>();
        orderMap.put("ORDER_ID", Integer.toString(order.getOrderID()));
        orderMap.put("CUSTOMER_ID", Integer.toString(order.getUserID()));
        return orderMap;
    }

    public static Map<String, String> artistToMap(IArtist artist) {
        Map<String,String> returnMap = new HashMap<>();
        String tags = "";

        if(artist.getTags() != null) {
            for (String currTag : artist.getTags()) {
                tags += currTag + ",";
            }
            tags = tags.substring(0, tags.length() - 1);

        }
        if(artist.getSocialId() == null)
        {
            returnMap.put("SOCIAL_MEDIA_ID","");
        }
        else
        {
            returnMap.put("SOCIAL_MEDIA_ID",Integer.toString(artist.getSocialId()));
        }
        returnMap.put("ARTIST_ID",Integer.toString(artist.getID()));
        returnMap.put("ARTIST_NAME",artist.getName());
        returnMap.put("ARTIST_TAGS",tags);
        returnMap.put("ARTIST_DESCRIPTION",artist.getDescription());

        if(artist.getTypeID() == null)
        {
            returnMap.put("ARTIST_TYPE_ID","");
        }
        else {
            returnMap.put("ARTIST_TYPE_ID", Integer.toString(artist.getTypeID()));
        }




        return returnMap;
    }

    public static Map<String, String> socialMediaToMap(SocialMedia socialMedia) {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("SOCIAL_MEDIA_ID", Integer.toString(socialMedia.getSocialId()));
        List<BufferedImage> images = socialMedia.getImages();
        for (int i = 0; i < 6; i++) { // IMAGE,IMAGE1,IMAGE2... 5
            String imgKey = "IMAGE";
            String imgValue = "";
            if (images.get(i) != null) {
                imgValue = images.get(i).toString();
            }
            if (i != 0) {
                imgKey += Integer.toString(i);
            }
            returnMap.put(imgKey, imgValue);
        }
        String fb, insta, tw, sc, www, sp;
        if (socialMedia.getFacebook() == null)
            fb = "";
        else
            fb = socialMedia.getFacebook();
        if (socialMedia.getInstagram() == null)
            insta = "";
        else
            insta = socialMedia.getInstagram();
        if (socialMedia.getTwitter() == null)
            tw = "";
        else
            tw = socialMedia.getTwitter();
        if (socialMedia.getSoundcloud() == null)
            sc = "";
        else
            sc = socialMedia.getSoundcloud();
        if (socialMedia.getWebsite() == null)
            www = "";
        else
            www = socialMedia.getWebsite();
        if (socialMedia.getSpotify() == null)
            sp = "";
        else
            sp = socialMedia.getSpotify();

        returnMap.put("FACEBOOK", fb);
        returnMap.put("TWITTER", tw);
        returnMap.put("INSTAGRAM", insta);
        returnMap.put("SOUNDCLOUD", sc);
        returnMap.put("WEBSITE", www);
        returnMap.put("SPOTIFY", sp);
        return returnMap;
    }

    public static Map<String, String> parentEventToMap(IParentEvent parentEvent) {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("PARENT_EVENT_ID",Integer.toString(parentEvent.getID()));
        returnMap.put("PARENT_EVENT_NAME",parentEvent.getName());
        returnMap.put("PARENT_EVENT_DESCRIPTION",parentEvent.getDescription());
        returnMap.put("SOCIAL_MEDIA_ID",Integer.toString(parentEvent.getSocialId()));
        return returnMap;
    }

    public static Map<String, String> childEventToMap(IChildEvent childEvent) {
        Map<String,String> returnMap = new HashMap<>();
        returnMap.put("CHILD_EVENT_ID", Integer.toString(childEvent.getID()));
        returnMap.put("CHILD_EVENT_NAME",childEvent.getName());
        returnMap.put("PARENT_EVENT_ID",Integer.toString(childEvent.getParentEventID()));
        returnMap.put("VENUE_ID",Integer.toString(childEvent.getVenueID()));
        returnMap.put("CHILD_EVENT_DESCRIPTION", childEvent.getDescription());
        returnMap.put("START_DATE_TIME", formatter.format(childEvent.getStartDateTime()));
        returnMap.put("END_DATE_TIME", formatter.format(childEvent.getEndDateTime()));
        return returnMap;
    }

    public static Map<String, String> ticketToMap(ITicket ticket) {
        Map<String,String> ticketMap = new HashMap<>();
        ticketMap.put("TICKET_ID", Integer.toString(ticket.getID()));
        ticketMap.put("TICKET_PRICE", Double.toString(ticket.getPrice()));
        ticketMap.put("TICKET_DESCRIPTION", ticket.getDescription());
        ticketMap.put("TICKET_TYPE", ticket.getType());
        ticketMap.put("CHILDEVENT_ID", Integer.toString(ticket.getChildEventID()));
        return ticketMap;
    }

    public static Map<String, String> venueToMap(IVenue venue) {
        return null;
    }

    public static Map<String, String> guestBookingToMap(GuestBooking guestBooking) {
        return null;
    }


}
