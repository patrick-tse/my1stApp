package com.ptExample.my1stapp.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Patrick.Tse on 3/1/2015.
 */
public class Sensors {

    private SensorManager mSensorMgr;
    private Context mContext;
    MySensor[] mSensor;
    private List<Sensor> mList;
    private int mListSize;


    public MySensor getSensor(int i) {
        return mSensor[i];
    }


    public int getListSize() {
        return mListSize;
    }

    public void setListSize(int listSize) {
        mListSize = listSize;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public Sensors(Context context) {
        int i = 0;
        mSensorMgr = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mContext = context;

        mList = mSensorMgr.getSensorList(Sensor.TYPE_ALL);

        mSensor = new MySensor[mList.size()];
        mListSize = mList.size();


        for (Sensor sensor: mList){
            mSensor[i] = new MySensor();
            mSensor[i].setFifoMaxEventCount(sensor.getFifoMaxEventCount());
            mSensor[i].setFifoReservedEventCount(sensor.getFifoReservedEventCount());
            mSensor[i].setMinDelay(sensor.getMinDelay());
            mSensor[i].setMaximumRange(sensor.getMaximumRange());
            mSensor[i].setName(sensor.getName());
            mSensor[i].setPower(sensor.getPower());
            mSensor[i].setResolution(sensor.getResolution());
            mSensor[i].setType(sensor.getType());
            mSensor[i].setVendor(sensor.getVendor());
            mSensor[i].setSerialNumber(i);
            mSensor[i].setVersion(sensor.getVersion());
            //mSensor[i].setMaxDelay(null);
            //mSensor[i].setWakeUpSensor(null);
            //mSensor[i].setStringType(null);
            //mSensor[i].setReportMode(null);
            i++;
        }


    }

    public StringBuilder getList(){
        int i = 0;
        StringBuilder sensorData = new StringBuilder();
        sensorData.setLength(0);

        List<Sensor>mList = mSensorMgr.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor: mList){
            sensorData.append("ID:["+mSensor[i].getSerialNumber()+"]; ");
            sensorData.append(mSensor[i].getName() +"; Type("+ sensor.getType()+")"+ "\n");
            i++;
        }

        return sensorData;
    }
}
