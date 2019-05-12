package com.mgfdev.grama.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.mgfdev.grama.R;
import com.mgfdev.grama.helper.MessageDialogHelper;
import com.mgfdev.grama.login.LoginModule;

/**
 * Created by Maxi on 05/03/2019.
 */

public class LoginActivity extends AppCompatActivity {

    private Context ctx;
    private LoginModule loginModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this.getApplicationContext();
        loginModule = LoginModule.getInstance(ctx);
        setContentView(R.layout.login_popup_layout);
        setLoginButton();
    }

    private void setLoginButton(){
        Button loginBtn = (Button) this.findViewById(R.id.email_sign_in_button);
        loginBtn.setOnClickListener(getOnClickListener());
    }

    private View.OnClickListener getOnClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((AutoCompleteTextView) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                callLogin(username, password);
            }
        };
        return listener;
    }

    private void callLogin(String username, String password){
        try {
            boolean result = loginModule.execute(username, password);
            if (result) {
                Intent newIntent = new Intent(ctx, HomeActivity.class);
                startActivity(newIntent);
            }
            else{
                MessageDialogHelper.showErrorMessage(ctx,getString(R.string.app_name), getString(R.string.loginError));
            }
        }
        catch (Exception e){
            String error = e.getMessage();
            MessageDialogHelper.showErrorMessage(ctx,getString(R.string.app_name), error);
        }
    }
}
