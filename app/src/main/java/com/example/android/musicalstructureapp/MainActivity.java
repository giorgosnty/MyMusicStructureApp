package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static boolean play =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finds the view that shows selected song in the bottom of the main screen
        final TextView playnow = (TextView) findViewById(R.id.song);

        //sets a custom font to the playng now song window
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/quicksand_m.ttf");
        playnow.setTypeface(custom_font);

        //Creates an ArrayList of Song objects
        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Wholla lotta love", "Led Zeppelin", "Led Zeppelin 2", "1969",289,"wholla_lotta_love"));
        songs.add(new Song("La Grange", "ZZ Top", "Tres Hombres", "1973",228,"la_grange"));
        songs.add(new Song("Child in time", "Deep Purple", "Deep Purple in Rock", "1970",619,"child_in_time"));
        songs.add(new Song("November Rain", "Guns n Roses", "Use your Illusion I", "1991",548,"november_rain"));
        songs.add(new Song("Moon Child", "Rory Galagher", "Calling Card", "1976",287,"moonchild"));

        //we initiate our custom adapter with the songs in the arraylist
        SongAdapter itemsAdapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(itemsAdapter);

        //it finds the play/pause button
        final ImageView play_pause =(ImageView) findViewById(R.id.play_pause);

        //when someone selects a song these events take place
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                //first of all we store the information of current object
                final String currentArtist = songs.get(position).getArtist();
                final String currentAlbum = songs.get(position).getAlbum();
                final String currentYear = songs.get(position).getYear();
                final String currentIconName=songs.get(position).getIcon_name();

                String currentTitle = songs.get(position).getTitle();

                //sets the title of the song selected in the playnow tab
                playnow.setText(currentTitle );

                //before someone selects a song this image is not visible,so now
                //it gets visible and is the play button ready to be pressed
                play_pause.setImageResource(R.drawable.play_btn);

                //when someone clicks the playing now tab after selecting a song they will open playingnow activity
                playnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent songIntent = new Intent(MainActivity.this, PlayingNowActivity.class);
                        songIntent.putExtra("artist",currentArtist);
                        songIntent.putExtra("album",currentAlbum);
                        songIntent.putExtra("year",currentYear);
                        songIntent.putExtra("icon_name",currentIconName);
                        startActivity(songIntent);

                    }
                });

                play_pause.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        //checks if it was play so it makes it pause when you press it
                        if(play) {
                            play_pause.setImageResource(R.drawable.pause);
                            play = false;
                        }else{
                            play_pause.setImageResource(R.drawable.play_btn);
                            play = true;
                        }

                    }

                });
            }
        });
    }
}
