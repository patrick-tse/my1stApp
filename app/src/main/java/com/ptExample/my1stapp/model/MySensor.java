package com.ptExample.my1stapp.model;

/**
 * Created by Patrick.Tse on 3/8/2015.
 */
public class MySensor {
    private int mSerialNumber;
    private int mMaxDelay;
    private int mMinDelay;
    private float mMaximumRange;
    private float mPower;
    private int mReportMode;
    private String mName;
    private float mResolution;
    private String mStringType;
    private int mType;
    private String mVendor;
    private int mVersion;
    private boolean mIsWakeUpSensor;
    private int mFifoMaxEventCount;
    private int mFifoReservedEventCount;

    public int getMaxDelay() {
        return mMaxDelay;
    }

    public void setMaxDelay(int maxDelay) {
        mMaxDelay = maxDelay;
    }

    public int getMinDelay() {
        return mMinDelay;
    }

    public void setMinDelay(int minDelay) {
        mMinDelay = minDelay;
    }

    public float getMaximumRange() {
        return mMaximumRange;
    }

    public void setMaximumRange(float maximumRange) {
        mMaximumRange = maximumRange;
    }

    public float getPower() {
        return mPower;
    }

    public void setPower(float power) {
        mPower = power;
    }

    public int getReportMode() {
        return mReportMode;
    }

    public void setReportMode(int reportMode) {
        mReportMode = reportMode;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getResolution() {
        return mResolution;
    }

    public void setResolution(float resolution) {
        mResolution = resolution;
    }

    public String getStringType() {
        return mStringType;
    }

    public void setStringType(String stringType) {
        mStringType = stringType;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    public String getVendor() {
        return mVendor;
    }

    public void setVendor(String vendor) {
        mVendor = vendor;
    }

    public int getVersion() {
        return mVersion;
    }

    public void setVersion(int version) {
        mVersion = version;
    }

    public boolean isWakeUpSensor() {
        return mIsWakeUpSensor;
    }

    public void setWakeUpSensor(boolean isWakeUpSensor) {
        mIsWakeUpSensor = isWakeUpSensor;
    }

    public int getFifoMaxEventCount() {
        return mFifoMaxEventCount;
    }

    public void setFifoMaxEventCount(int fifoMaxEventCount) {
        mFifoMaxEventCount = fifoMaxEventCount;
    }

    public int getFifoReservedEventCount() {
        return mFifoReservedEventCount;
    }

    public void setFifoReservedEventCount(int fifoReservedEventCount) {
        mFifoReservedEventCount = fifoReservedEventCount;
    }

    public int getSerialNumber() {
        return mSerialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        mSerialNumber = serialNumber;
    }
}
