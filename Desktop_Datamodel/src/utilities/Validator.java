/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import datamodel.ChildEvent;
import java.net.URL;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 10512691
 */
public final class Validator {

    public static Boolean quantityValidator(Integer qty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // date / time shouldn't be before 'time of app launch' or after 'now'
    public static Boolean dateTimeValidator(Date time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean ratingValidator(Integer rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean reviewBodyValidator(String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Validator(){}
    
    public static Boolean idValidator(Integer id) {
        Pattern idPattern = Pattern.compile("[1-9]{1}[0-9]{0,7}");
        Matcher matcher = idPattern.matcher(id.toString());
        return matcher.matches();
    }
    
    public static Boolean URLValidator(String url) {
        return url != null;
    }

    public static Boolean nameValidator(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // May just need to be length.
    public static Boolean descriptionValidator(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean capacityValidator(Integer standing) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // May just need to be length.
    public static Boolean facilitiesValidator(String facilities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean parkingSpaceValidator(Integer parking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static  Boolean emailValidator(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean phoneNumberValidator(String phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Check against other addresses? Cannot have 2 venues at same place?
    public static Boolean addressValidator(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean postcodeValidator(String postcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean tagValidator(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Boolean childEventValidator(ChildEvent childEvent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
