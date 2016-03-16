/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 10512691
 */
public class APIConnection {
    
     String URI = "http://xserve.uopnet.plymouth.ac.uk/Modules/INTPROJ/PRCS251G/api/"; // locaton of api
    String table = "";   // table directory name
 
    public APIConnection(DatabaseTable table)
    {
       
        this.table = table.toString();  // sets up new connection with that table name
    }
   
    public boolean delete(int id)
    {
        boolean ableToDelete = false;
        String urlToDelete = URI + table + "/" + Integer.toString(id);
        try{
            URL url = new URL(urlToDelete);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            ableToDelete = true;
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded" );
            connection.setRequestMethod("DELETE");
            connection.connect();
            ableToDelete = true;

        }catch(Exception ex)
        {
        }
        return ableToDelete;
    }
    
    public void add(Map<String,String> mapToAdd)
    {
       String urlToPost = URI + table;  // URL of where to add to the table.
       try{
           URL url = new URL(urlToPost);
           HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           connection.setRequestMethod("POST");
           connection.setRequestProperty("",""); // Do Something Here Dom
           connection.setDoOutput(true);

           try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
               writer.write("CUSTOMER_ID=" +"16");
           }
           
       }catch(Exception x)
       {
           
       }
    }
   
    public List<Map<String,String>> readAll()
    {
            List<Map<String,String>> listOfEntities = new ArrayList<>();
            String urlToGet = URI +  table;
            try{
                URL url = new URL(urlToGet);
            HttpURLConnection connection = (HttpURLConnection)   url.openConnection();    // connect to the url
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/JSON");    // to return in JSON Format
            InputStream data = connection.getInputStream();
                        try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
               
                String inputLine = in.readLine();   // inputValues of the JSON
                inputLine = inputLine.replaceAll("\\[", "");
                inputLine = inputLine.replaceAll("\\]", "");
                String[] objArray = inputLine.split("\\},");
               
                for (int i = 0; i < objArray.length; i++) {
                   
                    Map<String,String> tempMap = new HashMap<>();
                    tempMap = splitJSONString(objArray[i]);
                    listOfEntities.add(tempMap);
                   
                }  
 
                       
            }  
            }catch(Exception e)
            {
                        throw new RuntimeException(e);
 
            }
         
           
            return listOfEntities;
    }
   
    public Map<String,String> readSingle(int id)    // takes in individual id value;
    {
        String urlToGet = URI + table + "/" + Integer.toString(id);     // creation of URL with unique values;  
        Map<String,String> map = new HashMap<>();                       // initilatisation of map which stores keys and values
 
        try{
            URL url = new URL(urlToGet);                        // Create URL Class
            HttpURLConnection connection = (HttpURLConnection)   url.openConnection();    // connect to the url
            connection.setRequestMethod("GET");                     // A GET method is created
            connection.setRequestProperty("Accept", "application/JSON");    // to return in JSON Format
            InputStream data = connection.getInputStream();  // the returning data
           
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
               
                String inputLine = in.readLine();   // inputValues of the JSON
               
                map = splitJSONString(inputLine); // split up the string into a map
            }  
                     connection.disconnect();// disconnect from the URL
            return map; // return the map
        } catch (Exception e) {
        throw new RuntimeException(e);
      }
       
    }
       
   
    private Map<String,String> splitJSONString(String input)
    {
       Map<String,String> map = new HashMap<>();        
       // initilatisation of map which stores keys and values
             String[] splitArray = input.split(","); // split up the string into the different columns
                splitArray[0] = splitArray[0].replaceAll("\\{", "");    // remove the beginning brace
                splitArray[splitArray.length -1] = splitArray[splitArray.length -1 ].replaceAll("\\}", "");// remove the end brace
               
               
                       
                for (int i = 0; i < splitArray.length; i++) {
                    String temp = splitArray[i].replaceAll("\"", ""); // removes quote marks from json string
                    String[] splitString = temp.split(":");     // splits each strig into key and value
                    map.put(splitString[0],splitString[1]); // place values into the Map
                }  
       
                return map;
    }
    
    
    private String createJsonString(Map<String,String> map)
    {
        String strToReturn = "//{";
        
        System.out.print(strToReturn);
        return strToReturn;
    }
}
