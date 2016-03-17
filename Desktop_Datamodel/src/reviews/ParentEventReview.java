/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviews;

import database.DatabaseTable;

/**
 *
 * @author 10512691
 */
public class ParentEventReview extends Review {
    
    public ParentEventReview() {
        super();
        table = DatabaseTable.EVENTREVIEW;
    }    
}