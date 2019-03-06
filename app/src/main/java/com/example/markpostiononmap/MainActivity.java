package com.example.markpostiononmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView placesListView;
    ArrayList<String> PlacesRecordArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView placesListView = (ListView)findViewById(R.id.ListStoredPlaces);
        ArrayList<String> PlacesRecordArrayList = new ArrayList<String>();
        PlacesRecordArrayList.add("Add new Place");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,PlacesRecordArrayList);
        placesListView.setAdapter(arrayAdapter);
    }
}
