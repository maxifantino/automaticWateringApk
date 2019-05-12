package com.mgfdev.grama.rest;

import java.io.IOException;

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
