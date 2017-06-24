package com.yellocode.audioplay.dao;


import com.yellocode.audioplay.model.Track;

import java.util.List;

public interface TrackDao {
    void addTrack(Track track);

    void updateTrack(Track track);

    void removeTrack(int id);

    Track getTrackById(int id);

    List<Track> listTracks();
}
