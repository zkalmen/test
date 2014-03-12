/**
 * Created by zack.kalmen on 3/10/14.
 */

package com.example.testapp;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.widget.Button;

public class screen_1_activity extends Activity {
    private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in Meters
    private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in Milliseconds
    TextView latText;
    TextView lonText;
    protected Button getLocationButton;
    protected LocationManager locationManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.screen_1);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new MyLocationListener();
        lonText = (TextView)findViewById(R.id.lon);
        latText = (TextView)findViewById(R.id.lat);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                MINIMUM_TIME_BETWEEN_UPDATES,
                MINIMUM_DISTANCE_CHANGE_FOR_UPDATES,
                new MyLocationListener()
        );

        getLocationButton = (Button) findViewById(R.id.screen_1_button);
        getLocationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showCurrentLocation();
            }
        });
    }
    protected void showCurrentLocation() {
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location != null){
            //String message = String.format("current location \n Longitude: %1$s \n Latitude: %2$s",location.getLongitude(), location.getLatitude());
            latText.setText("Latitude: "+Double.toString(location.getLatitude()));
            lonText.setText("Longitude: "+Double.toString(location.getLongitude()));
        }
    }
    private class MyLocationListener implements LocationListener {
        public void onLocationChanged(Location location) {
           // String message = String.format("New Location \n Longitude: %1$s \n Latitude: %2$s",location.getLongitude(), location.getLatitude()
           // );
            latText.setText("Latitude: "+Double.toString(location.getLatitude()));
            lonText.setText("Longitude: "+Double.toString(location.getLongitude()));
           // Toast.makeText(screen_1_activity.this, message, Toast.LENGTH_LONG).show();
        }
        public void onStatusChanged(String s, int i, Bundle b) {
           // Toast.makeText(screen_1_activity.this, "Provider status changed",Toast.LENGTH_LONG).show();
        }
        public void onProviderDisabled(String s) {
            //Toast.makeText(screen_1_activity.this,"Provider disabled by the user. GPS turned off",Toast.LENGTH_LONG).show();
        }
        public void onProviderEnabled(String s) {
           // Toast.makeText(screen_1_activity.this,"Provider enabled by the user. GPS turned on",Toast.LENGTH_LONG).show();
        }

    }


}
