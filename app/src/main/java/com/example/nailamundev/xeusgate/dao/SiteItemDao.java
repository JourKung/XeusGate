package com.example.nailamundev.xeusgate.dao;

import com.google.firebase.database.IgnoreExtraProperties;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BenZDeV on 4/10/2017.
 */
@IgnoreExtraProperties
public class SiteItemDao {


    @SerializedName("address")              private  String address;
    @SerializedName("img")                  private  String img;
    @SerializedName("imgHtml")              private  String imgHtml;
    @SerializedName("latitude")             private  String latitude;
    @SerializedName("longtitude")           private  String longtitude;
    @SerializedName("name")                 private  String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgHtml() {
        return imgHtml;
    }

    public void setImgHtml(String imgHtml) {
        this.imgHtml = imgHtml;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
