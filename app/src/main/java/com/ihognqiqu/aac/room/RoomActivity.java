package com.ihognqiqu.aac.room;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.ihognqiqu.aac.R;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    private TextView tvUsersInfo;

    private AppDatabase mAppDatabase;
    private UserDao mUserDao;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        tvUsersInfo = findViewById(R.id.tv_users_info);
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "demodb").build();
        mUserDao = mAppDatabase.getUserDao();
        mHandler = new Handler();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User();
                        user.setUid(1);
                        user.setUsername("jingle1267");
                        user.setAddress("Beijing China");
                        user.setSex(1);
                        mUserDao.insertAll(user);
                    }
                }).start();
                break;
            case R.id.btn_del:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User();
                        user.setUid(1);
                        // user.setUsername("jingle1267");
                        // user.setAddress("Beijing China");
                        // user.setSex(1);
                        mUserDao.delete(user);
                    }
                }).start();
                break;
            case R.id.btn_update:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = new User();
                        user.setUid(1);
                        user.setUsername("jingle1267 update");
                        user.setAddress("Beijing China update");
                        user.setSex(1);
                        mUserDao.updateUsers(user);
                    }
                }).start();
                break;
            case R.id.btn_query:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int[] ids = {1};
                        List<User> users = mUserDao.selectByIds(ids);
                        final StringBuilder sb = new StringBuilder();
                        for (User user : users) {
                            sb.append(user.toString());
                            sb.append("\n");
                        }
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                tvUsersInfo.setText(sb.toString());
                            }
                        });
                    }
                }).start();
                break;
            default:

                break;
        }
    }
}
