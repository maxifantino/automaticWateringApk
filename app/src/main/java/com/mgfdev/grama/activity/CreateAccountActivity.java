package com.mgfdev.grama.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mgfdev.grama.R;
import com.mgfdev.grama.adapter.NothingSelectedSpinnerAdapter;
import com.mgfdev.grama.dto.User;
import com.mgfdev.grama.enums.AvailableLanguages;
import com.mgfdev.grama.helper.MessageDialogHelper;
import com.mgfdev.grama.login.LoginModule;
import com.mgfdev.grama.rest.UserService;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by Maxi on 05/03/2019.
 */

public class CreateAccountActivity extends AppCompatActivity {

    private Context ctx;
    private LoginModule loginModule;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this.getApplicationContext();
        userService = UserService.getInstance();
        loginModule = LoginModule.getInstance(ctx);
        setContentView(R.layout.create_account_layout);
        fillLanguageSpinner();
        Button createButton = (Button) this.findViewById(R.id.email_sign_in_button);
        createButton.setOnClickListener(getOnClickListener());
    }

    private View.OnClickListener getOnClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((AutoCompleteTextView) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                String language = ((Spinner) findViewById(R.id.languageSpinner)).getSelectedItem().toString();
                String email = ((EditText) findViewById(R.id.email)).getText().toString();
                boolean created = callCreate(email, username, password, language);
                if (created) {
                    callLogin(username, password);
                }
            }
        };
        return listener;
    }
    private boolean callCreate(String email, String username, String password, String language){
        boolean wasCreated = false;
        if (!validateCreateAction(username, password, language, email)){
            String message = getString(R.string.createUserValidationFailed);
            MessageDialogHelper.showErrorMessage(ctx,getString(R.string.app_name), message);
        }
        else{
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setLanguage(language);
            wasCreated = callCreate(user);
        }

        return wasCreated;
    }
    private boolean validateCreateAction(String username, String password, String language, String email){
        return StringUtils.isNoneBlank(username, password, language, email);
    }

    private boolean callCreate (User user){
        boolean result = false;
        try{
            userService.registerNewUser(user);
            result = true;
        }
        catch (Exception e){
            String message = e.getMessage();
            MessageDialogHelper.showErrorMessage(ctx,getString(R.string.app_name), message);
        }
        return result;
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

    private void fillLanguageSpinner(){
        Spinner languageSpinner = (Spinner) this.findViewById(R.id.languageSpinner);
        List<String> items = AvailableLanguages.stringValues();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, items);
        NothingSelectedSpinnerAdapter noSelectionAdapter = new NothingSelectedSpinnerAdapter(adapter,R.layout.contact_spinner_row_nothing_selected, this);
        languageSpinner.setPrompt(getString(R.string.languageSpinnerPrompt));
        languageSpinner.setAdapter(noSelectionAdapter);
        languageSpinner.setSelection(0);
    }
}
