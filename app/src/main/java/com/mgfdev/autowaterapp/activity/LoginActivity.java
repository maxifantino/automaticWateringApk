package com.mgfdev.autowaterapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mgfdev.autowaterapp.R;

/**
 * Created by Maxi on 05/03/2019.
 */

public class LoginActivity extends AppCompatActivity {

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this.getApplicationContext();
        setContentView(R.layout.activity_landing);
    }
}
