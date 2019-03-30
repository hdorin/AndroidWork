package com.example.lab2_new;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

class SensorsActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    SensorManager sm;
    List<Sensor> ss;
    String sensorsList;
    TextView sensorsTextView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        setContentView(R.layout.activity_sensors);

        sensorsTextView= (TextView)findViewById(R.id.sensorsTextView);
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        ss=sm.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : ss){
            sensorsList+=s.toString()+"\n";
        }
        sensorsTextView.setMovementMethod(new ScrollingMovementMethod());
        sensorsTextView.setText(sensorsList);

    }
    public SensorsActivity() {


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
}
