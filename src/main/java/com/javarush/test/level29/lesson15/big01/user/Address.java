package com.javarush.test.level29.lesson15.big01.user;

/**
 * Created by Mykhailo on 04.09.2016.
 */
public class Address {

    private String country;
    private String city;
    private String house;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return country + " " + city + " " + house;
    }
}
