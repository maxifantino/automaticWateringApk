package com.mgfdev.grama.service;

import com.mgfdev.grama.dto.Garden;
import com.mgfdev.grama.enums.ConnectionMode;
import com.mgfdev.grama.rest.ConnectionResolverService;
import com.mgfdev.grama.rest.ConnectionServerService;

import java.util.List;

/**
 * Created by Maxi on 12/01/2019.
 */

public class GardenService {

    public static GardenService instance;
    public static ConnectionServerService connectionService;

    private GardenService(){
        connectionService = ConnectionResolverService.getInstance().resolve(ConnectionMode.MOCK);
    }

    public static GardenService getInstance(){
        if (instance == null){
            instance = new GardenService();
        }
        return instance;
    }

    public List<Garden> getGardens(){
        connectionService.ge
    }

    public void saveGarden(){

    }

    public void updateGarden(){

    }

}
