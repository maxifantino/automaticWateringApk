package com.mgfdev.autowaterapp.rest;

import com.google.gson.Gson;
import com.mgfdev.autowaterapp.data.WateringConstants;
import com.mgfdev.autowaterapp.dto.Garden;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by Maxi on 12/01/2019.
 */

public class RestConnectionServiceService implements ConnectionServerService{
    private RestWebService webService;
    public RestConnectionServiceService(){
        webService = RestWebService.getInstance();
    }

    @Override
    public String delete(String url) throws IOException{
        return webService.doDelete(url);
    }

    @Override
    public String update(String url, String body) throws IOException {
        return webService.doPut(url, body);
    }

    @Override
    public String create(String url, String body)throws IOException {
        return webService.doPost(url, body);
    }

    @Override
    public String get(String url) throws IOException{
        return webService.doGet(url);
    }
}
