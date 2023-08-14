package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MainActivity
        extends AppCompatActivity
        implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener {


    GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa= googleMap;
        // personalizar
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate camUpd1 =
               CameraUpdateFactory
                        .newLatLngZoom(new LatLng(-1.0126, -79.4691), 15);
       mapa.moveCamera(camUpd1);

      //  LatLng madrid = new LatLng( 40.689214508640774,  -74.0445744390096);
      //  CameraPosition camPos = new CameraPosition.Builder()
          //      .target(madrid)
         //       .zoom(19)
         //       .bearing(45) //noreste arriba
          //      .tilt(70) //punto de vista de la cámara 70 grados
            //    .build();
   //     CameraUpdate camUpd3 =
       //         CameraUpdateFactory.newCameraPosition(camPos);
    //    mapa.animateCamera(camUpd3);
        // se elnaca el elemento clic
        mapa.setOnMapClickListener(this);


        PolylineOptions lineas = new
                PolylineOptions()
                .add(new LatLng( -1.012596623479479, 79.46724142712081))
                .add(new LatLng( -1.0118808577372567, -79.47187501270041))
                .add(new LatLng(-1.013091193124705, -79.47194025769944))
                .add(new LatLng(-1.0136177359022727, -1.0136177359022727))
                .add(new LatLng(-1.012596623479479, 79.46724142712081));
        lineas.width(8);
        lineas.color(Color.RED);
        mapa.addPolyline(lineas);


    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

        mapa.addMarker(new MarkerOptions().position(latLng)
                .title("Punto"));

    }
}