/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import java.util.List;

/**
 *
 * @author 10512691
 */
public class Artist {
    public Integer artistID;
    public String name;
    public List<String> tags;
    List<ArtistReview> reviews;
    public SocialMedia social;
    
    public Artist(Integer id, String name, List<String> tags, SocialMedia soc) {
        artistID = id;
        this.name = name;
        this.tags = tags;
        social = soc;
    }
}
