package com.mgfdev.autowaterapp.rest;

import java.io.IOException;

/**
 * Created by Maxi on 13/01/2019.
 */

public interface ConnectionServerService {
    public String delete(String url) throws IOException;
    public String update (String url, String body) throws IOException;
    public String create (String url, String body) throws IOException;
    public String get (String url) throws IOException;
}
