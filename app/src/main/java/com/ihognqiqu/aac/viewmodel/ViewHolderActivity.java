package com.ihognqiqu.aac.viewmodel;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.ihognqiqu.aac.R;

public class ViewHolderActivity extends AppCompatActivity {

    private TextView tvUsername, tvAddress;

    private DemoViewHolder mDemoViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holder);
        tvUsername = findViewById(R.id.tv_username);
        tvAddress = findViewById(R.id.tv_address);

        mDemoViewHolder = ViewModelProviders.of(this).get(DemoViewHolder.class);

        mDemoViewHolder.getUserInfo().observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(@Nullable UserEntity userEntity) {
                if (userEntity == null) {
                    return;
                }
                tvUsername.setText(userEntity.getUsername());
                tvAddress.setText(userEntity.getAddress());
            }
        });
    }

    public void onClick(View view) {
        mDemoViewHolder.requestUserInfo();
    }

}
