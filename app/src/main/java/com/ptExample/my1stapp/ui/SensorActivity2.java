package com.ptExample.my1stapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.hardware.GeomagneticField;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Location;


import com.ptExample.my1stapp.R;
import com.ptExample.my1stapp.model.Sensors;

public class SensorActivity2 extends Activity {

    private int mType;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private TextView mSensorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_activity2);

        Intent intent = getIntent();
        mType = intent.getIntExtra("sensorType", 0);
        //Toast.makeText(getApplicationContext(), "App2: " + mType, Toast.LENGTH_LONG).show();

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(mType);

        Button backButton = (Button) findViewById(R.id.backButton);
        mSensorTextView = (TextView) findViewById(R.id.sensorTextView);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    final SensorEventListener mSensorListener = new SensorEventListener() {
        private float maxX=0;
        private float maxY=0;
        private float maxZ=0;
        private float minX=0;
        private float minY=0;
        private float minZ=0;

        public void onSensorChanged(SensorEvent se) {

            if(mSensor.getType() == Sensor.TYPE_GRAVITY ||
                    mSensor.getType() == Sensor.TYPE_ORIENTATION) {
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];

                mSensorTextView.setText("x: " + x + ";\ny: " + y + ";\nz: " + z + ";\n");
            }

            if(mSensor.getType() == Sensor.TYPE_ACCELEROMETER ||
                    mSensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];

                if(x>maxX){
                    maxX = x;
                }
                if(y>maxY){
                    maxY = y;
                }
                if(z>maxZ){
                    maxZ = z;
                }
                if(x<minX){
                    minX = x;
                }
                if(y<minY){
                    minY = y;
                }
                if(z<minZ){
                    minZ = z;
                }


                mSensorTextView.setText("x: " + x + "m/s^2;\ny: " + y + "m/s^2;\nz: " + z + "m/s^2;\n\n"
                +"maxX: " + maxX + "m/s^2;\nmaxY: " + maxY + "m/s^2;\nmaxZ: " + maxY + "m/s^2;\n"
                +"minX: " + minX + "m/s^2;\nminY: " + minY + "m/s^2;\nminZ: " + minY + "m/s^2;\n");
            }


            if(mSensor.getType() == Sensor.TYPE_LIGHT){
                float x = se.values[0];

                mSensorTextView.setText(x+" lx\n");
            }

            if(mSensor.getType() == Sensor.TYPE_MAGNETIC_FIELD ||
                    mSensor.getType() == Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED){
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];

                mSensorTextView.setText("x: " + x + " uT;\ny: " + y + " uT;\nz: " + z + " uT;\n");
            }

            if(mSensor.getType() == Sensor.TYPE_GYROSCOPE ||
                    mSensor.getType() == Sensor.TYPE_GYROSCOPE_UNCALIBRATED){
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];

                mSensorTextView.setText("x: " + x + " ;\ny: " + y + " ;\nz: " + z + " ;\n");
            }

            if(mSensor.getType() == Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR){
            /*    Location location = new Location(LocationProvider);
                GeomagneticField gmf = new GeomagneticField(
                        (float) location.getLatitue(),
                        (float) location.getLongitude(),
                        (float) location.getAltitude(),
                        System.currentTimeMillis());
                        */
                mSensorTextView.setText("Need LocationProvider.\n");
            }

            if(mSensor.getType() == Sensor.TYPE_PRESSURE){
                float x = se.values[0];

                mSensorTextView.setText(x+" hPA(millibar)\n");
            }

            if(mSensor.getType() == Sensor.TYPE_PROXIMITY){
                float x = se.values[0];

                mSensorTextView.setText(x+" cm\n");
            }


            if(mSensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];
                float a = se.values[3];
                float b = se.values[4];

                mSensorTextView.setText("x*sin(theta/2): " + x + ";\ny*sin(theta/2): " + y + ";\nz*sin(theta/2): "
                        + z + "\ncos(theta/2): "+ a + "\nEstimated heading Accuracy: "+ b + "\n");
            }

            if(mSensor.getType() == Sensor.TYPE_GAME_ROTATION_VECTOR) {
                float x = se.values[0];
                float y = se.values[1];
                float z = se.values[2];
                float a = se.values[3];
                //float b = se.values[4];

                mSensorTextView.setText("x*sin(theta/2): " + x + ";\ny*sin(theta/2): " + y + ";\nz*sin(theta/2): "
                        + z + "\ncos(theta/2): "+ a + "\n");
            }




        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Toast.makeText(getApplicationContext(), "Inside onAccuracy Changed", Toast.LENGTH_SHORT).show();
        }
    };


    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        //mSensorManager.registerListener(mSensorListener, mSensor, 500000);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorListener);
    }

    public void display(float accel){
        //TextView sensorMainTextView = (TextView) findViewById(R.id.mainTextView);
        //sensorMainTextView.setText("x: "+accel);
    }

}




