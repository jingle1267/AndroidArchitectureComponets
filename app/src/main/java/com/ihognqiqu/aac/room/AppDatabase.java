package com.ihognqiqu.aac.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by zhenguo on 12/5/17.
 */
@Database(version = 1, entities = {User.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao getUserDao();

}
