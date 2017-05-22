package com.yellocode.audioplay.dao;


import com.yellocode.audioplay.model.Track;

import java.util.List;

public interface TrackDao {
    public void addTrack(Track track);

    public void updateTrack(Track track);

    public void removeTrack(int id);

    public Track getTrackById(int id);

    public List<Track> listTracks();
}
