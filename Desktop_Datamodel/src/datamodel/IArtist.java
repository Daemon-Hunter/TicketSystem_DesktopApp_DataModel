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
    
    public Integer getArtistID();
    public String getArtistName();
    public List<String> getArtistTags();
    public String addArtistTag();
    public String removeArtistTag(String tag);
}
