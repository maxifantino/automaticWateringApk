package com.mgfdev.grama.helper;
/**
 * Created by Maxi on 12/01/2019.
 */
import java.util.Map;

public class RestHelperService {

    private static RestHelperService instance;

    private RestHelperService(){}

    public static RestHelperService getInstance(){
     if (instance == null){
            instance = new RestHelperService();
        }
        return instance;
    }

    public String buildQueryString (Map<String, String> params){
        StringBuilder queryString = new StringBuilder();
        Integer index=0;
        int paramsQuantity = params.keySet().size();
        for (String key : params.keySet()){
            queryString.append(key +"="+params.get(key));
            queryString.append(++index <paramsQuantity ? "?": "");

        }
        return queryString.toString();
    }

}
