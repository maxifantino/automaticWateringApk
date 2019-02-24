package com.mgfdev.autowaterapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mgfdev.autowaterapp.R;
import com.mgfdev.autowaterapp.service.SharedPreferenceService;

import org.apache.commons.lang3.StringUtils;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkLogin();
        setContentView(R.layout.activity_landing);
    }

    private void checkLogin(){
        if (StringUtils.isEmpty(SharedPreferenceService.getUserName(this))) {
            // call login activity.
        }
    }
}
