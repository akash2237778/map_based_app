package com.example.markpostiononmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView placesListView;
    ArrayList<String> PlacesRecordArrayList;


    public void AddNewPlace(){
        Intent MapsActivity = new Intent(getApplicationContext(), MapsActivityRecordingPlaces.class);
        startActivity(MapsActivity);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView placesListView = (ListView)findViewById(R.id.ListStoredPlaces);
        ArrayList<String> PlacesRecordArrayList = new ArrayList<String>();
        PlacesRecordArrayList.add("Add new Place");
        PlacesRecordArrayList.add("Place 1");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,PlacesRecordArrayList);
        placesListView.setAdapter(arrayAdapter);

        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    AddNewPlace();
                }

            }
        });
    }
}
