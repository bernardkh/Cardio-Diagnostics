package com.example.cardio_diagnostics.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.cardio_diagnostics.R;
import com.example.cardio_diagnostics.databinding.ActivityMainBinding;
import com.example.cardio_diagnostics.ui.fragments.HomeFragment;
import com.example.cardio_diagnostics.utils.Dialogs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding activityMainBinding;
    private Context mContext;
    private NavController navController = null;
    private NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        mContext = view .getContext();
        setContentView(view);
        setupViews();
    }

    //----------------------------------------------------------------------------------------------
    private void setupViews() {
        navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if(navHostFragment != null){
            navController = navHostFragment.getNavController();

            navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
                if(navController.getCurrentDestination() != null){
                    //toolbarTitle.setText(navController.getCurrentDestination().getLabel());
                }
            });
        }

    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void onBackPressed() {
        Log.i("onBackPressed", navHostFragment+"");
        Fragment currentFragment = getCurrentFragment();
        if(currentFragment instanceof HomeFragment){
            Dialogs.exitDialog(MainActivity.this);
            return;
        }
        super.onBackPressed();
    }

    //----------------------------------------------------------------------------------------------
    private Fragment getCurrentFragment() {
        return navHostFragment.getChildFragmentManager().getFragments().get(0);
    }
}