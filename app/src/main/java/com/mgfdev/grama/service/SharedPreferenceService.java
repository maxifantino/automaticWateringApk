package com.mgfdev.grama.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Maxi on 24/02/2019.
 */

public class SharedPreferenceService {
    static final String PREF_USER_NAME= "username";

    private static SharedPreferences getInstance(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUsername(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getInstance(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public static String getUserName(Context ctx)
    {
        return getInstance(ctx).getString(PREF_USER_NAME, "");
    }
}
