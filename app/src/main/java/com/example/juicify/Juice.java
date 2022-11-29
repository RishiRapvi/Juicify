package com.example.juicify;

import android.os.Parcel;
import android.os.Parcelable;

public class Juice implements Parcelable {
    private String song;
    private String era;
    private int imageResourceID;
    private String songLink;

    public static final Parcelable.Creator<Juice> CREATOR = new
            Parcelable.Creator<Juice>() {

                @Override
                public Juice createFromParcel(Parcel parcel) {
                    return new Juice(parcel);
                }

                @Override
                public Juice[] newArray(int size) {
                    return new Juice[0];
                }
            };

    public Juice(Parcel parcel) {
        song = parcel.readString();
        era = parcel.readString();
        imageResourceID = parcel.readInt();
        songLink = parcel.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(song);
        dest.writeString(era);
        dest.writeInt(imageResourceID);
        dest.writeString(songLink);

    }

    public Juice() {
        song = "";
        era = "";
        imageResourceID = 0;
        songLink = "";
    }

    public String toString() {
        return this.song;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Juice(String song, String era, int imageResourceID, String songLink) {
        this.song = song;
        this.era = era;
        this.imageResourceID = imageResourceID;
        this.songLink = songLink;
    }

    public Juice(double price, int imageResourceID) {
        this.song = "";
        this.era = "";
        this.imageResourceID = imageResourceID;
    }

    public static final Juice[] gbgr = {

            new Juice( "Fall", "GBGR", R.drawable.gbgr, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/Fall%20%5Bv1%5D.mp3?alt=media&token=27175539-4fdb-4d2e-98ea-ee22b89d2d39"),
            new Juice( "Lean Wit Me [v2]", "GBGR", R.drawable.gbgr, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/Lean%20Wit%20Me%20%5Bv2%5D.mp3?alt=media&token=d438921a-a15b-4ba2-9c09-3b69c5b94b60")
    };

    public static final Juice[] wod = {

            new Juice("Diners", "WOD", R.drawable.wod, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/Diners%20%5Bv1%5D.mp3?alt=media&token=a0741220-31b3-4745-9e04-5269a9afed53"),
            new Juice("Friends Die", "WOD", R.drawable.wod, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/Friends%20Die.mp3?alt=media&token=c7d3a44e-ed55-4428-9a40-584611c3d792")

    };

    public static final Juice[] drfl = {

            new Juice( "Cha-Ching", "DRFL", R.drawable.drfl, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/Cha-Ching%20(Spend%20It%20All).mp3?alt=media&token=b59b3a4d-5f37-49af-85a5-e83e00f6976b"),
            new Juice( "KTM Drip", "DRFL", R.drawable.drfl, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/KTM%20Drip.mp3?alt=media&token=cb869e80-f4ab-4f5f-a1d1-d05bfc5ec6ce")

    };
    public static final Juice[] jw = {

            new Juice( "Rain Dance", "JW3", R.drawable.juice, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/Rain%20Dance%20%5Bv1%5D.mp3?alt=media&token=fdf9dddb-0c95-4930-8966-05a61d148f74"),
            new Juice( "On Time", "JW3", R.drawable.juice, "https://firebasestorage.googleapis.com/v0/b/juicify-90105.appspot.com/o/On%20Time%20(Righteous%20Pt.%202).mp3?alt=media&token=95dd4132-1176-4859-a694-e542a240a514")
    };


    public static final Parcelable.Creator<Juice> juiceCreator = new Parcelable.Creator<Juice>() {

        @Override
        public Juice createFromParcel(Parcel parcel) {
            return new Juice(parcel);
        }

        @Override
        public Juice[] newArray(int size) {
            return new Juice[0];
        }
    };



    // the toString method is called automatically whenever the Food object is
    // printed this allows us to define what info we want to see when the var
    // is printed


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

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }
}
