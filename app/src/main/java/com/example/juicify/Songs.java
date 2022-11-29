package com.example.juicify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Songs extends AppCompatActivity {

    private Juice juice;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        Intent intent = getIntent();

        try {
            // This gets the particular Detailed object we are displaying
            // In this case, it is a Food object.
            juice = intent.getParcelableExtra(Unreleased.DETAIL_CHOICE);

            // This page will display the specific Detailed data for what your app is showing.
            // Get references to the xml views for name, price, desc, and photo

            // Finish this code to match your xml file.  These names are what I used.
            TextView song = findViewById(R.id.songTextView);
            TextView era = findViewById(R.id.eraTextView);
            ImageView photo = findViewById(R.id.imageView);

            button =  findViewById(R.id.playSong);
            // set values on the screen based on the object that was passed to this Detail activity
            song.setText(juice.getSong());
            era.setText(juice.getEra());

            if (juice.getImageResourceID() == 0) {
                // set a default pic or decide what to do in this case.
            }
            else {
                photo.setImageResource(juice.getImageResourceID());
            }
        }
        catch (Exception e) {
            Log.i("Rishi", "Code not working!");
        }
    }
    MediaPlayer mediaPlayer = new MediaPlayer();

    public void playSong(View v){
        try{
            mediaPlayer.setDataSource(juice.getSongLink());
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
            }
        });
    }




}