package com.mgfdev.grama.rest;

import com.mgfdev.grama.builder.HttpResponseBuilder;
import com.mgfdev.grama.helper.RestHelperService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RestWebService {

    private RestHelperService restHelper;
    private static int READ_TO = 15000;
    private static int CONNECT_TO = 15000;

    private static String AUTHENTICATION_USERNAME_KEY= "userName";
    private static String AUTHENTICATION_PASSWORD_KEY= "password";

    private static final String USER_AGENT = "Mozilla/5.0";
    private static RestWebService instance;

    public static RestWebService getInstance(){
        if (instance == null){
            instance = new RestWebService();
        }
        return instance;
    }

    private RestWebService(){
        restHelper = RestHelperService.getInstance();
    }

    public Map<String, String>getAuthenticationMap(String username, String password){
        Map<String, String> authenticationMap = new HashMap<>();
        authenticationMap.put(RestWebService.AUTHENTICATION_USERNAME_KEY, username);
        authenticationMap.put(RestWebService.AUTHENTICATION_PASSWORD_KEY, password);
        return authenticationMap;
    }

    public String doDelete (String url) throws IOException {
        return executeDelete(url, null);
    }

    public String doDelete (String url, Map<String, String> authParams) throws IOException {
        return executeDelete(url, authParams);
    }

    public String doDelete (String url,  Map<String, String> parameters, Map<String, String> authParams) throws IOException {
        String queryString =( parameters!= null && !parameters.isEmpty()) ? "?" + restHelper.buildQueryString(parameters): "";
        return executeDelete(url + queryString, authParams);
    }

    public String doGet (String url) throws IOException {
        return executeGet(url, null);
    }

    public String doGet (String url, Map<String, String> authParams) throws IOException {
        return executeGet(url, authParams);
    }

    public String doGet (String url,  Map<String, String> parameters, Map<String, String> authParams) throws IOException {
        String queryString =( parameters!= null && !parameters.isEmpty()) ? "?" + restHelper.buildQueryString(parameters): "";
        return executeGet(url + queryString, authParams);
    }

    public String doPost (String url, String body) throws IOException{
        return executePost(url, null, body);
    }

    public String doPut (String url, String body) throws IOException{
        return executePost(url, null, body);
    }

    public String doPost (String url, Map<String, String> parameters, Map<String,String> authParams, String body) throws IOException{
        return executePost(url, authParams,body );
    }

    private String executeGet(String url, Map<String, String> authenticationHeader) throws IOException {
        URL urlObject = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        if (authenticationHeader != null && !authenticationHeader.isEmpty()){
            String baseAuthStr = authenticationHeader.get(AUTHENTICATION_USERNAME_KEY) + ":" +
                    authenticationHeader.get(AUTHENTICATION_PASSWORD_KEY);
            connection.addRequestProperty("Authorization", "Basic " + baseAuthStr);
        }
        int responseCode = connection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        HttpResponseBuilder builder = new HttpResponseBuilder();
        builder.withMessage(response.toString());
        builder.withHttpCode(responseCode);
        return builder.toString();
    }

    private String executeDelete(String url, Map<String, String> authenticationHeader) throws IOException {
        String getResult = "";
        URL urlObject = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        if (authenticationHeader != null && !authenticationHeader.isEmpty()){
            String baseAuthStr = authenticationHeader.get(AUTHENTICATION_USERNAME_KEY) + ":" +
                    authenticationHeader.get(AUTHENTICATION_PASSWORD_KEY);
            connection.addRequestProperty("Authorization", "Basic " + baseAuthStr);
        }
        int responseCode = connection.getResponseCode();
        System.out.println("DELETE Response Code :: " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        HttpResponseBuilder builder = new HttpResponseBuilder();
        builder.withMessage(response.toString());
        builder.withHttpCode(responseCode);
        return builder.toString();
    }


    private String executePost(String url, Map<String, String> authenticationHeader, String body) throws IOException { //If you want to use get method to hit server
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setReadTimeout(READ_TO);
        connection.setConnectTimeout(CONNECT_TO);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        if (authenticationHeader != null && !authenticationHeader.isEmpty()){
            String baseAuthStr = authenticationHeader.get(AUTHENTICATION_USERNAME_KEY) + ":" +
                    authenticationHeader.get(AUTHENTICATION_PASSWORD_KEY);
            connection.addRequestProperty("Authorization", "Basic " + baseAuthStr);
        }
        connection.addRequestProperty("Content-Type", "application/json");

        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();
        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        HttpResponseBuilder builder = new HttpResponseBuilder();
        builder.withMessage(response.toString());
        builder.withHttpCode(responseCode);
        return builder.toString();

    }

    private String executePut(String url, Map<String, String> authenticationHeader, String body) throws IOException { //If you want to use get method to hit server
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("PUT");
        connection.setRequestProperty("User-Agent", USER_AGENT);
        connection.setReadTimeout(READ_TO);
        connection.setConnectTimeout(CONNECT_TO);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        if (authenticationHeader != null && !authenticationHeader.isEmpty()){
            String baseAuthStr = authenticationHeader.get(AUTHENTICATION_USERNAME_KEY) + ":" +
                    authenticationHeader.get(AUTHENTICATION_PASSWORD_KEY);
            connection.addRequestProperty("Authorization", "Basic " + baseAuthStr);
        }
        connection.addRequestProperty("Content-Type", "application/json");

        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();
        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        HttpResponseBuilder builder = new HttpResponseBuilder();
        builder.withMessage(response.toString());
        builder.withHttpCode(responseCode);
        return builder.toString();
    }
}