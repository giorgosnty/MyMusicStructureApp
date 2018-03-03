package com.example.android.musicalstructureapp;

/**
 * Created by giorgosnty on 21/2/2018.
 */

public class Song {

    private String title;
    private String artist;
    private String album;
    private int year;

    public Song(String Title,String Artist,String Album,int Year){
        album=Album;
        title=Title;
        artist=Artist;
        year=Year;
    }

    //returns the year of the song
    public int getYear() {
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

}
