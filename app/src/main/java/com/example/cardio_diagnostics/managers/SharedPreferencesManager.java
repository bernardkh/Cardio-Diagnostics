package com.example.cardio_diagnostics.managers;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.cardio_diagnostics.cfg.Constants;

import java.util.Set;


/**
 * Created by bkhadra on 8/10/2021.
 */
public class SharedPreferencesManager {

    private static final String SHARED_PREFS_FILE_NAME = Constants.SHARED_PREF_NAME;

    //-----------------------------------------------------------------------------
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }
    //-----------------------------------------------------------------------------
    //Save Booleans
    public static void saveBoolean(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).apply();
    }
    //-----------------------------------------------------------------------------
    //Get Booleans
    public static boolean getBoolean(Context context, String key) {
        return getPrefs(context).getBoolean(key, false);
    }
    //-----------------------------------------------------------------------------
    //Get Booleans if not found return a predefined default value
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getPrefs(context).getBoolean(key, defaultValue);
    }
    //-----------------------------------------------------------------------------
    //Strings
    public static void saveString(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).apply();
    }
    //-----------------------------------------------------------------------------
    public static String getString(Context context, String key) {
        return getPrefs(context).getString(key, "");
    }
    //-----------------------------------------------------------------------------
    public static String getString(Context context, String key, String defaultValue) {
        return getPrefs(context).getString(key, defaultValue);
    }
    //-----------------------------------------------------------------------------
    //Integers
    public static void saveInt(Context context, String key, int value) {
        SharedPreferences.Editor pref = getPrefs(context).edit().putInt(key, value);
        pref.apply();
    }
    //-----------------------------------------------------------------------------
    public static int getInt(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }
    //-----------------------------------------------------------------------------
    public static int getInt(Context context, String key, int defaultValue) {
        return getPrefs(context).getInt(key, defaultValue);
    }
    //-----------------------------------------------------------------------------
    //Floats
    public static void saveFloat(Context context, String key, float value) {
        getPrefs(context).edit().putFloat(key, value).apply();
    }
    //-----------------------------------------------------------------------------
    public static float getFloat(Context context, String key) {
        return getPrefs(context).getFloat(key, 0);
    }
    //-----------------------------------------------------------------------------
    public static float getFloat(Context context, String key, float defaultValue) {
        return getPrefs(context).getFloat(key, defaultValue);
    }
    //-----------------------------------------------------------------------------
    //Longs
    public static void saveLong(Context context, String key, long value) {
        getPrefs(context).edit().putLong(key, value).apply();
    }
    //-----------------------------------------------------------------------------
    public static long getLong(Context context, String key) {
        return getPrefs(context).getLong(key, 0);
    }
    //-----------------------------------------------------------------------------
    public static long getLong(Context context, String key, long defaultValue) {
        return getPrefs(context).getLong(key, defaultValue);
    }
    //-----------------------------------------------------------------------------
    //StringSets
    public static void saveStringSet(Context context, String key, Set<String> value) {
        getPrefs(context).edit().putStringSet(key, value).apply();
    }
    //-----------------------------------------------------------------------------
    public static Set<String> getStringSet(Context context, String key) {
        return getPrefs(context).getStringSet(key, null);
    }
    //-----------------------------------------------------------------------------
    public static Set<String> getStringSet(Context context, String key, Set<String> defaultValue) {
        return getPrefs(context).getStringSet(key, defaultValue);
    }

    //-----------------------------------------------------------------------------

    public static boolean checkIfKeyPrefExist(Context mContext, String Key) {
        return getPrefs(mContext).contains(Key);
    }

    //-----------------------------------------------------------------------------
    public static boolean clearKeyPref(Context mContext, String Key) {
        SharedPreferences.Editor editor = getPrefs(mContext).edit();
        editor.remove(Key).apply();
        return true;
    }
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
}