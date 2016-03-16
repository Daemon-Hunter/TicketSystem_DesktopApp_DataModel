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
}
