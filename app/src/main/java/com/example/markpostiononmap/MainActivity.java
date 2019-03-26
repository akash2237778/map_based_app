package com.example.markpostiononmap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ListView placesListView;
    ArrayList<String> PlacesRecordArrayList;
    int check=0;

    String addressLine2beStored;
    LatLng latLngToBeStored;
    SharedPreferences checkShared;

    public void AddNewPlace(){
        Intent MapsActivity = new Intent(getApplicationContext(), MapsActivityRecordingPlaces.class);
        startActivity(MapsActivity);
    }


    public void setDataInArray(){
        Intent intent2main = getIntent();
        Log.i("lat+long :", intent2main.getStringExtra("latitude") + "   " +intent2main.getStringExtra("longitude"));
        int latitude = Integer.parseInt(intent2main.getStringExtra("latitude"));
        int longitude = Integer.parseInt(intent2main.getStringExtra("longitude"));

        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
        try {
            List<Address> addressList = geocoder.getFromLocation(latitude,longitude,1);
            addressLine2beStored = addressList.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlacesRecordArrayList.add(addressLine2beStored);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkShared = this.getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);


        check = checkShared.getInt("checkStored" , 0);
        Log.i("check :", String.valueOf(check));
        if(check==5){

        }



        ListView placesListView = (ListView)findViewById(R.id.ListStoredPlaces);
        PlacesRecordArrayList = new ArrayList<String>();
        PlacesRecordArrayList.add("Add new Place");
        PlacesRecordArrayList.add("Place 1");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,PlacesRecordArrayList);
        placesListView.setAdapter(arrayAdapter);

        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    AddNewPlace();
                    check=3;
                    checkShared.edit().putInt("checkStored",2).apply();
                }

            }
        });
    }
}
