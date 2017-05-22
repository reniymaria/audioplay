package com.yellocode.audioplay.dao;


import com.yellocode.audioplay.model.Track;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TrackDaoImpl implements TrackDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addTrack(Track track) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(track);
    }

    @Override
    public void updateTrack(Track track) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(track);

    }

    @Override
    public void removeTrack(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Track track = (Track) session.load(Track.class, new Integer(id));

        if(track!=null){
            session.delete(track);
        }

    }

    @Override
    public Track getTrackById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Track track = (Track) session.load(Track.class, new Integer(id));
        return track;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Track> listTracks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Track> trackLists = session.createQuery("from Track").list();
        return trackLists;
    }
}
