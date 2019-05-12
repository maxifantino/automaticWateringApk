package com.mgfdev.grama.rest;

import com.google.gson.Gson;
import com.mgfdev.grama.data.WateringConstants;
import com.mgfdev.grama.dto.Garden;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by Maxi on 12/01/2019.
 */

public class ServerGardenService {

    private RestWebService restService;
    private Gson gson;
    public ServerGardenService(){
        restService = RestWebService.getInstance();
        gson = new Gson();
    }
/// refactorizar. Hacer 1 clase que resuelva todo, arme el JSON y llame al servicio De conexion q corresponda. Si es REST. que arme URL sino, NO!.
    public String saveGarden(Garden garden) throws IOException {
        String body = gson.toJson(garden);
        String url = MessageFormat.format(WateringConstants.URL_PUT_GARDEN, garden.getId(), garden.getUser().getId());
        return restService.doPut(url, body);
    }

    public String createGarden(Garden garden) throws IOException{
        String body = gson.toJson(garden);
        String url = WateringConstants.URL_POST_GARDEN;
        return restService.doPut(url, body);
    }

    public String deleteGarden(Garden garden) throws IOException{
        String url = MessageFormat.format(WateringConstants.URL_DELETE_GARDENS, garden.getId(), garden.getUser().getId());
        return restService.doDelete(url);
    }

    public String getGardens(Garden garden) throws IOException{
        String url = MessageFormat.format(WateringConstants.URL_GET_GARDEN, garden.getId());
        return restService.doDelete(url);
    }
}
