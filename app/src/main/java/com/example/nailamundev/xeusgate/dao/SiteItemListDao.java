package com.example.nailamundev.xeusgate.dao;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by BenZDeV on 4/10/2017.
 */
@IgnoreExtraProperties
public class SiteItemListDao {


    private List<SiteItemDao> site;


    public List<SiteItemDao> getSite() {
        return site;
    }

    public void setSite(List<SiteItemDao> site) {
        this.site = site;
    }
}
