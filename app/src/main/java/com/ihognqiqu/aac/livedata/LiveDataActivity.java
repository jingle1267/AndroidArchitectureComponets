package com.ihognqiqu.aac.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.ihognqiqu.aac.R;

public class LiveDataActivity extends AppCompatActivity {

    private MutableLiveData<String> username;

    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        tvUsername = findViewById(R.id.tv_username);

        username = new MutableLiveData<>();

        username.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvUsername.setText(s);
            }
        });
    }

    public void onClickMainThread(View view) {
        username.setValue("New User Name by main thread");
    }

    public void onClickThread(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                username.postValue("New User Name by background thread");
            }
        }).start();
    }
}
