package com.ptExample.my1stapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ptExample.my1stapp.R;
import com.ptExample.my1stapp.model.Sensors;


public class My1stApp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my1st_app);

        final Context appContext = this;


        Button exitButton = (Button) findViewById(R.id.exitButton);
        Button getListButton = (Button)findViewById(R.id.getListButton);
        Button clearButton = (Button)findViewById(R.id.clearButton);
        Button nextButton = (Button)findViewById(R.id.nextButton);
        final EditText sensorIDEditText = (EditText) findViewById(R.id.sensorIDEditText);
        final TextView textView = (TextView) findViewById(R.id.sensorInfoTextView);
        final Sensors sensors = new Sensors(appContext);

        //final MySensor[] mySensors = sensors.getSensor();

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });

        getListButton.setOnClickListener(new View.OnClickListener() {

            StringBuilder data = new StringBuilder();

            @Override
            public void onClick(View view) {
                data.setLength(0);
                data = sensors.getList();
                textView.setText(data);
                //Toast.makeText(getApplicationContext(),"Completed",Toast.LENGTH_SHORT).show();
            }

        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();

               if(sensorIDEditText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter the Sensor ID", Toast.LENGTH_LONG).show();
                } else{
                int i = Integer.parseInt(sensorIDEditText.getText().toString());
                    if(i>=0 && i< sensors.getListSize()){
                        sensorActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "ID out of range", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    private void sensorActivity(int id){
        Intent intent = new Intent(this, SensorActivity1.class);
        intent.putExtra("mySensorID", id);
        //Toast.makeText(getApplicationContext(), "Before startActivity:" + id, Toast.LENGTH_LONG).show();
        startActivity(intent);

    }


}
