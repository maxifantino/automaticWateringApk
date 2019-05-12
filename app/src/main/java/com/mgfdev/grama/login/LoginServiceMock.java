package com.mgfdev.grama.login;

/**
 * Created by Maxi on 08/03/2019.
 */

public class LoginServiceMock implements LoginService {

    public String doLogin (String username, String password){
        return "{\"status_code\":200}";
    }

}
