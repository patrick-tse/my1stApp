package com.ptExample.my1stapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ptExample.my1stapp.R;
import com.ptExample.my1stapp.model.Sensors;

public class SensorActivity1 extends Activity {

    //private Sensor mAccelerometer;
    private int mID;
    private Sensors sensors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_activity1);

        sensors = new Sensors(this);
        Intent intent = getIntent();
         mID = intent.getIntExtra("mySensorID", 0);

        //Toast.makeText(getApplicationContext(),"mID:"+mID, Toast.LENGTH_LONG).show();

        Button backButton = (Button) findViewById(R.id.backButton);
        Button trySensorButton = (Button) findViewById(R.id.trySensorButton);
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button previousButton = (Button)findViewById(R.id.previousButton);
        final TextView sensorInfoTextView = (TextView) findViewById(R.id.sensorInfoTextView);
        final TextView sensorMainTextView = (TextView) findViewById(R.id.mainTextView);

        displayInfo(sensorInfoTextView, sensorMainTextView);

        //SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        trySensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sensorActivity();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mID>=0 && mID<sensors.getListSize()-1){
                    mID++;
                    displayInfo(sensorInfoTextView, sensorMainTextView);
                } else {
                    Toast.makeText(getApplicationContext(), "Out of Range.", Toast.LENGTH_SHORT).show();
                }
            }

        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mID>0 && mID<=sensors.getListSize()-1){
                    mID--;
                    displayInfo(sensorInfoTextView, sensorMainTextView);
                } else {
                    Toast.makeText(getApplicationContext(), "Out of Range.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void displayInfo(TextView sensorInfoTextView, TextView sensorMainTextView){
        String data = "Sensor ID:["+mID+"];"+"\n";
        sensorInfoTextView.setText(data);

        StringBuilder sensorData = new StringBuilder();
        sensorData.setLength(0);

        sensorData.append("Type: "+sensors.getSensor(mID).getType()+";\n");
        sensorData.append("Name: "+sensors.getSensor(mID).getName()+";\n");
        sensorData.append("Version: "+sensors.getSensor(mID).getVersion()+";\n");
        sensorData.append("Vendor: "+sensors.getSensor(mID).getVendor()+";\n");
        sensorData.append("Power: "+sensors.getSensor(mID).getPower()+"mA;\n");
        sensorData.append("Resolution: "+sensors.getSensor(mID).getResolution()+";\n");
        sensorData.append("Min Delay: "+sensors.getSensor(mID).getMinDelay()+"us;\n");
        sensorData.append("Max Range: "+sensors.getSensor(mID).getMaximumRange()+";\n");
        sensorData.append("FifoReservedEventCount: "+sensors.getSensor(mID).getFifoReservedEventCount()+";\n");
        sensorData.append("FifoMaxEventCount: "+sensors.getSensor(mID).getFifoMaxEventCount()+";\n");
        sensorData.append("String Type: "+sensors.getSensor(mID).getStringType()+";\n");
        sensorData.append("Report Mode: "+sensors.getSensor(mID).getReportMode()+";\n");

        sensorMainTextView.setText(sensorData);
    }

    private void sensorActivity(){
        Intent intent = new Intent(this, SensorActivity2.class);
        intent.putExtra("sensorType", sensors.getSensor(mID).getType());
        //Toast.makeText(getApplicationContext(), "Before startActivity:" + id, Toast.LENGTH_LONG).show();
        startActivity(intent);

    }

 /*
    final SensorEventListener mSensorListener = new SensorEventListener() {

        private float mAccel; // acceleration apart from gravity
        private float mAccelCurrent; // current acceleration including gravity
        private float mAccelLast; // last acceleration including gravity


        public void onSensorChanged(SensorEvent se) {
            float x = se.values[0];
            float y = se.values[1];
            float z = se.values[2];
            mAccelLast = mAccelCurrent;
            mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
            float delta = mAccelCurrent - mAccelLast;
            mAccel = mAccel * 0.9f + delta; // perform low-cut filter
            if(mAccelCurrent>10){
                display(mAccelCurrent);
            }
            if(mAccelCurrent>35) {
                Toast.makeText(getApplicationContext(), "mAccel: " + mAccelCurrent, Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            Toast.makeText(getApplicationContext(), "Inside onAccuracy Changed", Toast.LENGTH_LONG).show();
        }


    };

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorListener);
    }

    public void display(float accel){
        //TextView sensorMainTextView = (TextView) findViewById(R.id.mainTextView);
        //sensorMainTextView.setText("x: "+accel);
    }

*/
}
