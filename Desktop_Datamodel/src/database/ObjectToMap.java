package database;

import bookings.CustomerBooking;
import bookings.GuestBooking;
import bookings.IOrder;
import events.IArtist;
import events.IChildEvent;
import events.IParentEvent;
import events.IVenue;
import events.SocialMedia;
import java.awt.image.BufferedImage;
import people.IAdmin;
import people.IUser;
import tickets.ITicket;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import utilities.DecodeImage;

/**
 * The ObjectToMap class is self explanatory.
 * It converts an object to a Map<String, String>.
 *
 * @author Joshua Kellaway
 * @author Dominic Garbett
 */
final class ObjectToMap {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);

    /**
     * Admin to map map.
     *
     * @param admin the admin
     * @return the map
     */
    public static Map<String, String> adminToMap(IAdmin admin) {
        Map<String, String> adminMap = new HashMap<>();
        adminMap.put("ADMIN_ID", Integer.toString(admin.getID()));
        adminMap.put("ADMIN_EMAIL", admin.getEmail());
        adminMap.put("ADMIN_PASSWORD", admin.getPassword());
        return adminMap;
    }

    /**
     * Customer booking to map map.
     *
     * @param booking the booking
     * @return the map
     * @throws IOException the io exception
     */
    public static Map<String, String> customerBookingToMap(CustomerBooking booking) throws IOException {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("BOOKING_ID", Integer.toString(booking.getBookingID()));
        returnMap.put("TICKET_ID", Integer.toString(booking.getTicketID()));
        returnMap.put("ORDER_ID", Integer.toString(booking.getOrderID()));
        returnMap.put("BOOKING_QUANTITY", Integer.toString(booking.getQuantity()));
        returnMap.put("BOOKING_DATE_TIME", formatter.format(booking.getBookingTime()));
        return returnMap;
    }

    /**
     * Customer to map map.
     *
     * @param customer the customer
     * @return the map
     */
    public static Map<String, String> customerToMap(IUser customer) {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("CUSTOMER_ID", Integer.toString(customer.getID()));
        returnMap.put("CUSTOMER_FIRST_NAME", customer.getFirstName());
        returnMap.put("CUSTOMER_LAST_NAME", customer.getLastName());
        returnMap.put("CUSTOMER_EMAIL", customer.getEmail());
        returnMap.put("CUSTOMER_ADDRESS", customer.getAddress());
        returnMap.put("CUSTOMER_POSTCODE", customer.getPostcode());
        returnMap.put("CUSTOMER_PASSWORD", customer.getPassword());
        //May need to add password depending on where the registration is taking place.
        return returnMap;
    }

    /**
     * Order to map map.
     *
     * @param order the order
     * @return the map
     */
    public static Map<String, String> orderToMap(IOrder order) {
        Map<String, String> orderMap = new HashMap<>();
        orderMap.put("ORDER_ID", Integer.toString(order.getOrderID()));
        orderMap.put("CUSTOMER_ID", Integer.toString(order.getUserID()));
        return orderMap;
    }

    /**
     * Artist to map map.
     *
     * @param artist the artist
     * @return the map
     */
    public static Map<String, String> artistToMap(IArtist artist) {
        Map<String, String> returnMap = new HashMap<>();
        String tags = "";

        if (artist.getTags() != null && !artist.getTags().isEmpty()) {
            for (String currTag : artist.getTags()) {
                tags += currTag + ",";
            }
            tags = tags.substring(0, tags.length() - 1);

        }
        if (artist.getSocialId() == null) {
            returnMap.put("SOCIAL_MEDIA_ID", "");
        } else {
            returnMap.put("SOCIAL_MEDIA_ID", Integer.toString(artist.getSocialId()));
        }
        returnMap.put("ARTIST_ID", Integer.toString(artist.getID()));
        returnMap.put("ARTIST_NAME", artist.getName());
        returnMap.put("ARTIST_TAGS", tags);
        returnMap.put("ARTIST_DESCRIPTION", artist.getDescription());

        if (artist.getTypeID() == null) {
            returnMap.put("ARTIST_TYPE_ID", "");
        } else {
            returnMap.put("ARTIST_TYPE_ID", Integer.toString(artist.getTypeID()));
        }


        return returnMap;
    }

    /**
     * Social media to map map.
     *
     * @param socialMedia the social media
     * @return the map
     */
    public static Map<String, String> socialMediaToMap(SocialMedia socialMedia) {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("SOCIAL_MEDIA_ID", Integer.toString(socialMedia.getSocialId()));
        try {
            returnMap.put("SOCIAL_MEDIA_ID", Integer.toString(socialMedia.getSocialId()));
        } catch (NullPointerException ex) {
            returnMap.put("SOCIAL_MEDIA_ID", "0");
        }
        List<BufferedImage> images = socialMedia.getImages();
        String imgKey = "IMAGE";
            String imgValue = "";

        int j = 1;
        for (BufferedImage img : images) {
            if (j == 1) {
                try {
                    returnMap.put(imgKey, DecodeImage.encodeToString(img, "PNG"));
                }
                catch (IOException ex) {
                    returnMap.put(imgKey, imgValue);
                }
            }
            else {
                try {
                    returnMap.put(imgKey + j, DecodeImage.encodeToString(img, "PNG"));
                }
                catch (IOException ex) {
                    returnMap.put(imgKey + j, imgValue);
                }
            }
            j++;
        }

//        for (int i = 0; i < 6; i++) { // IMAGE,IMAGE1,IMAGE2... 5
//            String imgKey = "IMAGE";
//            String imgValue = "";
//            if (images.get(i) != null) {
//                imgValue = images.get(i).toString();
//            }
//            if (i != 0) {
//                imgKey += Integer.toString(i);
//            }
//            returnMap.put(imgKey, imgValue);
//        }
        String fb, insta, tw, sc, www, sp;
        fb = socialMedia.getFacebook();

        insta = socialMedia.getInstagram();

        tw = socialMedia.getTwitter();

        sc = socialMedia.getSoundcloud();

        www = socialMedia.getWebsite();

        sp = socialMedia.getSpotify();

        returnMap.put("FACEBOOK", fb);
        returnMap.put("TWITTER", tw);
        returnMap.put("INSTAGRAM", insta);
        returnMap.put("SOUNDCLOUD", sc);
        returnMap.put("WEBSITE", www);
        returnMap.put("SPOTIFY", sp);
        return returnMap;
    }

    /**
     * Parent event to map map.
     *
     * @param parentEvent the parent event
     * @return the map
     */
    public static Map<String, String> parentEventToMap(IParentEvent parentEvent) {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("PARENT_EVENT_ID", Integer.toString(parentEvent.getID()));
        returnMap.put("PARENT_EVENT_NAME", parentEvent.getName());
        returnMap.put("PARENT_EVENT_DESCRIPTION", parentEvent.getDescription());
        returnMap.put("SOCIAL_MEDIA_ID", Integer.toString(parentEvent.getSocialId()));
        return returnMap;
    }

    /**
     * Child event to map map.
     *
     * @param childEvent the child event
     * @return the map
     */
    public static Map<String, String> childEventToMap(IChildEvent childEvent) {
        Map<String, String> returnMap = new HashMap<>();
        returnMap.put("CHILD_EVENT_ID", Integer.toString(childEvent.getID()));
        returnMap.put("CHILD_EVENT_NAME", childEvent.getName());
        returnMap.put("PARENT_EVENT_ID", Integer.toString(childEvent.getParentEventID()));
        returnMap.put("VENUE_ID", Integer.toString(childEvent.getVenueID()));
        returnMap.put("CHILD_EVENT_DESCRIPTION", childEvent.getDescription());
        returnMap.put("START_DATE_TIME", formatter.format(childEvent.getStartDateTime()));
        returnMap.put("END_DATE_TIME", formatter.format(childEvent.getEndDateTime()));
        return returnMap;
    }

    /**
     * Ticket to map map.
     *
     * @param ticket the ticket
     * @return the map
     */
    public static Map<String, String> ticketToMap(ITicket ticket) {
        Map<String, String> ticketMap = new HashMap<>();
        ticketMap.put("TICKET_ID", Integer.toString(ticket.getID()));
        ticketMap.put("TICKET_PRICE", Double.toString(ticket.getPrice()));
        ticketMap.put("TICKET_DESCRIPTION", ticket.getDescription());
        ticketMap.put("TICKET_TYPE", ticket.getType());
        ticketMap.put("TICKET_AMOUNT_REMAINING", Integer.toString(ticket.getRemaining()));
        ticketMap.put("CHILDEVENT_ID", Integer.toString(ticket.getChildEventID()));
        return ticketMap;
    }

    /**
     * Venue to map map.
     *
     * @param venue the venue
     * @return the map
     */
    public static Map<String, String> venueToMap(IVenue venue) {
        Map<String, String> venueMap = new HashMap<>();
        venueMap.put("VENUE_ID", venue.getID().toString());
        venueMap.put("SOCIAL_MEDIA_ID", venue.getSocialId().toString());
        venueMap.put("VENUE_DESCRIPTION", venue.getDescription());
        venueMap.put("VENUE_CAPACITY_STANDING", venue.getStandingCapacity().toString());
        venueMap.put("VENUE_CAPACTIY_SEATING", venue.getSeatingCapacity().toString());
        venueMap.put("VENUE_DISABLED_ACCESS", venue.getDisabledAccess().toString());
        venueMap.put("VENUE_FACILITES", venue.getFacilites());
        venueMap.put("VENUE_PARKING", venue.getParking().toString());
        venueMap.put("VENUE_PHONE_NUMBER", venue.getPhoneNumber());
        venueMap.put("VENUE_EMAIL", venue.getEmail());
        venueMap.put("VENUE_ADDRESS", venue.getAddress());
        venueMap.put("VENUE_POSTCODE", venue.getPostcode());
        venueMap.put("VENUE_NAME", venue.getName());
        venueMap.put("VENUE_CITY", venue.getCity());
        return venueMap;
    }

    /**
     * Guest booking to map map.
     *
     * @param guestBooking the guest booking
     * @return the map
     */
    public static Map<String, String> guestBookingToMap(GuestBooking guestBooking) {
        Map<String, String> guestBookingMap = new HashMap<>();
        guestBookingMap.put("GUEST_BOOKING_ID", guestBooking.getBookingID().toString());
        guestBookingMap.put("TICKET_ID", guestBooking.getTicketID().toString());
        guestBookingMap.put("GUEST_EMAIL", guestBooking.getGuest().getEmail());
        guestBookingMap.put("GUEST_ADDRESS", guestBooking.getGuest().getAddress());
        guestBookingMap.put("GUEST_POSTCODE", guestBooking.getGuest().getPostcode());
        guestBookingMap.put("GUEST_BOOKING_QUANTITY", guestBooking.getQuantity().toString());
        guestBookingMap.put("GUEST_BOOKING_DATE_TIME", formatter.format(guestBooking.getBookingTime()));
        return guestBookingMap;
    }
}

