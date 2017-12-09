package com.ihongqiqu.old.nolifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ihognqiqu.aac.R;

/**
 * 定位功能一般实现方法
 */
public class LocationActivity extends AppCompatActivity {

    private LocationListener mLocationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        mLocationListener = new LocationListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mLocationListener != null) {
            mLocationListener.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mLocationListener != null) {
            mLocationListener.stop();
        }
    }
}
