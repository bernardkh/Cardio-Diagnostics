package com.example.cardio_diagnostics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

//import androidx.work.Configuration;


/**
 * Created by bkhadra on 8/10/2021.
 */
public class App extends Application implements Application.ActivityLifecycleCallbacks {//, Configuration.Provider

private final String TAG = App.class.getSimpleName();
    private static App sInstance;
    //private Tracker mTracker;
    private Thread.UncaughtExceptionHandler defaultUEH;
    private static App mContext;

    public App() {
        sInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }


    public static App getInstance() {
        return sInstance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onActivityCreated(Activity arg0, Bundle arg1) {
        Log.i("", "onActivityCreated");

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.i("", "onActivityDestroyed ");
    }

    @Override
    public void onActivityPaused(Activity activity) {
        //SharedPreferencesManager.saveBoolean(this, Constants.PREF_IS_APPLICATION_RUNNING, false);
        //Log.i("", "onActivityPaused " + activity.getClass());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        /*SharedPreferencesManager.saveBoolean(this, Constants.PREF_IS_APPLICATION_RUNNING, true);
        Log.i("", "onActivityResumed " + activity.getClass());*/
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.i("", "onActivitySaveInstanceState");

    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.i("", "onActivityStarted");
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.i("", "onActivityStopped");

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
