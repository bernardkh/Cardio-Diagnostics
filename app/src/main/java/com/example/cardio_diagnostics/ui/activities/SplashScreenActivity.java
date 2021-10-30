package com.example.cardio_diagnostics.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.cardio_diagnostics.App;
import com.example.cardio_diagnostics.cfg.Constants;
import com.example.cardio_diagnostics.managers.SharedPreferencesManager;


public class SplashScreenActivity extends Activity {

    FrameLayout placeholder;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getApplicationContext();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(() -> {
            //if(SharedPreferencesManager.getBoolean(App.getContext(), Constants.isLoggedIn,false)){
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            /*}else{
                startActivity(new Intent(SplashScreenActivity.this, SignInActivity.class));
            }*/

            finish();
        }, 1500);

    }
}
