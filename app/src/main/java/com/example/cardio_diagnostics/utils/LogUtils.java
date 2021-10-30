package com.example.cardio_diagnostics.utils;

import android.text.TextUtils;

import com.example.cardio_diagnostics.BuildConfig;


/**
 * Created by ahariss on 4/3/18.
 */

public class LogUtils {

    /**
     * Method accepts dynamic number of parameters
     * Printed as a whole string seperated by column
     * Only printed in debug mode
     * @param messages
     */
    public static void print(String... messages) {
        if (BuildConfig.DEBUG) {
            System.out.println(TextUtils.join(":", messages));
        }
    }
}
