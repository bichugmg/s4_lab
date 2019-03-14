package com.example.andlabb.gpslocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    LocationManager locationManager;
    Context mContext;
Double lat=0.0,lan=0.0;
    GoogleMap gmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        mContext=this;
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapa);
        mapFragment.getMapAsync((OnMapReadyCallback) this);


    }
    LocationListener location=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Toast.makeText(getApplicationContext(),location.getLatitude()+","+location.getLongitude() ,Toast .LENGTH_LONG).show();
            lat=location.getLatitude();
            lan=location.getLongitude();
            LatLng sydney = new LatLng(lat, lan);
                gmap.addMarker(new MarkerOptions().position(sydney)
                    .title(""));
            gmap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }


    };
    public void onRequestPermissionsResult(int requestCode, String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getApplicationContext(),"no permission" ,Toast .LENGTH_LONG).show();

                        return;
                    }
                    else
                    {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                                10,
                                10, location);
                    }


                } else {

                }
                return;
            }

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gmap=googleMap;
        LatLng sydney = new LatLng(lat, lan);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title(""));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
