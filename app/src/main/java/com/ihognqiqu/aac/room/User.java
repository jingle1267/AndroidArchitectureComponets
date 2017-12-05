package com.ihognqiqu.aac.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by zhenguo on 12/5/17.
 */
@Entity(tableName = "user")
public class User {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "user_name")
    private String username;

    @ColumnInfo(name = "user_address")
    private String address;

    @Ignore
    private int sex;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}
