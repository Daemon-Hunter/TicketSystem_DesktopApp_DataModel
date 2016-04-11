/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import datamodel.Artist;
import datamodel.ParentEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dominic
 */
public class APIHandle {
    
    
    public static LinkedList<Artist> getAllArtists()
    {
        LinkedList<Artist> listOfArtists = new LinkedList<>();
        APIConnection artistConn = new APIConnection(DatabaseTable.ARTIST);
        List<Map<String,String>> listOfMaps = artistConn.readAll();        
        
        for(Map<String, String> currMap : listOfMaps)
        {
            listOfArtists.add(MapToObject.ConvertArtist(currMap));
            
        }
        
        return listOfArtists;
    }
    
    
    public static LinkedList<ParentEvent> getAllParentEvents()
    {
      LinkedList<ParentEvent> listOfEvents = new LinkedList<>();
      APIConnection parentEventConn = new APIConnection(DatabaseTable.PARENTEVENT);
      List<Map<String,String>> listOfMaps = parentEventConn.readAll();
      
      for(Map<String,String> currEvent : listOfMaps)
      {
          listOfEvents.add(MapToObject.ConvertParentEvent(currEvent));
      }
      
      
      return listOfEvents;
    }
    
}
    
