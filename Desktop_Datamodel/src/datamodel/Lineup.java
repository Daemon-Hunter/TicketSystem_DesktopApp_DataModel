/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

import database.DatabaseTable;
import java.util.LinkedList;
import java.util.List;
import utilities.observer.IObserver;

/**
 *
 * @author 10512691
 */
public class Lineup implements ILineup {

    private final Integer lineupID;
    private List<IArtist> artistList;
    private List<IObserver> observers;
    private final DatabaseTable table;
    
    public Lineup(Integer ID, List<IArtist> artists) {
        lineupID   = ID;
        artistList = artists;
        observers  = new LinkedList();
        table      = DatabaseTable.LINEUP;
    }
    
    public Lineup() {
        lineupID   = 0;
        artistList = new LinkedList();
        observers  = new LinkedList();
        table      = DatabaseTable.LINEUP;
    }
    
    @Override
    public DatabaseTable getTable() {
        return table;
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> {
            observer.update(this);
        });
//        for (IObserver o : observers) {
//            o.update(this);
//        }
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Cannot register null observer");
        } else {
            if (observers.contains(o)) {
                throw new IllegalArgumentException("Observer already registered");
            } else {
                return observers.add(o);
            }
        }
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        if (o == null) {
            throw new NullPointerException("Cannot remove a null observer");
        } else {
            if (!observers.contains(o)) {
                throw new IllegalArgumentException("Observer isn't already registered");
            } else {
                return observers.remove(o);
            }
        }
    }

    @Override
    public Integer getLineupID() {
        return lineupID;
    }

    @Override
    public List<IArtist> getArtistList() {
        return artistList;
    }

    @Override
    public Boolean addArtist(IArtist artist) {
        if (artist == null) {
            throw new NullPointerException("Cannot add a null artist");
        } else {
            if (artistList.contains(artist)) {
                throw new IllegalArgumentException("Artist already appears in list.");
            } else {
                return artistList.add(artist);
            }
        }
    }

    @Override
    public Boolean removeArtist(IArtist artist) {
        if (artist == null) {
            throw new NullPointerException("Cannot remove a null artist");
        } else {
            if (!artistList.contains(artist)) {
                throw new IllegalArgumentException("Artist doesn't exist in the list.");
            } else {
                return artistList.remove(artist);
            }
        }
    }

    @Override
    public IArtist getArtist(Integer artistID) {
        for (IArtist a : artistList) {
            if (a.getID().equals(artistID)) {
                return a;
            }
        }
        throw new IllegalArgumentException("Artist not contained in list.");
    }
}
