package com.example.cardio_diagnostics.vholders;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.beans.TaskItem;
import com.example.cardio_diagnostics.cfg.Constants;
import com.example.cardio_diagnostics.interfaces.ParentCallback;
import com.example.cardio_diagnostics.managers.FavoritesManager;
import com.example.cardio_diagnostics.utils.IntentHelper;
import com.example.cardio_diagnostics.utils.LogUtils;
import com.example.cardio_diagnostics.utils.Methods;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;


@NonReusable
@Layout(R.layout.item_task_holder)
public class ItemTaskView {
    private final TaskItem taskItem;
    private final ParentCallback mCallback;
    //private final ParentCallback mCallback;
    private boolean isContinueReading = false;
    private boolean isFavorites = false;
    //private OnProductClickListener listener;
    private boolean matchParent = false;
    //private ProductItemR productItem;


    @View(R.id.imgHolder)
    ImageView imgHolder;

    @View(R.id.tx_title)
    TextView txTitle;

    @View(R.id.tx_info)
    TextView txInfo;

    @View(R.id.tx_time)
    TextView txTime;

    @View(R.id.progressBar)
    ProgressBar progressBar;

     @View(R.id.iv_favorite)
    ImageView ivFavorite;

    @View(R.id.iv_remove_favorite)
    ImageView removeFavorite;


    private Context mContext;

    public ItemTaskView(Context context, TaskItem _taskItem, ParentCallback _mCallback) {
        this.mContext = context;
        this.taskItem = _taskItem;
        this.mCallback = _mCallback;
    }


    /*
     * This method is called when the view is rendered
     * onResolved method could be named anything, Example: onAttach
     */
    @Resolve
    public void onResolved() {

        if (taskItem == null) return;
        populateData(taskItem);
    }

    private void populateData(TaskItem taskItem) {
        String imageurl = taskItem.getImage();
        if (imageurl!=null){
            if (!imageurl.contains("http")) {
                imageurl = "https:" + imageurl;
            }
        }
        checkIfInFavorites();
        Methods.loadImage(imageurl)
                //.resize(0,General.convertDpToPixels(210,CntTxt))
                .placeholder(R.drawable.default_img)
                .error(R.drawable.default_img)
                .into(imgHolder, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        LogUtils.print("", "onError: " + e.getMessage());
                    }
                });
        if(taskItem.getTitle() != null) {
            txTitle.setText(taskItem.getTitle());
        }

        if(taskItem.getInfo() != null) {
            txInfo.setText(taskItem.getInfo());
        }

        if(taskItem.getTime() != null) {
            txTime.setText(taskItem.getTime());
        }

        progressBar.setVisibility(android.view.View.INVISIBLE);

        try {
            if(taskItem.getProgress() != null) {
                int progress = Integer.parseInt(taskItem.getProgress());
                if(progress > 0){
                    progressBar.setProgress(progress);
                    progressBar.setVisibility(android.view.View.VISIBLE);
                }

            }
        }catch (Exception e){
            //Do nothing--------------------------------------------------
        }
    }

    private void checkIfInFavorites() {
        taskItem.setIn_favorite(FavoritesManager.findTaskInFavorites(taskItem.getId()));
        if(taskItem.isIn_favorite()){
            removeFavorite.setVisibility(android.view.View.VISIBLE);
            ivFavorite.setVisibility(android.view.View.GONE);
        }else{
            ivFavorite.setVisibility(android.view.View.VISIBLE);
            removeFavorite.setVisibility(android.view.View.GONE);
        }
    }


    @Click(R.id.iv_favorite)
    public void onAdFavorites() {
        FavoritesManager.addFavorites(taskItem.getId(), txTitle.getText().toString());
        checkIfInFavorites();
        if(this.mCallback != null){
            this.mCallback.onAddToFavorites();
        }
    }

    @Click(R.id.iv_remove_favorite)
    public void onRemoveFromFavorites() {
        FavoritesManager.removeFromFavorites(taskItem.getId());
        checkIfInFavorites();
        if(this.mCallback != null){
            this.mCallback.onAddToFavorites();
        }
    }

    @Click(R.id.mainLay)
    public void onItemClicked() {
        if(taskItem != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.BUNDLE_PARCELABLE, taskItem);
            IntentHelper.openVideoPlayer((Activity)mContext, bundle);
        }
    }
}