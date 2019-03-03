package com.mgfdev.autowaterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mgfdev.autowaterapp.dto.User;
import com.mgfdev.autowaterapp.helper.DataBaseHelper;

/**
 * Created by Maxi on 24/02/2019.
 */

public class UserDao {

    public void saveUser (Context ctx, User user)
    {
        DataBaseHelper dbHelper = new DataBaseHelper(ctx);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // create new user
        ContentValues newRow = new ContentValues();
        newRow.put("username", user.getUsername());
        newRow.put("password", user.getPassword());
        newRow.put("email", user.getEmail());
        newRow.put("language", user.getLanguage().toString());

        Long userID = db.insert("USERS", null, newRow);
        user.setId(userID.intValue());
        db.close();
        dbHelper.close();
    }
}
