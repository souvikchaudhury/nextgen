package com.example.dhritiman.yugyugjiyo;

/**
 * Created by Dhritiman on 3/16/2017.
 */

public class DataModel {
    private String id, name, banner_image, hospname, price;
    //imgURL,feedName, content;
    // private int rating;

    public DataModel(String id,String name, String banner_image,String hospname, String price) {
        this.id=id;
        //  this.logo = logo;
        this.banner_image = banner_image;
        this.name = name;
        this.hospname = hospname;
        this.price = price;
    }

    public String getId(){

        return id;
    }

    // public String getLogo() {
    //  return logo;
    //

    public String getBanner_image() {

        return banner_image;
    }

    public String getName() {
        return name;
    }

    public String getHospname() {
        return hospname;
    }


    public String getPrice() {
        return price;
    }
}

