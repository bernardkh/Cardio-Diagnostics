package com.example.cardio_diagnostics.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.listeners.OnClickAlertListener;

/**
 * Created by bkhadra on 8/10/2021.
 */

public class Dialogs {

    public static void exitDialog(final Activity mContext){
        AlertDialog.Builder alert = new AlertDialog.Builder(mContext, R.style.AlertDialogTheme);
        alert.setTitle(mContext.getResources().getString(R.string.exit));
        alert.setMessage(mContext.getResources().getString(R.string.exit_msg));
        alert.setPositiveButton(mContext.getResources().getString(R.string.yes),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mContext.finish();
                    }
                });
        alert.setNegativeButton(mContext.getResources().getString(R.string.no),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alert.create();
        alert.show();
    }

    //--------------------------------------------------------------------------------------------------
    public static void showAlert(final Context mContext, String Title, String notification, final OnClickAlertListener listener) {
        try{
            showAlert(mContext, Title, notification, null, null, true, listener);
        }catch (Exception e){
            //TODO--------------------------------
        }
    }
    //--------------------------------------------------------------------------------------------------
    public static void showAlert(final Context mContext, String Title, String notification, String okTxt, String noTxt, final OnClickAlertListener listener) {
        try{
            showAlert(mContext, Title, notification, okTxt, noTxt, true, listener);
        }catch (Exception e){
            //TODO--------------------------------
        }
    }
    //--------------------------------------------------------------------------------------------------
    public static void showAlert(final Context mContext, String title, String notification, String okTxt, String noTxt, boolean isCancelable, final OnClickAlertListener listener) {
        try {

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AlertDialogTheme);
            if(title != null){
                builder.setTitle(title);
            }
            if(notification != null){
                builder.setMessage(notification);
            }


            builder.setPositiveButton(mContext.getResources().getString(R.string.ok),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            /*builder.setNegativeButton(mContext.getResources().getString(R.string.no),
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });*/
            // set the custom layout
            //final View customLayout = ((Activity) mContext).getLayoutInflater().inflate(R.layout.custom_alert_layout, null);
            //builder.setView(customLayout);

            final AlertDialog dialog = builder.create();
            //dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            //dialog.setCancelable(false);
            /*final TextView txDesc = customLayout.findViewById(R.id.tx_desc);
            final TextView txTitle = customLayout.findViewById(R.id.tx_title);

            TextView yes = customLayout.findViewById(R.id.btn_create);
            TextView no = customLayout.findViewById(R.id.btn_cancel);*/
            /*if(listener == null)no.setVisibility(View.GONE);
            if(title != null && !title.isEmpty()){
                txTitle.setText(title);
            }else{
                txTitle.setVisibility(View.GONE);
            }
            if(notification != null)txDesc.setText(notification);
            if(okTxt != null){
                yes.setText(okTxt);
            }
            if(noTxt != null){
                no.setText(noTxt);
            }
            yes.setOnClickListener(view -> {
                if (listener != null) {
                    listener.onClickOk();
                }
                dialog.cancel();
            });
            no.setOnClickListener(view -> {
                dialog.cancel();
            });

            dialog.setOnShowListener(dialog1 -> {
                //Methods.showSoftKeyboard((BaseActivity) mContext);
            });*/

            dialog.setCancelable(false);
            dialog.show();

            /*if(notification.contains(Constants.NO_INTERNET_ERROR))return;
            Title = "";
            final AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AlertDialogTheme);
            builder.setTitle(Title);
            builder.setMessage(notification);
            builder.setPositiveButton(mContext.getString(R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            if (listener != null) {
                                listener.onClickOk();
                            }
                        }
                    });

            builder.setCancelable(isCancelable);
            builder.create();
            builder.show();*/
        } catch (Exception e) {

        }
    }

    //--------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------

}
