package com.mgfdev.grama.data;

/**
 * Created by Maxi on 12/01/2019.
 */

public class WateringConstants {

    public static final String URL_DELETE_GARDENS="/garden/{0}?userId={1}";
    public static final String URL_PUT_GARDEN="/garden/{0}?userId={1}";
    public static final String URL_POST_GARDEN="/garden";
    public static final String URL_GET_GARDEN="/user/{0}/gardens";

    public static final String URL_POST_SPRINKLER ="/garden/{0}/patch?userId={1}";
    public static final String URL_DELETE_SPRINKLER ="/garden/{0}/patch?userId={1}&patchId={2}}";
    public static final String URL_PUT_SPRINKLER = "/garden/{0}/patch?gardenId={1}";
    public static final String URL_GET_SPRINKLER = " /garden/{0}/patch?patchId={1}";
    public static final String SERVER_CONNECTION_TYPE = "server";
    public static final String GOOGLE_CONNECTION_TYPE = "google";
    public static final String URL_LOGIN_USER = "/user/login";
    public static final String URL_CREATE_USER = "/user/create";
    public static final String URL_SAVE_USER = "/user?userId={0}";
}
