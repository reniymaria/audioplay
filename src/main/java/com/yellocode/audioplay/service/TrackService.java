package com.yellocode.audioplay.service;


import com.yellocode.audioplay.model.Track;

import java.util.List;

public interface TrackService {
    public void addTrack(Track track);

    public void updateTrack(Track track);

    public void removeTrack(int id);

    public Track getTrackById(int id);

    public List<Track> listTracks();
}
