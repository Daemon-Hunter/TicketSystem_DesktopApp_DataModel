/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import people.IUser;

/**
 *
 * @author 10467841
 */
public interface IUserWrapper extends IWrapper {
    public Boolean setUser(IUser user);
    public IUser getUser();
}
