package com.example.lab2_new;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SensorsActivity extends Activity implements SensorEventListener, LocationListener {
    private SensorManager mSensorManager;
    SensorManager sm;
    List<Sensor> ss;
    String sensorsList;
    TextView sensorsTextView,locationTextView;

    private static final String TAG = "Debug";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        setContentView(R.layout.activity_sensors);

        sensorsTextView = (TextView) findViewById(R.id.sensorsTextView);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        ss = sm.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : ss) {
            sensorsList += s.toString() + "\n";
        }
        sensorsTextView.setMovementMethod(new ScrollingMovementMethod());
        sensorsTextView.setText(sensorsList);

        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 10, this);

    }


    protected void onResume() {
        super.onResume();

    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
    }


    @Override
    public void onLocationChanged(Location loc) {
        locationTextView = (TextView) findViewById(R.id.locationTextView);


        String longitude = "Longitude: " + loc.getLongitude();
        Log.v(TAG, longitude);
        String latitude = "Latitude: " + loc.getLatitude();
        Log.v(TAG, latitude);

        String s = longitude + "\n" + latitude;
        locationTextView.setText(s);
        System.out.println(s);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}


}
