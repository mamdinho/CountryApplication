package com.example.countryapplication;

public class Country {
    int countryImage;
    int countryName;


    Country(int image, int name){
        this.countryName = name;
        this.countryImage = image;
    }

    public int getCountryName(){
        return countryName;
    }

    public int getCountryImage(){
        return countryImage;
    }

}
