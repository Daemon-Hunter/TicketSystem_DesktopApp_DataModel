/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import bookings.CustomerBooking;
import bookings.GuestBooking;
import bookings.IOrder;
import events.IArtist;
import events.IChildEvent;
import events.IParentEvent;
import events.IVenue;
import events.SocialMedia;
import people.IAdmin;
import people.IUser;
import reviews.IReview;
import tickets.ITicket;
import utilities.observer.IObserver;
import utilities.observer.ISubject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static database.MapToObject.MapToAdmin;
import static database.MapToObject.MapToArtist;
import static database.MapToObject.MapToArtistReview;
import static database.MapToObject.MapToArtistType;
import static database.MapToObject.MapToChildEvent;
import static database.MapToObject.MapToCustomer;
import static database.MapToObject.MapToCustomerBooking;
import static database.MapToObject.MapToGuestBooking;
import static database.MapToObject.MapToOrder;
import static database.MapToObject.MapToParentEvent;
import static database.MapToObject.MapToSocialMedia;
import static database.MapToObject.MapToTicket;
import static database.MapToObject.MapToVenue;
import static database.ObjectToMap.artistToMap;
import static database.ObjectToMap.childEventToMap;
import static database.ObjectToMap.customerBookingToMap;
import static database.ObjectToMap.customerToMap;
import static database.ObjectToMap.guestBookingToMap;
import static database.ObjectToMap.orderToMap;
import static database.ObjectToMap.parentEventToMap;
import static database.ObjectToMap.socialMediaToMap;
import static database.ObjectToMap.ticketToMap;
import static database.ObjectToMap.venueToMap;
import static utilities.HashString.Encrypt;

/**
 *
 */
public final class APIHandle implements IObserver{

    public static List<IUser> getUsers() throws IOException {

           List<IUser> userList = new LinkedList<>();
           List<Map<String, String>> userMapList = APIConnection.readAll(DatabaseTable.CUSTOMER);
           for (Map<String, String> user : userMapList) {
                 userList.add(MapToCustomer(user));
            }
            return userList;
        }

    public static IUser isPasswordTrue(String email, String password) throws IOException, IllegalArgumentException {
        Map<String, String> customer = APIConnection.comparePassword(email, Encrypt(password)).get(0);
        if (Integer.parseInt(customer.get("CUSTOMER_ID").toString()) != -1)
            return MapToCustomer(customer);
        else
            throw new IllegalArgumentException("Email or password is wrong");
    }

    public static Object getSingle(int id, DatabaseTable table) throws IOException{
        Map<String, String> objMap = APIConnection.readSingle(id, table);
        switch (table){
            case ADMIN: return MapToObject.MapToAdmin(objMap);
            case BOOKING: return MapToObject.MapToCustomerBooking(objMap);
            case CUSTOMER: return MapToObject.MapToCustomer(objMap);
            case GUEST_BOOKING: return MapToObject.MapToGuestBooking(objMap);
            case ORDER: return MapToObject.MapToOrder(objMap);
            case SOCIAL_MEDIA: return MapToObject.MapToSocialMedia(objMap);
            case TICKET: return MapToObject.MapToTicket(objMap);
            case PARENT_EVENT:
                IParentEvent parentEvent;
                parentEvent = MapToParentEvent(objMap);
                parentEvent.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(parentEvent.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                return parentEvent;
            case VENUE:
                IVenue venue;
                venue = MapToVenue(objMap);
                venue.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(venue.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                return venue;
            case ARTIST:
                IArtist artist = MapToArtist(objMap);
                artist.setType(MapToArtistType(APIConnection.readSingle(artist.getTypeID(), DatabaseTable.ARTIST_TYPE)));
                artist.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(artist.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                return artist;
            default: throw new IllegalArgumentException("These tables are not supported");
        }
    }

    public static int registerUser(IUser newUser, String password) throws IOException {
        Map<String, String> customerMap = ObjectToMap.customerToMap(newUser);
        customerMap.put("CUSTOMER_PASSWORD", Encrypt(password));
        return APIConnection.add(customerMap, DatabaseTable.CUSTOMER);
    }

    public static List<IAdmin> getAdmins() throws IOException {

        List<IAdmin> adminList = new LinkedList<>();
        List<Map<String, String>> adminMapList = APIConnection.readAll(DatabaseTable.ADMIN);
        for (Map<String, String> admin : adminMapList) {
            adminList.add(MapToAdmin(admin));
        }
        return adminList;
    }


    public static List<Object> searchObjects(String search, final DatabaseTable table) throws IOException {
        List<Object> objectList = new LinkedList<>();
        List<Map<String, String>> objectMapList = APIConnection.search(search, table);

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(threads);
        List<Future<Object>> futures = new LinkedList<>();

        for (final Map<String, String> objectMap : objectMapList){
            Callable<Object> callable = new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    switch (table){
                        case PARENT_EVENT:
                            IParentEvent parentEvent;
                            parentEvent = MapToParentEvent(objectMap);
                            parentEvent.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(parentEvent.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return parentEvent;
                        case VENUE:
                            IVenue venue;
                            venue = MapToVenue(objectMap);
                            venue.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(venue.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return venue;
                        case ARTIST:
                            IArtist artist = MapToArtist(objectMap);
                            artist.setType(MapToArtistType(APIConnection.readSingle(artist.getTypeID(), DatabaseTable.ARTIST_TYPE)));
                            artist.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(artist.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return artist;
                        default: throw new IllegalArgumentException();
                    }
                }
            };
            futures.add(service.submit(callable));
        }
        service.shutdown();

        for (Future<Object> future : futures){
            try {
                objectList.add(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return objectList;
    }

    public static List<Object> getObjectAmount(Integer amount, Integer lastID, final DatabaseTable table) throws IOException {

        List<Object> objectList = new LinkedList<>();

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(threads);
        List<Future<Object>> futures = new LinkedList<>();

        List<Map<String, String>> objectMapList = APIConnection.readAmount(table, amount, lastID);


        for (final Map<String, String> objectMap : objectMapList) {
            Callable<Object> callable = new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    switch (table){
                        case ARTIST:
                            IArtist artist;
                            artist = MapToArtist(objectMap);
                            artist.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(artist.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            artist.setType(MapToArtistType(APIConnection.readSingle(artist.getTypeID(), DatabaseTable.ARTIST_TYPE)));
                            return artist;
                        case PARENT_EVENT:
                            IParentEvent parentEvent;
                            parentEvent = MapToParentEvent(objectMap);
                            parentEvent.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(parentEvent.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return parentEvent;
                        case VENUE:
                            IVenue venue;
                            venue = MapToVenue(objectMap);
                            venue.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(venue.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return venue;
                        default: throw new IllegalArgumentException();
                    }

                }
            };

            futures.add(service.submit(callable));
        }

        service.shutdown();

        for (Future<Object> future : futures){
            try {
                objectList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return objectList;
    }

    public static List<Object> getObjectsFromObject(final int parentID, final DatabaseTable objectsToGet, DatabaseTable object) throws IOException {
        List<Map<String, String>> objectMapList = APIConnection.getObjectsOfObject(parentID, objectsToGet, object);
        List<Object> objectList = new LinkedList<>();

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(threads);
        List<Future<Object>> futures = new LinkedList<>();

        for (final Map<String, String> objectMap : objectMapList){
            Callable<Object> callable = new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    switch (objectsToGet){
                        case CHILD_EVENT:
                            IChildEvent childEvent = MapToChildEvent(objectMap, parentID);
                            childEvent.getParentEvent();
                            return childEvent;
                        case ARTIST:
                            IArtist artist = MapToArtist(objectMap);
                            artist.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(artist.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return artist;
                        case BOOKING:
                            return MapToCustomerBooking(objectMap);
                        case CUSTOMER:
                            return MapToCustomer(objectMap);
                        case GUEST_BOOKING:
                            return MapToGuestBooking(objectMap);
                        case PARENT_EVENT:
                            IParentEvent parentEvent =  MapToParentEvent(objectMap);
                            parentEvent.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(parentEvent.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return parentEvent;
                        case TICKET:
                            return MapToTicket(objectMap);
                        case VENUE:
                            IVenue venue =  MapToVenue(objectMap);
                            venue.setSocialMedia(MapToSocialMedia(APIConnection.readSingle(venue.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                        case ORDER:
                            return MapToOrder(objectMap);
                        default: throw new IllegalArgumentException();
                    }
                }
            };
            futures.add(service.submit(callable));
        }

        service.shutdown();

        for (Future<Object> future : futures){
            try {
                objectList.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        return objectList;
    }

    private static List<IReview> getObjectsReviews(Integer objectID, DatabaseTable table) throws IOException {
        List<IReview> reviewList = new LinkedList<>();
        List<Map<String, String>> reviewMapList = APIConnection.readObjectsReviews(table, objectID);
        for (Map<String, String> reviewsMap : reviewMapList){
            reviewList.add(MapToArtistReview(reviewsMap));
        }
        return reviewList;
    }

    public static Integer pushObjectToDatabase(Object object, DatabaseTable table) throws IOException{
        Map<String, String> objectMap;
        switch (table){
//            case ADMIN:
//                //objectMap = AdminToMap
//                break;
            case ARTIST:
                IArtist artist = (IArtist) object;
                artist.setSocialId(pushObjectToDatabase(artist.getSocialMedia(), DatabaseTable.SOCIAL_MEDIA));
                objectMap = artistToMap((IArtist) object);
                break;
//            case ARTIST_TYPE:
//                //objectMap = artistTypeToMap();
//            case ARTIST_REVIEW:
//                break;
            case BOOKING:
                objectMap = customerBookingToMap((CustomerBooking) object);
                break;
            case CHILD_EVENT:
                objectMap = childEventToMap((IChildEvent) object);
                break;
            case CUSTOMER:
                objectMap = customerToMap((IUser) object);
                break;
//            case CONTRACTS:
//                break;
//            case PARENT_EVENT_REVIEW:
//                break;
            case GUEST_BOOKING:
                objectMap = guestBookingToMap((GuestBooking) object);
                break;
            case PARENT_EVENT:
                IParentEvent parentEvent = (IParentEvent) object;
                parentEvent.setSocialId(pushObjectToDatabase(parentEvent.getSocialMedia(), DatabaseTable.SOCIAL_MEDIA));
                objectMap = parentEventToMap((IParentEvent) object);
                break;
            case SOCIAL_MEDIA:
                objectMap = socialMediaToMap((SocialMedia) object);
                break;
            case TICKET:
                objectMap = ticketToMap((ITicket) object);
                break;
            case VENUE:
                IVenue venue = (IVenue) object;
                venue.setSocialId(pushObjectToDatabase(venue.getSocialMedia(), DatabaseTable.SOCIAL_MEDIA));
                objectMap = venueToMap(venue);
                break;
//            case VENUE_REVIEW:
//                break;
            case ORDER:
                objectMap = orderToMap((IOrder) object);
                break;
            default: throw new IllegalArgumentException("Not supported table.");
        }

        return APIConnection.add(objectMap, table);
    }

    @Override
    public void update(ISubject object, DatabaseTable table) throws IOException {
        pushObjectToDatabase(object, table);
    }
}
