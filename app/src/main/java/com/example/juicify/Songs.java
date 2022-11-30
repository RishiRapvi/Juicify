package com.example.juicify;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
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

        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        Button bt_stop = (Button) findViewById(R.id.playSong);
        final TextView tv = (TextView)findViewById(R.id.textView);


        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                                          @Override
                                          public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                                              int millisec_time = (i*60)/1000;

                                              new CountDownTimer(millisec_time, 1000) {

                                                  public void onTick(long millisUntilFinished) {
                                                      tv.setText("seconds remaining: " + millisUntilFinished / 1000);
                                                  }

                                                  public void onFinish() {
                                                      tv.setText("done!");
                                                  }
                                              }.start();


                                          }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"GOT",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(),"OFF",Toast.LENGTH_LONG).show();
            }
        });



        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


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

            button =  findViewById(R.id.pause);
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
    }

    public void pauseSong(View v){

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