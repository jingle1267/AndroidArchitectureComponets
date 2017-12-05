package com.ihognqiqu.aac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.ihognqiqu.aac.lifecycle.LifeCycleActivity;
import com.ihognqiqu.aac.livedata.LiveDataActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLifeCycle(View view) {
        startActivity(new Intent(this, LifeCycleActivity.class));
    }

    public void onClickLiveData(View view) {
        startActivity(new Intent(this, LiveDataActivity.class));
    }

}
