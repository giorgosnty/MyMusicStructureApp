package com.example.android.musicalstructureapp;

/**
 * Created by giorgosnty on 21/2/2018.
 */

public class Song {

    private String title;
    private String artist;
    private String album;
    private String year;
    private int duration;
    private String icon_name;

    public Song(String Title,String Artist,String Album,String Year,int Duration,String Icon_name){
        album=Album;
        title=Title;
        artist=Artist;
        year=Year;
        duration=Duration;
        icon_name=Icon_name;
    }

    //returns the year of the song
    public String getYear() {
        return year;
    }

    //returns the album of the song
    public String getAlbum() {
        return album;
    }

    //returns the artist of the song
    public String getArtist() {
        return artist;
    }

    //returns the title of the song
    public String getTitle() {
        return title;
    }

    //returns duration
    public int getDuration() {
        return duration;
    }

    public String getIcon_name() {
        return icon_name;
    }
}
