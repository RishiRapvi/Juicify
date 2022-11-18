package com.example.juicify;

public class Juice {
    private String song;
    private String era;
    private int imageResourceID;

   /*
   To auto generate code, go on the top menu to Code - Generate and select
   what you want   Make sure your cursor is positioned where you want the code
   to be inserted.
    */

    public Juice(String song, String era, int imageResourceID) {
        this.song = song;
        this.era = era;
        this.imageResourceID = imageResourceID;
    }

    public Juice(double price, int imageResourceID) {
        this.song = "";
        this.era = "";
        this.imageResourceID = imageResourceID;
    }

    public static final Juice[] mySongs = {
            new Juice("Diners", "WOD", R.drawable.WOD),
            new Juice( "Cha-Ching", "DRFL", R.drawable.DRFL),
            new Juice("Diners", "WOD", R.drawable.WOD),
            new Juice("Diners", "WOD", R.drawable.WOD),
            new Juice("Diners", "WOD", R.drawable.WOD),
            new Juice("Diners", "WOD", R.drawable.WOD),
            new Juice("Diners", "WOD", R.drawable.WOD),
            new Juice("Diners", "WOD", R.drawable.WOD),

    };


    // the toString method is called automatically whenever the Food object is
    // printed this allows us to define what info we want to see when the var
    // is printed


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getEra() {
        return era;
    }

    public void setEra(String era) {
        this.era = era;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }
}
