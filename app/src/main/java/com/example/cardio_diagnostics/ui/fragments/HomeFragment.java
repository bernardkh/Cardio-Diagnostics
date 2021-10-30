package com.example.cardio_diagnostics.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.beans.TaskClass;
import com.example.cardio_diagnostics.databinding.FragmentHomeBinding;
import com.example.cardio_diagnostics.interfaces.ParentCallback;
import com.example.cardio_diagnostics.managers.FavoritesManager;
import com.example.cardio_diagnostics.utils.LogUtils;
import com.example.cardio_diagnostics.utils.Methods;
import com.example.cardio_diagnostics.utils.placeHolderView.PHV;
import com.example.cardio_diagnostics.utils.recyclerview.DividerItemDecoratorNoLast;
import com.example.cardio_diagnostics.vholders.HorizontalPlaceHolderView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements ParentCallback {


    private FragmentHomeBinding fragmentHomeBinding;
    private long timeWhenStopped = 0;
    //private Chronometer chronometer;
    private Context mContext;
    private PHV phv;
    private double maxTasks;
    ArrayList<TaskClass> ItemsAr;
    private ProgressBar progressBar;
    private AppCompatTextView txScore;

    public HomeFragment() {
        // Required empty public constructor
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = fragmentHomeBinding.getRoot();
        mContext = view.getContext();
        return view;
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ItemsAr = new ArrayList<TaskClass>();

        JSONObject jsonObject = Methods.convertStringToObject(R.raw.home_page_data, "mainNode", mContext);
        if(jsonObject != null){
            maxTasks = jsonObject.optInt("tasks_numb");
            JSONArray tasksArray = jsonObject.optJSONArray("tasks");
            if(tasksArray != null){
                int i = -1;
                int Ln = tasksArray.length();
                TaskClass task;
                JSONObject MyJson;
                while (++i < Ln) {
                    MyJson = tasksArray.optJSONObject(i);
                    task = new TaskClass();
                    task.parseJson(mContext, MyJson);
                    ItemsAr.add(task);
                }
                LogUtils.print("ItemsAr:"+ItemsAr);
                if(ItemsAr.size() > 0){
                    setupViews();
                }
            }
        }

    }

    //----------------------------------------------------------------------------------------------
    

    private void setupViews() {
        phv = fragmentHomeBinding.placeHolder;
        phv.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LogUtils.print("TAG", "HomePageContentView");
            }
        });

        progressBar = fragmentHomeBinding.progressBar;
        progressBar.setProgress(0);
        txScore = fragmentHomeBinding.txScore;

        phv.getBuilder()
                .setHasFixedSize(false)
                .setLayoutManager(new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.VERTICAL,
                        false));
        phv.addItemDecoration(new DividerItemDecoratorNoLast(ContextCompat.getDrawable(phv.getContext(), R.drawable.divider_12dp), true, false));
        phv.setNestedScrollingEnabled(true);
        for (TaskClass taskClass : ItemsAr) {
            phv.addView(new HorizontalPlaceHolderView(mContext, taskClass, this));
        }


    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void onStop() {
        super.onStop();

    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAddToFavorites() {
        LogUtils.print("onAddToFavorites");
        int tasksDone = FavoritesManager.SumOfTaskInFavorites();
        int progress = (int)((tasksDone/maxTasks)*100);
        progressBar.setProgress(progress);
        txScore.setText(progress+"/100");
        
    }

    @Override
    public void onRemoveFromFavorites() {
        LogUtils.print("onRemoveFromFavorites");
        int tasksDone = FavoritesManager.SumOfTaskInFavorites();
        int progress = (int)((tasksDone/maxTasks)*100);
        progressBar.setProgress(progress);
        txScore.setText(progress+"/100");
    }
}