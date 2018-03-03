package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view that shows song
         final TextView playnow = (TextView) findViewById(R.id.song);



        //Creates an ArrayList of Song objects
         final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Wholla lotta love", "Led Zeppelin", "Led Zeppelin 2", 1969));
        songs.add(new Song("La Grange", "ZZ Top", "Tres Hombres", 1973));
        songs.add(new Song("Child in time", "Deep Purple", "Deep Purple in Rock", 1970));
        songs.add(new Song("November Rain", "Guns n Roses", "Use your Illusion I", 1991));
        songs.add(new Song("Moon Child", "Rory Galagher", "Calling Card", 1976));


        SongAdapter itemsAdapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(itemsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this, songs.get(position).getArtist(), Toast.LENGTH_SHORT).show();

                final String currentArtist = songs.get(position).getArtist();
                String currentTitle = songs.get(position).getTitle();
                String currentAlbum = songs.get(position).getAlbum();
                int currentYear = songs.get(position).getYear();

                playnow.setText(currentTitle );

                TextView artist = (TextView) findViewById(R.id.artist_textview);
                //artist.setText(currentArtist);
                TextView album = (TextView) findViewById(R.id.album_textview);
                //artist.setText(currentAlbum);
                TextView year = (TextView) findViewById(R.id.year_textview);
                //artist.setText(currentYear);

                playnow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent songIntent = new Intent(MainActivity.this, PlayingNowActivity.class);
                        songIntent.putExtra("artist",currentArtist);
                        startActivity(songIntent);
                    }
                });

            }
        });

    }

//    public static View getViewByPosition(int pos, ListView list) {
//        final int firstListItemPosition = list.getFirstVisiblePosition();
//        final int lastListItemPosition = firstListItemPosition + list.getChildCount() - 1;
//
//        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
//            return list.getAdapter().getView(pos, null, list);
//        } else {
//            final int childIndex = pos - firstListItemPosition;
//            return list.getChildAt(childIndex);
//        }
//    }

}
