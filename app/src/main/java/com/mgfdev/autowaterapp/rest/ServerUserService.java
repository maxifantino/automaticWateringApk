package com.mgfdev.autowaterapp.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mgfdev.autowaterapp.data.WateringConstants;
import com.mgfdev.autowaterapp.dto.User;

import java.io.IOException;
import java.text.MessageFormat;

public class ServerUserService {

    private RestWebService restService;
    private Gson gson;

    public ServerUserService(){
        restService = RestWebService.getInstance();
        gson = new Gson();
    }

    public String saveUser(User user) throws IOException {
        String body = gson.toJson(user);
        String url = MessageFormat.format(WateringConstants.URL_SAVE_USER,user.getId());
        return restService.doPut(url, body);
    }

    public String createUser(User user) throws IOException{
        String body = gson.toJson(user);
        String url = WateringConstants.URL_CREATE_USER;
        return restService.doPost(url, body);
    }

    public String loginUser(String userName, String password) throws IOException{
        String url =WateringConstants.URL_LOGIN_USER;
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("username", userName);
        jsonBody.addProperty("password",password);
        return restService.doPost(url, jsonBody.getAsString());
    }

}
