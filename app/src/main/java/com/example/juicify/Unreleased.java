package com.example.juicify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Unreleased extends AppCompatActivity {
    public static final String DETAIL_CHOICE = "chosen Detailed object-Food in this case";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unreleased);

        Intent intent = getIntent();

        ArrayList<Juice> dataToDisplay = intent.getParcelableArrayListExtra(MainActivity.ARRAYLIST_VALUES);


        ArrayAdapter<Juice> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, dataToDisplay);

        ListView listView = (ListView) findViewById(R.id.GBGR);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(Unreleased.this, Songs.class);

                intent.putExtra(DETAIL_CHOICE, dataToDisplay.get(position));

                startActivity(intent);
            }
        });
    }
}
