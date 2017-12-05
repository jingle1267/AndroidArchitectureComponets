package com.ihognqiqu.aac.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

/**
 * 跟生命周期相关的监听器
 * <p>
 * Created by zhenguo on 12/5/17.
 */
public class LifeCycleListener implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        Log.d("LifeCycleListener", "start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        Log.d("LifeCycleListener", "stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void onAny(LifecycleOwner owner, Lifecycle.Event event) {
        Log.d("LifeCycleListener", "onAny:" + event.name());
    }

}
