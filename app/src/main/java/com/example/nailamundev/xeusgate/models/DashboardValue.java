package com.example.nailamundev.xeusgate.models;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Date;

/**
 * Created by BenZDeV on 4/10/2017.
 */
@IgnoreExtraProperties
public class DashboardValue {

        public  boolean active;
        public String detail;
        public String formula;
        public Date lastUpdateTime;
        public String name;
        public String unit;
        public String value;


    public DashboardValue(){

    }

    public DashboardValue(boolean active, String detail, String formula, Date lastUpdateTime, String name, String unit,
             String value){

        this.active = active;
        this.detail = detail;
        this.formula = formula;
        this.lastUpdateTime = lastUpdateTime;
        this.name = name;
        this.unit = unit;
        this.value = value;


    }


}
