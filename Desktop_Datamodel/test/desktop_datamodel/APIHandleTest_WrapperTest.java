/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import database.APIConnection;
import database.APIHandle;
import database.DatabaseTable;
import database.MapToObject;
import datamodel.Artist;
import datamodel.ParentEvent;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reviews.ArtistReview;
import reviews.IReview;

/**
 *
 * @author Dominic
 */
public class APIHandleTest_WrapperTest {
    List<Artist> listOfArtists;
    List<ParentEvent> listOfParentEvents;

    public APIHandleTest_WrapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
//        listOfArtists = APIHandle.getAllArtists();
        listOfParentEvents = APIHandle.getAllParentEvents();
      //  System.out.println(listOfArtists.get().getArtistID());
    //   System.out.println(listOfArtists.get(2).getReview(52).getBody());
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public  void testThisOne()
    {
      //  Artist mungo = listOfArtists.get(3);
       // System.out.println(listOfParentEvents.get(0).getSocialId());
    }         
}
