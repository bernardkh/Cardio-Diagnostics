package com.example.cardio_diagnostics.components.alert_dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.cardio_diagnostics.R;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by bkhadra on 8/10/2021.
 */
public class CustomAlertDialog {

    private AlertDialog dialog;

    public CustomAlertDialog(Context context, String message) {
        dialog = getProgressDialog(context, message);
    }

    public CustomAlertDialog(Context context) {
        this(context, null);
    }

    public void setCancelable(boolean cancelable) {
        if (dialog != null) {
            dialog.setCancelable(cancelable);
        }
    }

    public void show() {
        dialog.show();
    }

    private static AlertDialog getProgressDialog(Context context, String message) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context, R.style.CustomDialog);
        final View dialogView = LayoutInflater.from(context).inflate(R.layout.progress_dialog, null);
        AVLoadingIndicatorView progressBar = (AVLoadingIndicatorView) dialogView.findViewById(R.id.progressBar);
        TextView loadingText = (TextView) dialogView.findViewById(R.id.loadingText);
        if (message != null) {
            loadingText.setText(message);
            loadingText.setVisibility(View.VISIBLE);
        }
        /*progressBar.getIndeterminateDrawable().setColorFilter(0xFFFFFFFF,
                android.graphics.PorterDuff.Mode.MULTIPLY);*/
        dialogBuilder.setView(dialogView);
        dialogBuilder.setCancelable(false);
        return dialogBuilder.create();
    }

    public void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public boolean isShowing() {
        return dialog != null && dialog.isShowing();
    }
}