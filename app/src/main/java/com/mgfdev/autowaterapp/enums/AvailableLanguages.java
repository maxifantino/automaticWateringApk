package com.mgfdev.autowaterapp.enums;

import java.util.ArrayList;
import java.util.List;

public enum AvailableLanguages {

    ENGLISH ("English"),
    SPANISH ("Español");

    private String name;

    private AvailableLanguages(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public static List<String> stringValues(){
        List<String> result = new ArrayList<String>();
        result.add(AvailableLanguages.ENGLISH.toString());
        result.add(AvailableLanguages.SPANISH.toString());
        return result;
    }

}
