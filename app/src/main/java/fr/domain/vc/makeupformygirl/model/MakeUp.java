package fr.domain.vc.makeupformygirl.model;

import com.google.gson.annotations.SerializedName;

public class MakeUp {
    @SerializedName("id")
    private String id;

    @SerializedName("brand")
    private String brand;

    @SerializedName("name")
    private String name;


    @SerializedName("image_link")
    private String image_link;

    /*
    @SerializedName("price_sign")
    private String price_sign;

    @SerializedName("currency")
    private String currency;

    @SerializedName("category")
    private String category;*/


    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName(){
   return name;
   }

    public String getImage_link() {
        return image_link;
    }
/*
    public String getPrice_sign() {
        return price_sign;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCategory() {
        return category;
    }*/
}
