package com.mgfdev.autowaterapp.login;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mgfdev.autowaterapp.dto.User;
import com.mgfdev.autowaterapp.service.SharedPreferenceService;

import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by Maxi on 29/10/2017.
 */

public class LoginModule {
    private Context context;
    private static User user;

    private static LoginModule instance ;
    private LoginService loginService;

    public static LoginModule getInstance(Context ctx){
        if (instance == null){
            instance = new LoginModule(ctx);
        }
        return instance;
    }

    private LoginModule(Context context){
        this.context = context;
        this.loginService = new LoginServiceMock();
    }

    public boolean execute(String username, String password) throws Exception{
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) ){
            throw (new RuntimeException("Username/Password could not be empty"));
        }
        boolean result = parseLoginResponse(loginService.doLogin(username, password));
        markUserAsLogged(username);
        return result;
    }

    private boolean parseLoginResponse(String response){
        Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> tokens = new Gson().fromJson(response, mapType);
        return "200".equals(tokens.get("status_code"));
    }

    public void markUserAsLogged(String username){
         SharedPreferenceService.setUsername(context,username);
    }
}
