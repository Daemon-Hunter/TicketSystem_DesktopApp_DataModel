/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package people;

import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface IPerson extends IDbSubject {
    
    String getName();
    Boolean setName(String name);
    
    String getEmail();
    Boolean setEmail(String email);
}
