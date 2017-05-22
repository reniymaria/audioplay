package com.yellocode.audioplay.service;

import com.yellocode.audioplay.dao.TrackDao;
import com.yellocode.audioplay.model.Track;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TrackServiceImpl implements TrackService {
    private TrackDao trackDao;

    public void setTrackDao(TrackDao trackDao) {
        this.trackDao = trackDao;
    }

    @Override
    @Transactional
    public void addTrack(Track track) { this.trackDao.addTrack(track); }

    @Override
    @Transactional
    public void updateTrack(Track track) {
        this.trackDao.updateTrack(track);
    }

    @Override
    @Transactional
    public void removeTrack(int id) {
        this.trackDao.removeTrack(id);
    }

    @Override
    @Transactional
    public Track getTrackById(int id) {
        return this.trackDao.getTrackById(id);
    }

    @Override
    @Transactional
    public List<Track> listTracks() {
        return this.trackDao.listTracks();
    }
}
