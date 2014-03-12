/*package com.example.testapp;

import java.sql.Timestamp;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class LocationTest extends Activity {
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView)this.findViewById(R.id.txtLocation);
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationListener ll = new mylocationlistener();
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
    }
    private class mylocationlistener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            Date today = new Date();
            Timestamp currentTimeStamp = new Timestamp(today.getTime());
            if (location != null) {
                Log.d("LOCATION CHANGED", location.getLatitude() + "");
                Log.d("LOCATION CHANGED", location.getLongitude() + "");
                Strig str = "\n CurrentLocation: "+
                        "\n Latitude: "+ location.getLatitude() +
                        "\n Longitude: " + location.getLongitude() +
                        "\n Accuracy: " + location.getAccuracy() +
                        "\n CurrentTimeStamp "+ currentTimeStamp;
                Toast.makeText(LocationTest.this,str,Toast.LENGTH_LONG).show();
                tv.append(str);
            }
        }
        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(LocationTest.this,"Error onProviderDisabled",Toast.LENGTH_LONG).show();
        }
        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(LocationTest.this,"onProviderEnabled",Toast.LENGTH_LONG).show();
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Toast.makeText(LocationTest.this,"onStatusChanged",Toast.LENGTH_LONG).show();
        }
    }
}*/