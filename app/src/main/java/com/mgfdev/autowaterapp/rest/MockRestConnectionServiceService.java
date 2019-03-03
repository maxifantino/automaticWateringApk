package com.mgfdev.autowaterapp.rest;

import com.mgfdev.autowaterapp.dto.Patch;
import com.mgfdev.autowaterapp.enums.AvailableLanguages;

import java.io.IOException;

/**
 * Created by Maxi on 12/01/2019.
 */

public class MockRestConnectionServiceService implements ConnectionServerService{
    private RestWebService webService;
    public MockRestConnectionServiceService(){
        webService = RestWebService.getInstance();
    }

    @Override
    public String delete(String url) throws IOException{
        return "{http_code: 200, message \"Objeto eliminado\"}";
    }

    @Override
    public String update(String url, String body) throws IOException {
        return "{http_code: 200, message \"Objeto Actualizado\"}";
    }

    @Override
    public String create(String url, String body)throws IOException {
        return "{http_code: 201, message \"Objeto creado\"}";
    }

    @Override
    public String get(String url) throws IOException{
        String result = "";
        if (url.contains("user")){
            result = mockUser();
        }
        else if (url.contains("garden")){
            result =  mockGarden();
        }
        else if (url.contains("patch")){
            result=  mockPatch();
        }
        return result;
    }

    private String mockUser(){
        StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":").append(200).append(",");
        builder.append("\"username\":").append("\"maxifantino\"").append(",");
        builder.append("\"password\":").append("\"mypassword\"").append(",");
        builder.append("\"email\":").append("\"maxifantino@gmail.com\"").append(",");
        builder.append("\"name\":").append("\"maximiliano\"").append(",");
        builder.append("\"language\":").append(AvailableLanguages.SPANISH.toString()).append(",");
        builder.append("}");

        return builder.toString();
    }

    private String mockGarden(){
        StringBuilder builder = new StringBuilder("{");
        builder.append("\"id\":" + "10");
        builder.append("\"name\":" + "\"Jardin Canning\"" + ", ");
        builder.append("\"location\":{" + mockLocation() + "}, ");
        builder.append("\"workingDays\":" + "2,3,4,5,7" + ", ");
        builder.append("\"timeWindow\":" + "{\"from\":18, \"to\":20}" + ", ");
        builder.append("\"sprinklers\": [");
        builder.append(mockPatch());
        builder.append("]");
        builder.append("}");
        return builder.toString();
    }

    private String mockPatch(){
        StringBuilder builder = new StringBuilder("{");
        builder.append("\"patchCode\": ").append("\"dsdafmaxi-patch1\"");
        builder.append("\"humidityThreshold\": ").append("60");
        builder.append("\"criticalHumidity\": ").append("40");
        builder.append("\"humidity\": ").append("50");
        builder.append("\"wateringTime\": ").append(400);
        builder.append("\"gardenId\": ").append(10);
        builder.append("\"type\": ").append("\"N/A\"");
        builder.append("\"status\": ").append("\"inactive\"");

        builder.append("}");
        return builder.toString();
    }

    private String mockLocation(){
        StringBuilder builder = new StringBuilder("{");

        builder.append("}");
        return builder.toString();
    }
}
