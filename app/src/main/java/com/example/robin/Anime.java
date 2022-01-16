package com.example.robin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Anime {
    private String hostelname;
    private String location;
    private String avalrooms;
    private String price;
    private String url;

    public Anime(){

    }
    public static Anime gethostel(JSONObject jsonObject) throws JSONException {
        String hostelname = jsonObject.getString("house");
        String location = jsonObject.getString("location");
        String price = jsonObject.getString("pricemonth");
        String avalrooms = jsonObject.getString("rooms");
        String url = jsonObject.getString("url");

        return new Anime(hostelname,location,price,avalrooms,url);
    }

    public Anime(String hostelname, String location, String avalrooms, String price, String url) {
        this.hostelname = hostelname;
        this.location = location;
        this.avalrooms = avalrooms;
        this.price = price;
        this.url = url;
    }

    public String getHostelname() {
        return hostelname;
    }

    public void setHostelname(String hostelname) {
        this.hostelname = hostelname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvalrooms() {
        return avalrooms;
    }

    public void setAvalrooms(String avalrooms) {
        this.avalrooms = avalrooms;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
