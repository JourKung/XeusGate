package com.example.nailamundev.xeusgate.models;

/**
 * Created by BenZDeV on 4/10/2017.
 */

public class Topic {
    public String address;
    public String img;
    public String imgHtml;
    public String latitude;
    public String longtitude;
    public String name;


    public Topic(){


    }

    public Topic(String address, String img, String imgHtml, String latitude, String longtitude, String name){


        this.address = address;
        this.img    =   img;
        this.imgHtml = imgHtml;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;


    }


}
