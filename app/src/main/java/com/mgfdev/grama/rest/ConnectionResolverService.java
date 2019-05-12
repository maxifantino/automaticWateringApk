package com.mgfdev.grama.rest;

import com.mgfdev.grama.enums.ConnectionMode;

/**
 * Created by Maxi on 07/04/2019.
 */

public class ConnectionResolverService {

    private static MockRestConnectionServiceService mockService;
    private static GoogleDriveConnectionService googleService;
    private static RestConnectionServiceService serverService;
    private static ConnectionResolverService instance;

    private ConnectionResolverService(){
        mockService = new MockRestConnectionServiceService();
        googleService = new GoogleDriveConnectionService();
        serverService = new RestConnectionServiceService();
    }

    public static ConnectionResolverService getInstance(){
        if (instance == null){
            instance = new ConnectionResolverService();
        }
        return instance;
    }

    public static ConnectionServerService resolve(ConnectionMode mode){
        ConnectionServerService connectionService;
        if (ConnectionMode.GOOGLE_DRIVE.equals(mode)){
            connectionService = googleService;
        }
        else if (ConnectionMode.SERVER.equals(mode)){
            connectionService = serverService;
        }
        else if (ConnectionMode.MOCK.equals(mode)){
            connectionService = mockService;
        }
        else{ // TODO: Local not supported yet
            connectionService = mockService;
        }
        return connectionService;
    }

}
