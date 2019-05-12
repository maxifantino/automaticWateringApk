package com.mgfdev.grama.rest;

import com.google.gson.Gson;
import com.mgfdev.grama.data.WateringConstants;
import com.mgfdev.grama.dto.Garden;
import com.mgfdev.grama.dto.Patch;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * Created by Maxi on 12/01/2019.
 */

public class ServerPatchService {

    private RestWebService restService;
    private Gson gson;

    public ServerPatchService(){
        restService = RestWebService.getInstance();
        gson = new Gson();
    }

    public String savePatch(Patch patch) throws IOException {
        String body = gson.toJson(patch);
        String url = MessageFormat.format(WateringConstants.URL_PUT_SPRINKLER, patch.getGarden().getId(), patch.getId());
        return restService.doPut(url, body);
    }

    public String createPatch(Patch patch) throws IOException{
        String body = gson.toJson(patch);
        String url = WateringConstants.URL_POST_SPRINKLER;
        return restService.doPost(url, body);
    }

    public String deletePatch(Patch patch) throws IOException{
        Garden garden = patch.getGarden();
        String url = MessageFormat.format(WateringConstants.URL_DELETE_SPRINKLER, garden.getId(), garden.getUser().getId(),patch.getId());
        return restService.doDelete(url);
    }

    public String getPatch(Patch patch) throws IOException{
        String url = MessageFormat.format(WateringConstants.URL_GET_SPRINKLER, patch.getGarden().getId(), patch.getId());
        return restService.doDelete(url);
    }
}
