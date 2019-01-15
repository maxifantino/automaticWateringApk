package com.mgfdev.autowaterapp.enums;

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

}
