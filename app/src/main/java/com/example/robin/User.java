package com.example.robin;


import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    public static User getUser(JSONObject jsonObject) throws JSONException{
        String token = jsonObject.getString("token");
        String username = jsonObject.getString("username");
        String permission = jsonObject.getString("permission");
        String id = jsonObject.getString("id");

        return new User(token,username,permission,id);
    }
    public static User gethostel(JSONObject jsonObject)throws  JSONException{
        String response = jsonObject.getString("response");

        return new User(response);
    }
    public static User getlandlord(JSONObject jsonObject) throws JSONException{
        String hostel = jsonObject.getString("hostel name");
        String  price = jsonObject.getString("price");
        String rooms = jsonObject.getString("rooms");
        String  avalrooms = jsonObject.getString("avalrooms");
        String location = jsonObject.getString("location");
        String  profile_url = jsonObject.getString("profile_url");
        String landmarks = jsonObject.getString("landmarks");
        String slot1 = jsonObject.getString("slot1");
        String bathroomsink = jsonObject.getString("bathroomsink");
        String kitchensink = jsonObject.getString("kitchensink");
        String bathroom = jsonObject.getString("bathroom");
        String balcony = jsonObject.getString("balcony");
        String  toilet = jsonObject.getString("toilet");
        String bed = jsonObject.getString("bed");
        String matress = jsonObject.getString("matress");
        String hotshower = jsonObject.getString("hotshower");
        String rooter = jsonObject.getString("rooter");
        String dustbin = jsonObject.getString("dustbin");
        String gate = jsonObject.getString("gate");
        String chair = jsonObject.getString("chair");
        String tiles = jsonObject.getString("tiles");
        String ceiling = jsonObject.getString("ceiling");
        String id = jsonObject.getString("id");

        return new User(hostel,price,rooms,avalrooms,location,profile_url,landmarks,slot1,bathroomsink,kitchensink,bathroom,balcony,toilet,bed,matress,hotshower,rooter, dustbin,gate,chair,tiles,ceiling,id);
    }
    public static User getErr(JSONObject jsonObject) throws JSONException{
        String error =  jsonObject.getString("error");
        String permission = "test";
        String response= "test";


        return new User(error,permission,response);
    }
    private String response;
    private String token;
    private String username;
    private String permission;
    private String id;
    private String error;
    private String hostel;private String price;private String rooms;private String avalrooms;private String location;private String profile_url;
    private String landmarks;private String slot1;private String bathroomsink;private String kitchensink;private String bathroom;private String balcony;private String toilet;
    private String bed;private String matress;private String hotshower;private String rooter;private String dustbin;private String gate;private String chair;
    private String tiles;private String ceiling;


public User (String response){
    this.response = response;
}
    public User (String token,String username, String permission, String id){
        this.username = username;
        this.permission = permission;
        this.token = token;
        this.id = id;
    }
    public User (String error,String permission,String response){
        this.error =error;
        this.response = response;
        this.permission=permission;
    }
    public User (String hostel,String price,String rooms,String avalrooms,String location,String profile_url,String landmarks,String slot1,
                 String bathroomsink,String kitchensink,String bathroom,String balcony,String toilet,String bed,String matress,String hotshower,
                 String rooter, String dustbin,String gate,String chair,String tiles,String ceiling,String  id){
        this.hostel = hostel;this.price=price;this.rooms=rooms;this.avalrooms=avalrooms;this.location=location;this.profile_url=profile_url;
        this.landmarks=landmarks;this.slot1=slot1;this.bathroomsink=bathroomsink;this.kitchensink=kitchensink;this.bathroom=bathroom;
        this.balcony=balcony;this.toilet=toilet;this.bed=bed;this.matress=matress;this.hotshower=hotshower;this.rooter=rooter; this.dustbin=dustbin;
        this.gate=gate;this.chair=chair;this.tiles=tiles;this.ceiling=ceiling;this.id=id;
    }


    public String getHostel() { return hostel; }public String getPrice() { return price; }public String getAvalrooms() { return avalrooms; }
    public String getRooms() { return rooms; }public String getLandmarks() { return landmarks; }public String getLocation() { return location; }
    public String getProfile_url() { return profile_url; }public String getBalcony() { return balcony; }public String getBathroom() { return bathroom; }
    public String getBathroomsink() { return bathroomsink; }public String getBed() { return bed; }public String getCeiling() { return ceiling; }
    public String getChair() { return chair; }public String getDustbin() { return dustbin; }public String getGate() { return gate; }
    public String getHotshower() { return hotshower; }public String getKitchensink() { return kitchensink; }public String getMatress() { return matress; }
    public String getSlot1() { return slot1; }public String getRooter() { return rooter; }public String getToilet() { return toilet; }public String getTiles() { return tiles; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getError() { return error; }
    public String getResponse() { return response;}
    public void setResponse(String response){ this.response = response;}

    public void setError(String error) { this.error = error; }

    public String getPermission() { return permission; }

    public void setPermission(String permission) { this.permission = permission; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof User) {
            User that = (User) obj;
            if (this.username.equalsIgnoreCase(that.username)) {
                result = true;
            }
        }
        return result;
    }


    @Override
    public String toString() {
        return this.username + "(" + this.username + ")";
    }

}
