package com.devleoperyogi.recyclerview;

public class contactModel {
    int img;
    String name;
    String number;
    public contactModel(int img, String name, String number){
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public contactModel(String name, String number){
        this.name = name;
        this.number = number;
    }
}
