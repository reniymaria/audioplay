package com.yellocode.audioplay.service;

import com.yellocode.audioplay.dao.TrackDao;
import com.yellocode.audioplay.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackDao trackDao;

    public void setTrackDao(TrackDao trackDao) {
        this.trackDao = trackDao;
    }

    @Override
    public void addTrack(Track track) { this.trackDao.addTrack(track); }

    @Override
    public void updateTrack(Track track) {
        this.trackDao.updateTrack(track);
    }

    @Override
    public void removeTrack(int id) {
        this.trackDao.removeTrack(id);
    }

    @Override
    public Track getTrackById(int id) {
        return this.trackDao.getTrackById(id);
    }

    @Override
    public List<Track> listTracks() {
        return this.trackDao.listTracks();
    }
}
