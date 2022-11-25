package com.example.juicify;

import android.os.Parcel;
import android.os.Parcelable;

public class Juice implements Parcelable {
    private String song;
    private String era;
    private int imageResourceID;

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
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(song);
        dest.writeString(era);
        dest.writeInt(imageResourceID);
    }

    public Juice() {
        song = "";
        era = "";
        imageResourceID = 0;
    }

    public String toString() {
        return this.song;
    }

    @Override
    public int describeContents() {
        return 0;
    }

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

    public static final Juice[] gbgr = {

            new Juice( "Fall", "GBGR", R.drawable.gbgr),
            new Juice( "Lean Wit Me [v2]", "GBGR", R.drawable.gbgr)
    };

    public static final Juice[] wod = {

            new Juice("Diners", "WOD", R.drawable.wod),
            new Juice("Friends Die", "WOD", R.drawable.wod)

    };

    public static final Juice[] drfl = {

            new Juice( "Cha-Ching", "DRFL", R.drawable.drfl),
            new Juice( "KTM Drip", "DRFL", R.drawable.drfl)

    };
    public static final Juice[] jw = {

            new Juice( "Rain Dance", "JW3", R.drawable.juice),
            new Juice( "On Time", "JW3", R.drawable.juice)
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
}
