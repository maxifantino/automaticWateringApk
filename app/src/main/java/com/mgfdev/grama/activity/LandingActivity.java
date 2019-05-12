package com.mgfdev.grama.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mgfdev.grama.R;
import com.mgfdev.grama.UserDao;
import com.mgfdev.grama.service.SharedPreferenceService;

import org.apache.commons.lang3.StringUtils;

public class LandingActivity extends AppCompatActivity {

    private Context ctx;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this.getApplicationContext();
        userDao = new UserDao();
        checkLogin();
        setContentView(R.layout.activity_landing);
        setupLayout();
    }

    private void checkLogin(){
        if (StringUtils.isNotEmpty(SharedPreferenceService.getUserName(this))) {
            Intent newIntent = new Intent(ctx, HomeActivity.class);
            startActivity(newIntent);
        }
    }

    private void setupLayout(){
        Button signinButton = (Button) this.findViewById(R.id.email_sign_in_button);
        signinButton.setOnClickListener(getSigninListener());
        TextView signuUpButton = (TextView) this.findViewById(R.id.loginLinkText);
        formatAsLink(signuUpButton);
        signuUpButton.setOnClickListener(getSignupListener());
     }

     private void formatAsLink(final TextView view){
         final CharSequence viewText = view.getText();
         final SpannableString notClickedString = new SpannableString(viewText);
         notClickedString.setSpan(new URLSpan(""), 0, notClickedString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
         view.setText(notClickedString, TextView.BufferType.SPANNABLE);
         final SpannableString clickedString = new SpannableString(notClickedString);
         clickedString.setSpan(new BackgroundColorSpan(Color.GRAY), 0, notClickedString.length(),
                 Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
         view.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(final View v, final MotionEvent event) {
                 switch (event.getAction()) {
                     case MotionEvent.ACTION_DOWN:
                         view.setText(clickedString);
                         break;
                     case MotionEvent.ACTION_UP:
                         view.setText(notClickedString, TextView.BufferType.SPANNABLE);
                         v.performClick();
                         break;
                     case MotionEvent.ACTION_CANCEL:
                         view.setText(notClickedString, TextView.BufferType.SPANNABLE);
                         break;
                 }
                 return true;
             }
         });
     }

     private View.OnClickListener getSigninListener(){
         View.OnClickListener listener = new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent newIntent = new Intent(ctx, LoginActivity.class);
                 startActivity(newIntent);
             }
         };
         return listener;
     }

    private View.OnClickListener getSignupListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(ctx, CreateAccountActivity.class);
                startActivity(newIntent);
            }
        };
        return listener;
    }

}
