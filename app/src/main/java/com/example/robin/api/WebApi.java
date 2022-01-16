package com.example.robin.api;

import  android.app.Application;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.robin.User;


import org.json.JSONException;
import org.json.JSONObject;

public class WebApi implements API {

   public static final String BASE_URL = "https://robincomfort.herokuapp.com/";

   private final Application mApplication;
   private final RequestQueue mRequestQueue;


   public WebApi(Application application){
       mApplication = application;
       mRequestQueue = Volley.newRequestQueue(application);
    }
//login any user
    public void login(String username,String password,final APIListener listener){
       String url = BASE_URL + "troj/apis/login_users_api.php?5$fgk=hh";
       JSONObject jsonObject = new JSONObject();


       try {

          jsonObject.put("username",username);
          jsonObject.put("password",password);

          Response.Listener<JSONObject> successListener = response -> {


             try {
                User user = User.getUser(response);
                listener.onLogin(user);
                }
             catch (JSONException e) {
                try {
                   User error =User.getErr(response);
                   listener.onLogin(error);
                  // Toast.makeText(mApplication, "ERROR: "+ error.getError(), Toast.LENGTH_LONG).show();

                } catch (JSONException jsonException) {
                   Toast.makeText(mApplication, "There was an error try again later", Toast.LENGTH_LONG).show();
                }
             }
          };


          Response.ErrorListener errorListener = error ->{
             if (error instanceof com.android.volley.NoConnectionError) {
                Toast.makeText(mApplication, "No internet access", Toast.LENGTH_LONG).show();
             }else{
                Toast.makeText(mApplication, "There was an error", Toast.LENGTH_LONG).show();
             }
          };

          JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,jsonObject,successListener,errorListener);
          mRequestQueue.add(request);
       } catch (JSONException e) {
          Toast.makeText(mApplication, "json exception", Toast.LENGTH_LONG).show();
       }

    }
    //Register student
    public void register(String username,String password,String email,final APIListener listener){
       String url = BASE_URL + "troj/apis/register_users_api.php?5$fgk=hh";
       JSONObject jsonObject = new JSONObject();


       try {

          jsonObject.put("username",username);
          jsonObject.put("password",password);
          jsonObject.put("email",email);

          Response.Listener<JSONObject> successListener = response -> {
             try {
                User user = User.getUser(response);
                listener.onRegister(user);
             }
             catch (JSONException e) {
                try {
                  User error = User.getErr(response);
                  Toast.makeText(mApplication, "ERROR: "+ error.getError(), Toast.LENGTH_LONG).show();
                } catch (JSONException jsonException) {
                   Toast.makeText(mApplication, "There was an error try again later", Toast.LENGTH_LONG).show();
                }

             }

          };


          Response.ErrorListener errorListener = error -> {
             //Log.v("Response",error.toString());
             if (error instanceof com.android.volley.NoConnectionError) {
                Toast.makeText(mApplication, "No internet access", Toast.LENGTH_LONG).show();
             }

          };

          JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,jsonObject,successListener,errorListener);
          mRequestQueue.add(request);
       } catch (JSONException e) {
          Toast.makeText(mApplication, "json exception", Toast.LENGTH_LONG).show();
       }

    }
    //displaying landlord items
   public void landlord(String id, APIListener listener) {
      String url = BASE_URL + "troj/apis/landlord_api.php?5$fgk=hh";
      JSONObject jsonObject = new JSONObject();


      try {

         jsonObject.put("id",id);


         Response.Listener<JSONObject> successListener = response -> {
            try {
               User user = User.getlandlord(response);
               listener.landlordview(user);

            }
            catch (JSONException e) {
               try {
                  User error = User.getErr(response);
                  Toast.makeText(mApplication, "ERROR: "+ error.getError(), Toast.LENGTH_LONG).show();
               } catch (JSONException jsonException) {
                  Toast.makeText(mApplication, "There was an error try again later", Toast.LENGTH_LONG).show();
               }

            }

         };


         Response.ErrorListener errorListener = error -> {
            //Log.v("Response",error.toString());
            if (error instanceof com.android.volley.NoConnectionError) {
               Toast.makeText(mApplication, "No internet access", Toast.LENGTH_LONG).show();
            }

         };

         JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,jsonObject,successListener,errorListener);
         mRequestQueue.add(request);
      } catch (JSONException e) {
         Toast.makeText(mApplication, "json exception", Toast.LENGTH_LONG).show();
      }

   }

   //View hostels
   public void hostels(String id, APIListener listener) {

   }
   // add hostel
   public void addhostel(String usernamev, String password1v, String hostelnamev, String locationv,
                         String landmarksv,String price_monthv, String paybillv, String emailv,
                         String phonev, String roomsv, String idnumberv, String bed_sizev, String floor_sizev, String kitchensinkv,
                         String toiletv, String bedv, String chairv, String bathroomsinkv, String gatev, String bathroomv,
                         String dustbinv, String tablesv, String ceilingv, String matressv, String routerv, String tilesv, String hotshowerv,
                         String balconyv,String accountno, final APIListener listener){
Toast.makeText(mApplication,kitchensinkv,Toast.LENGTH_SHORT).show();
      String url = BASE_URL + "troj/apis/add_house_api.php?5$fgk=hh";
      JSONObject jsonObject = new JSONObject();
      try {
         jsonObject.put("hostelname",hostelnamev);
         jsonObject.put("location",locationv);
         jsonObject.put("landmarks",landmarksv);
         jsonObject.put("price_month",price_monthv);
         jsonObject.put("paybill",paybillv);
         jsonObject.put("email",emailv);
         jsonObject.put("phone",phonev);
         jsonObject.put("rooms",roomsv);
         jsonObject.put("idnumber",idnumberv);
         jsonObject.put("bed_size",bed_sizev);
         jsonObject.put("floor_size",floor_sizev);
         jsonObject.put("username",usernamev);
         jsonObject.put("password",password1v);
         jsonObject.put("kitchensink",kitchensinkv);
         jsonObject.put("toilet",toiletv);
         jsonObject.put("bed",bedv);
         jsonObject.put("chair",chairv);
         jsonObject.put("bathroomsink",bathroomsinkv);
         jsonObject.put("gate",gatev);
         jsonObject.put("bathroom",bathroomv);
         jsonObject.put("dustbin",dustbinv);
         jsonObject.put("tables",tablesv);
         jsonObject.put("ceiling",ceilingv);
         jsonObject.put("matress",matressv);
         jsonObject.put("router",routerv);
         jsonObject.put("tiles",tilesv);
         jsonObject.put("hotshower",hotshowerv);
         jsonObject.put("balcony",balconyv);
         jsonObject.put("accountno",accountno);

         Response.Listener<JSONObject> successListener = response -> {
            try {
               User user = User.gethostel(response);
               listener.onaddhostel(user);
            }
            catch (JSONException e) {
               try {
                  User error =User.getErr(response);
                  listener.onaddhostel(error);

               } catch (JSONException jsonException) {
                  Toast.makeText(mApplication, "There was an error try again later", Toast.LENGTH_LONG).show();
               }
            }
         };


         Response.ErrorListener errorListener = error ->{
            if (error instanceof com.android.volley.NoConnectionError) {
               Toast.makeText(mApplication, "No internet access", Toast.LENGTH_LONG).show();
            }else{
               Toast.makeText(mApplication, "There was an error", Toast.LENGTH_LONG).show();
            }
         };

         JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,jsonObject,successListener,errorListener);
         mRequestQueue.add(request);
      } catch (JSONException e) {
         Toast.makeText(mApplication, "json exception", Toast.LENGTH_LONG).show();
      }

   }

}
