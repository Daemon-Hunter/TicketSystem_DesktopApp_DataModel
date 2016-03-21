/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 10512691
 */
public class Validator {
    
    public Boolean idValidator(Integer id) {
        Pattern idPattern = Pattern.compile("[1-9]{1}[0-9]{0,7}");
        Matcher matcher = idPattern.matcher(id.toString());
        if (matcher.matches()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public Boolean URLValidator(URL url) {
        if (url == null) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean nameValidator(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // May just need to be length.
    public Boolean descriptionValidator(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean capacityValidator(Integer standing) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // May just need to be length.
    public Boolean facilitiesValidator(String facilities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean parkingSpaceValidator(Integer parking) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean emailValidator(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean phoneNumberValidator(String phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Check against other addresses? Cannot have 2 venues at same place?
    public Boolean addressValidator(String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean postcodeValidator(String postcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Boolean tagValidator(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
