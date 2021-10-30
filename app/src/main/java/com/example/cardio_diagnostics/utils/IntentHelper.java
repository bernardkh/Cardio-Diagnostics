package com.example.cardio_diagnostics.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.ui.activities.VideoPDFActivity;


/**
 * Created by Bernard Khadra on 3/9/16.
 */
public class IntentHelper {


    public static void openVideoPlayer(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, VideoPDFActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_up, R.anim.stay);
    }
}
