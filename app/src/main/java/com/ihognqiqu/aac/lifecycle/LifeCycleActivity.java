package com.ihognqiqu.aac.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.ihognqiqu.aac.R;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        getLifecycle().addObserver(new LifeCycleListener());
    }
}
