package com.example.juicify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    public static final String ARRAYLIST_VALUES = "Data to display in listView";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // create an OnItemClickListener (notice the O is capitalized!!!)
        // since the ListView isn't a subclass of Button, that is why we have to implement a listener
        // and cannot use an onClick attribute like we did for Buttons, checkboxes or radio buttons
        // we can use this method with array data defined in the strings.xml

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView,
                                    View itemView, int position, long id) {
                Intent intent = new Intent(Home.this, Unreleased.class);


                // create an ArrayList of whatever type of data you are displaying in this app
                // In this particular app, everything is centralized around the Food class.
                ArrayList<Juice> listData = new ArrayList<>();

                // the choices for the menu on MainActivity coincide with the values in arr in strings.xml file
                if (position == 0) {                    // they chose breakfast
                    for (Juice f : Juice.gbgr) {      // add all the elements for this array to the arraylist
                        listData.add(f);
                    }
                } else if (position == 1) {
                    for (Juice f : Juice.wod) {        // they chose lunch
                        listData.add(f);
                    }
                } else if (position == 2) {
                    for (Juice f : Juice.drfl) {        // they chose dinner
                        listData.add(f);
                    }
                } else if (position == 3) {
                    for (Juice f : Juice.jw) {        // they chose dinner
                        listData.add(f);
                    }
                }

                // Send this particular ArrayList of Food data to the next activity, where we display
                // each name of each object in the ArrayList.
                intent.putParcelableArrayListExtra(ARRAYLIST_VALUES, listData);
                startActivity(intent);

            }
        };
//Get a reference to the ListView in the XML
        ListView listView = (ListView) findViewById(R.id.list_options);


//Add the listener to the ListView
// without this line of code, the listView isn’t interactive!!!!
        listView.setOnItemClickListener(itemClickListener);

    }

    public void switchScreens(View view) {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }
}
