/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import java.util.List;
import utilities.observer.IDbSubject;

/**
 *
 * @author 10512691
 */
public interface ILineup extends IDbSubject {
    
    public Integer getLineupID();
    public List<IArtist> getArtistList();
    public Boolean addArtist(IArtist artist);
    public Boolean removeArtist(IArtist artist);
    public IArtist getArtist(Integer artistID);
    
}
