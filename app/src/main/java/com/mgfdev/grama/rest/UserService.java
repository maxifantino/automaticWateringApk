package com.mgfdev.grama.rest;

import com.mgfdev.grama.dto.User;

/**
 * Created by Maxi on 19/01/2019.
 */

public class UserService {

    private static UserService instance;

    private UserService(){

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void registerNewUser(User user) throws Exception{
    }

}
