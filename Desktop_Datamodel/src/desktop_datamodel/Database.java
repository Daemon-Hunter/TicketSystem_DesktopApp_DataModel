/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 10512691
 */
public class Database {
    
    private Connection connection;
    
    /**
     * Creates a connection to the database located on Larry's Oracle Server.
     * Logs in with our group credentials
     * @return Boolean true if connection created
     */
    public Boolean createConnection() {
        
        try 
        {
            String url      = "jdbc:oracle:thin:@larry.uopnet.plymouth.ac.uk:1521:orcl";
            String username = "PRCS251G";
            String password = "scottmills";
            
            try 
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } 
            catch (ClassNotFoundException ex) 
            {
                System.out.print("Error");
                return false;
            }
            connection = DriverManager.getConnection(url, username, password);
            
            if (connection == null) {
                return false;
            }   else return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Closes the connection
     */
    public void closeConnection() {
        
        try 
        {
            connection.close();
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns the result set of all the artist data.
     * Must open a database connection before calling method, 
     * and close the connection after handling the result.
     * @return ResultSet of all artist data
     */
    public ResultSet getArtistsAll() 
    {
        String sql = "SELECT * FROM \"PRCS251G\".\"ARTIST\"";
        
        return run(sql);
    }
    
    /**
     * Returns the result set of all the customer data.
     * Must open a database connection before calling method, 
     * and close the connection after handling the result.
     * @return ResultSet of all artist data
     */
    public ResultSet getCustomersAll() 
    {
        String sql = "SELECT * FROM \"PRCS251G\".\"CUSTOMER\"";
        
        return run(sql);
    }
    
    public ResultSet getMedia(Integer i) 
    {
        String sql = "SELECT * FROM \"PRCS251G\".\"SOCIAL_MEDIA\" WHERE \"SOCIAL_MEDIA_ID\" = " + i;
        
        return run(sql);
    }
    
    public ResultSet run(String sql) 
    {
        try 
        {
            Statement statement = connection.createStatement();
            // instead use preparedstatement object?
            
            return statement.executeQuery(sql);
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Inserts a single row into the specified table.
     * @param keyValues: Key = column name, Value = value
     * @param tablename: The name of the table to insert data into
     * @return Boolean true if the values are inserted.
     */
    public Boolean insert(String[][] keyValues, String tablename) {
        Boolean inserted = false;
        
        String keys = "";
        String values = "";
        
        for (String[] key : keyValues) {
            
            keys = keys + "," + key[0];
            
            values = values + "','" + key[1];
        }
        
        if (keys.length() > 0) {
            keys = keys.substring(1, keys.length());
            
            System.out.println(keys + "\n");
        }
        if (values.length() > 0) {
            values = values.substring(2, values.length());
            
            System.out.println(values);
        }
        
        String sql = "INSERT INTO " + tablename + " (" + keys + ") VALUES (" + values + "')";
        
        try 
        {
            Statement statement = connection.createStatement();
            // instead use preparedstatement object?
            
            statement.executeQuery(sql);
            inserted = true;
            // FIRE A CHECK TO SEE IF INSERTED = TRUE!
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inserted;
    }
}
