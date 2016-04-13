/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.List;

/**
 *
 * @author 10467841
 */
public interface IArtist {
    
    public Integer getID();
    public String getName();
    public List<String> getTags();
    public Boolean addArtistTag(String tag);
    public Boolean removeArtistTag(String tag);
}
