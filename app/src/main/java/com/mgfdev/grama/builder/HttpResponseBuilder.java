package com.mgfdev.grama.builder;

import org.json.JSONObject;

public class HttpResponseBuilder{

    public static final String HTTP_RESPONSE_CODE = "http_code";
    public static final String HTTP_RESPONSE_MESSAGE = "http_message";

    private String message;
    private int httpCode;

    public HttpResponseBuilder withMessage(String message){
        this.message = message;
        return this;
    }

    public HttpResponseBuilder withHttpCode(int httpCode){
        this.httpCode = httpCode;
        return this;
    }

    public String toString(){
        JSONObject response = new JSONObject();
        try{
            response.put(HTTP_RESPONSE_CODE, httpCode);
            response.put(HTTP_RESPONSE_MESSAGE, message);
        }
        catch (Exception e){
            System.out.print("Error intentando serializar respuesta.");
        }
        return response.toString();
    }

}