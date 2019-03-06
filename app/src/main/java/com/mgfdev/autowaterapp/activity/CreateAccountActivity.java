package com.mgfdev.autowaterapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mgfdev.autowaterapp.R;
import com.mgfdev.autowaterapp.UserDao;
import com.mgfdev.autowaterapp.adapter.NothingSelectedSpinnerAdapter;
import com.mgfdev.autowaterapp.enums.AvailableLanguages;

import java.util.List;

/**
 * Created by Maxi on 05/03/2019.
 */

public class CreateAccountActivity extends AppCompatActivity {

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this.getApplicationContext();
        setContentView(R.layout.create_account_layout);
        fillLanguageSpinner();
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
