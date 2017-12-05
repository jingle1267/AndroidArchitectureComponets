package com.ihognqiqu.aac.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import java.util.List;

/**
 * Created by zhenguo on 12/5/17.
 */
@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> selectAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> selectByIds(int[] userIds);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Update
    void updateUsers(User ... users);

}
