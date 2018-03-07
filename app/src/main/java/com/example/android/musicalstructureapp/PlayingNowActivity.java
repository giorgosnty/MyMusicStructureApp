package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by giorgosnty on 21/2/2018.
 */

public class PlayingNowActivity extends AppCompatActivity {

    @Override
     protected void onCreate( Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       setContentView(R.layout.playingnow);

       Intent songsIntent = getIntent();

       //set artist album and year taken from the main screen when user selected to go to the playing now screen
       String artist = songsIntent.getStringExtra("artist");
       TextView current_artist = (TextView) findViewById(R.id.artist_textview);
       current_artist.setText(artist);

       String album = songsIntent.getStringExtra("album");
       TextView current_album = (TextView) findViewById(R.id.album_textview);
       current_album.setText(album);

       String year = songsIntent.getStringExtra("year");
       TextView current_year = (TextView) findViewById(R.id.year_textview);
       current_year.setText(year);

       //here it finds the imageview and then takes the name of the icon and makes the path so it can find it and display it
       String icon_name = songsIntent.getStringExtra("icon_name");
       ImageView song_icon = (ImageView) findViewById(R.id.song_icon);
       int resID = getResources().getIdentifier(icon_name, "drawable", getPackageName());
       song_icon.setImageResource(resID);


    }


}
