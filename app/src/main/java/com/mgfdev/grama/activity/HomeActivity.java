package com.mgfdev.grama.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.mgfdev.grama.R;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        createNavigationMenu();
        setNavigationMenu(navigation);
    }

    private void createNavigationMenu(){
        navigation = (BottomNavigationView) findViewById(R.id.navigationMenu);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = createNavigationHandler();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setNavigationMenu(BottomNavigationView navigation){
        navigation.setItemIconTintList(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener createNavigationHandler(){
        BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                View layout;
                boolean result = false;
                setAllLayoutsInvisible();
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        layout = findViewById(R.id.mapsLayout);
                        layout.setVisibility(View.VISIBLE);
                        result = true;
                        break;
                    case R.id.navigation_brewers:
                        layout = findViewById(R.id.brewersLayout);
                        layout.setVisibility(View.VISIBLE);
                        result = true;
                        break;
                    case R.id.navigation_settings:
                        layout = findViewById(R.id.settingsLayout);
                        layout.setVisibility(View.VISIBLE);
                        result = true;
                        break;
                }
                return result;
            }
        };
        return navigationListener;
    }


    private void setAllLayoutsInvisible() {
        View layoutSeetings = findViewById(R.id.settingsLayout);
        layoutSeetings.setVisibility(View.INVISIBLE);
        View statisticsLayout = findViewById(R.id.statisticsLayout);
        statisticsLayout.setVisibility(View.INVISIBLE);
        View homeLayout = findViewById(R.id.homeLayout);
        homeLayout.setVisibility(View.INVISIBLE);
    }

}
