package com.example.cardio_diagnostics.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.beans.TaskItem;
import com.example.cardio_diagnostics.cfg.Constants;
import com.example.cardio_diagnostics.databinding.ActivityVideoPlayerBinding;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.Util.*;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


/**
 * Created by bkhadra on 3/18/2020.
 */

public class VideoPDFActivity extends Activity {

    private ActivityVideoPlayerBinding activityVideoPlayerBinding;
    private Context mContext;
    private String Title;
    private YouTubePlayerView youTubePlayerView;
    private PDFView pdfView;
    private String videoId;
    private String pdfURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityVideoPlayerBinding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        View view = activityVideoPlayerBinding.getRoot();
        mContext = view .getContext();
        setContentView(view);
        init();
    }


    private void init() {
        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            if (mBundle.containsKey(Constants.BUNDLE_PARCELABLE)) {
                TaskItem taskItem = mBundle.getParcelable(Constants.BUNDLE_PARCELABLE);
                if (taskItem != null && taskItem.getVideoURL() != null) {
                    videoId = taskItem.getVideoURL();
                    pdfURL = taskItem.getPdfURL();

                    Title = taskItem.getTitle();
                    setupViews();
                    if(videoId != null && !videoId.isEmpty()){
                        setupVideoPlayer();
                    }else if(pdfURL != null && !pdfURL.isEmpty()){
                        setupPDFViewer();
                    }
                }
            }
        }
    }

    private void setupPDFViewer() {
        youTubePlayerView.setVisibility(View.GONE);
        pdfView.fromAsset(pdfURL)
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10)
                .load();
    }

    private void setupVideoPlayer() {
        pdfView.setVisibility(View.GONE);
        //VideoPlayerActivity.this.getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }


    public void setupViews() {
        youTubePlayerView = activityVideoPlayerBinding.youTubePlayerView;
        pdfView = activityVideoPlayerBinding.pdfView;
        if(Title != null){
            activityVideoPlayerBinding.txTitle.setText(Title);
        }

        activityVideoPlayerBinding.closeBtn.setOnClickListener(v -> onBackPressed());

        
    }



    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
        youTubePlayerView.release();
    }

    @Override
    public void onStop() {
        super.onStop();
        youTubePlayerView.release();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /*@OnClick(R.id.closeBtn)
    public void onViewClicked() {
        onBackPressed();
    }*/


}
