package com.example.cardio_diagnostics.utils;

import android.content.Context;
import android.os.Build;

import androidx.core.content.ContextCompat;

import com.example.cardio_diagnostics.BuildConfig;
import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.beans.BitmapTransform;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Methods {

    //--------------------------------------------------------------------------------------------------
    public static boolean isEmailValid(String email) {
        return isEmailValid(email, false);
    }

    public static boolean isEmailValid(String email, boolean allowifempty) {
        boolean isValid = false;
        if (allowifempty) {
            if (email.equals("")) {
                return true;
            }
        }


        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    //-----------------------------------------------------------------------------
    public static JSONObject convertStringToObject(int ID, String mainNode, Context MymContext) {
        InputStream jsonStream = MymContext.getResources().openRawResource(ID);
        JSONObject jsonObject = null;
        JSONObject MyJson = null;
        try {
            jsonObject = new JSONObject(convertStreamToString(jsonStream));
            MyJson = jsonObject.getJSONObject(mainNode);
            return MyJson;
        } catch (JSONException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    //-----------------------------------------------------------------------------
    private static String convertStreamToString(InputStream is)
            throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, StandardCharsets.UTF_8));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
    //-----------------------------------------------------------------------------
    public static String getCurrentDate() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US).format(new Date());
    }
    //-----------------------------------------------------------------------------
    public static String getErrorMessage(Context context, Throwable t) {
        String errorMessage = "";
        if (BuildConfig.DEBUG) {
            errorMessage = t.getMessage();
        } else {
            if (t instanceof UnknownHostException) {
                //no_internet_dialog_message
                errorMessage = context.getString(R.string.general_error_unknownhost);
            } else if (t instanceof SocketTimeoutException) {
                errorMessage = context.getString(R.string.general_error_timeout);
            } else if (t instanceof IOException) {
                errorMessage = context.getString(R.string.general_error_timeout);
            } else {
                errorMessage = context.getString(R.string.general_error);
            }
        }
        return errorMessage;
    }
    //-----------------------------------------------------------------------------
    public static RequestCreator loadImage(String path) {
        if (path != null && (path.isEmpty() || path.trim().isEmpty())) {
            path = null;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // Do something for lollipop and above versions
            return Picasso.get().load(path);//.transform(new BitmapTransform(850, 850));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Do something for lollipop and above versions
            return Picasso.get().load(path).transform(new BitmapTransform(500, 500));
        } else {
            // do something for phones running an SDK before lollipop
            return Picasso.get().load(path).transform(new BitmapTransform(400, 400));
        }
    }
    //-----------------------------------------------------------------------------
    public static int getColor(Context context, int id) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }

}