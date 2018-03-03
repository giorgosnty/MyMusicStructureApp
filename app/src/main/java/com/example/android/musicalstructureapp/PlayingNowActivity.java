package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by giorgosnty on 21/2/2018.
 */

public class PlayingNowActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.playingnow);

        Intent songsIntent = getIntent();

        String artist = songsIntent.getStringExtra("artist");

        TextView current_artist = (TextView) findViewById(R.id.artist_textview);
        current_artist.setText(artist);

        Toast.makeText(PlayingNowActivity.this, "hey", Toast.LENGTH_SHORT).show();



        TextView mytext = new TextView(this);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.addView(mytext);
        Bundle extras = getIntent().getExtras();
        mytext.setText("Activity One value: " + extras.getString("com.example.hello.Implicit_intent"));
        setContentView(linearlayout);
    }


}
