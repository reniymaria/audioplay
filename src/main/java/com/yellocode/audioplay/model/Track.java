package com.yellocode.audioplay.model;

import javax.persistence.*;

@Entity
@Table(name = "TRACKS")
public class Track {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TRACK_TITLE")
    private String trackTitle;

    @Column(name = "TRACK_AUTHOR")
    private String trackAuthor;

    @Column(name = "TRACK_PLAY")
    private String play;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getTrackAuthor() {
        return trackAuthor;
    }

    public void setTrackAuthor(String trackAuthor) {
        this.trackAuthor = trackAuthor;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackTitle='" + trackTitle + '\'' +
                ", trackAuthor='" + trackAuthor + '\'' +
                ", play='" + play + '\'' +
                '}';
    }
}
