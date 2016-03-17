/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import java.util.Date;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface IReview extends IDbSubject {
    
    Integer getReviewBaseID();
    // Boolean setReviewBaseID(Integer reviewBaseID);
    
    Integer getCustomerID();
    // Boolean setCustomerID(Integer customerID);
    
    Date    getDateTime();
    Boolean setDateTime(Date datetime);
    
    Integer getRating();
    Boolean setRating(Integer rating);
    
    String  getBody();
    Boolean SetBody(String body);
    
    Boolean isVerified();
    Boolean setVerified(Boolean verified);
}
