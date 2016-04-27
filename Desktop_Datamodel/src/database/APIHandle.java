/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import events.IArtist;
import events.IChildEvent;
import events.IParentEvent;
import events.IVenue;
import people.IAdmin;
import people.ICustomer;
import people.IUser;
import reviews.IReview;
import utilities.HashString;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static database.MapToObject.ConvertAdmin;
import static database.MapToObject.ConvertArtist;
import static database.MapToObject.ConvertArtistReview;
import static database.MapToObject.ConvertArtistType;
import static database.MapToObject.ConvertChildEvent;
import static database.MapToObject.ConvertCustomer;
import static database.MapToObject.ConvertCustomerBooking;
import static database.MapToObject.ConvertGuestBooking;
import static database.MapToObject.ConvertOrder;
import static database.MapToObject.ConvertParentEvent;
import static database.MapToObject.ConvertSocialMedia;
import static database.MapToObject.ConvertTicket;
import static database.MapToObject.ConvertVenue;
import static utilities.HashString.Encrypt;

/**
 *
 */
public final class APIHandle {

    public static IUser isPasswordTrue(String email, String password) throws IOException, IllegalArgumentException {
        Map<String, String> customer = APIConnection.comparePassword(email, Encrypt(password)).get(0);
        if (Integer.parseInt(customer.get("CUSTOMER_ID").toString()) != -1)
            return ConvertCustomer(customer);
        else
            throw new IllegalArgumentException("Email or password is wrong");
    }

    public static Object getSingle(int id, DatabaseTable table) throws IOException{
        Map<String, String> objMap = APIConnection.readSingle(id, table);
        switch (table){
            case ADMIN: MapToObject.ConvertAdmin(objMap);break;
            case ARTIST: MapToObject.ConvertArtist(objMap);break;
            case BOOKING: MapToObject.ConvertCustomerBooking(objMap);break;
            case CUSTOMER: MapToObject.ConvertCustomer(objMap);break;
            case GUEST_BOOKING: MapToObject.ConvertGuestBooking(objMap);break;
            case ORDER: MapToObject.ConvertOrder(objMap);break;
            case PARENT_EVENT: MapToObject.ConvertParentEvent(objMap);break;
            case SOCIAL_MEDIA: MapToObject.ConvertSocialMedia(objMap);break;
            case TICKET: MapToObject.ConvertTicket(objMap);break;
            case VENUE: MapToObject.ConvertVenue(objMap);break;
            default: throw new IllegalArgumentException("These tables are not supported");
        }
        return MapToObject.ConvertArtist(APIConnection.readSingle(id, table));
    }

    public static int registerUser(IUser newUser, String password) throws IOException {
        Map<String, String> customerMap = ObjectToMap.ConvertCustomer(newUser);
        customerMap.put("CUSTOMER_PASSWORD", Encrypt(password));
        return APIConnection.add(customerMap, DatabaseTable.CUSTOMER);
    }


    public static List<IAdmin> getAdmins() throws IOException {

        List<IAdmin> adminList = new LinkedList<>();
        List<Map<String, String>> adminMapList = APIConnection.readAll(DatabaseTable.ADMIN);
        for (Map<String, String> admin : adminMapList) {
            adminList.add(ConvertAdmin(admin));
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
                            parentEvent = ConvertParentEvent(objectMap);
                            parentEvent.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(parentEvent.getID(), DatabaseTable.SOCIAL_MEDIA)));
                            return parentEvent;
                        case VENUE: 
                            IVenue venue;
                            venue = ConvertVenue(objectMap);
                            venue.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(venue.getID(), DatabaseTable.SOCIAL_MEDIA)));
                            return venue;
                        case ARTIST:
                            IArtist artist = ConvertArtist(objectMap);
                            artist.setType(ConvertArtistType(APIConnection.readSingle(artist.getTypeID(), DatabaseTable.ARTIST_TYPE)));
                            artist.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(artist.getID(), DatabaseTable.SOCIAL_MEDIA)));
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
                            artist = ConvertArtist(objectMap);
                            artist.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(artist.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return artist;
                        case PARENT_EVENT:
                            IParentEvent parentEvent;
                            parentEvent = ConvertParentEvent(objectMap);
                            parentEvent.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(parentEvent.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return parentEvent;
                        case VENUE:
                            IVenue venue;
                            venue = ConvertVenue(objectMap);
                            venue.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(venue.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
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
                            return ConvertChildEvent(objectMap, parentID);
                        case ARTIST:
                            IArtist artist = ConvertArtist(objectMap);
                            artist.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(artist.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return artist;
                        case BOOKING:
                            return ConvertCustomerBooking(objectMap);
                        case CUSTOMER:
                            return ConvertCustomer(objectMap);
                        case GUEST_BOOKING:
                            return ConvertGuestBooking(objectMap);
                        case PARENT_EVENT:
                            IParentEvent parentEvent =  ConvertParentEvent(objectMap);
                            parentEvent.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(parentEvent.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                            return parentEvent;
                        case TICKET:
                            return ConvertTicket(objectMap);
                        case VENUE:
                            IVenue venue =  ConvertVenue(objectMap);
                            venue.setSocialMedia(ConvertSocialMedia(APIConnection.readSingle(venue.getSocialId(), DatabaseTable.SOCIAL_MEDIA)));
                        case ORDER:
                            return ConvertOrder(objectMap);
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
            reviewList.add(ConvertArtistReview(reviewsMap));
        }
        return reviewList;
    }
}