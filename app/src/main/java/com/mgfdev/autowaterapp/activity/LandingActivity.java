package com.mgfdev.autowaterapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mgfdev.autowaterapp.R;
import com.mgfdev.autowaterapp.UserDao;
import com.mgfdev.autowaterapp.dto.User;
import com.mgfdev.autowaterapp.enums.AvailableLanguages;
import com.mgfdev.autowaterapp.service.SharedPreferenceService;

import org.apache.commons.lang3.StringUtils;

public class LandingActivity extends AppCompatActivity {

    private Context ctx;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDao = new UserDao();
        checkLogin();
        setContentView(R.layout.activity_landing);
        setupLayout();
    }

    private void checkLogin(){
        if (StringUtils.isNotEmpty(SharedPreferenceService.getUserName(this))) {
            // call login activity.
        }
    }

    private void setupLayout(){
        Button signinButton = (Button) this.findViewById(R.id.email_sign_in_button);
        signinButton.setOnClickListener(getSigninListener());
        TextView loginTxtView = (TextView) this.findViewById(R.id.email_sign_in_button);
        loginTxtView.setOnClickListener(getSignupListener());
     }

     private View.OnClickListener getSigninListener(){
         View.OnClickListener listener = new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 PopupWindow pop = new PopupWindow(inflater.inflate(R.layout.login_popup_layout, null, false), 300, 300, true);
                 pop.getContentView();
             }
         };
         return listener;
     }

    private View.OnClickListener getSignupListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                PopupWindow pop = new PopupWindow(inflater.inflate(R.layout.create_account_layout, null, false), 300, 300, true);
                pop.getContentView();
            }
        };
        return listener;
    }

    private void saveUser(String email, String username, String password, AvailableLanguages language){
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setLanguage(language);

    }

}
