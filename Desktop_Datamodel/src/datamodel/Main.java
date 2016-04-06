/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.ArrayList;
import people.Customer;
import people.IUser;
import reviews.IReview;
import reviews.ReviewBase;

/**
 *
 * @author 10512691
 */
public class Main {
    
    public static void sumArraySquared(ArrayList<Integer> input) {
        System.out.println(input.stream()
                                .map(i -> i * i)
                                .reduce(0, (c, i) -> c + i));
    }
    
    public static void printValues(ArrayList<Integer> input) {
        input.forEach(System.out::println);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IUser customer = new Customer("Charlie", "Gillions", "cjgillions@aol.com",
                                "16 Addison Road", "PL48LL");
        
        ReviewBase venue = new Venue(null, "Underground venue near Bristol's Temple Meads",
                0, 1500, false, "Couple of toilets", 20, null, null, null, null, "In:Motion",
                null);
        
        IReview review = venue.createReview(customer.getCustomerID(), 4, 
                                "Pretty good venue to be fair... Been there a few times and "
                                        + "it never fails to be an entertaining night.");
        
        System.out.println("Review Details:\n"
                         + "\tCustomer ID:   " + review.getCustomerID());
        System.out.println("\tReviewbase ID: " + review.getReviewBaseID());
        System.out.println("\tReview body:   " + review.getBody());
        System.out.println("\tUser rating:   " + review.getRating());
        System.out.println("\tReview time:   " + review.getDateTime());
    }
}
