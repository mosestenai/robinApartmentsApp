package com.example.robin;
import  android.app.Application;

import com.example.robin.api.API;
import com.example.robin.api.APIListener;
import com.example.robin.api.AbstractAPIListener;
import com.example.robin.api.WebApi;
import com.example.robin.api.AbstractAPIListener;

public class Model {
    //to make sure there is only one instance of a model class
    private static  Model sInstance = null;

    private final API mApi;
    private User mUser;

    public static Model getInstance(Application application) {

        if (sInstance == null) {
            sInstance = new Model(application);
        }return  sInstance;
    }

    private final Application mApplication;
    private Model(Application application) {
        mApplication = application;
        mApi = new WebApi(mApplication);
    }
    public Application getApplication() { return mApplication;}


    public void login(String username, String password, AbstractAPIListener listener){
        mApi.login(username, password, listener);
    }
    public  void register(String username,String password, String email,APIListener listener){
        mApi.register(username,password,email,listener);
    }
    public void landlord(String id, AbstractAPIListener listener){
        mApi.landlord(id,listener);
    }
    protected void addhostel(String usernamev, String password1v, String hostelnamev, String locationv,
                             String landmarksv, String price_monthv, String paybillv, String emailv,
                             String phonev, String roomsv, String idnumberv, String bed_sizev, String floor_sizev, String kitchensinkv,
                             String toiletv, String bedv, String chairv, String bathroomsinkv, String gatev, String bathroomv,
                             String dustbinv, String tablesv, String ceilingv, String matressv, String routerv, String tilesv, String hotshowerv,
                             String balconyv, String accountno, AbstractAPIListener listener){
        mApi.addhostel(usernamev,password1v,hostelnamev,locationv,landmarksv,price_monthv,paybillv,emailv,phonev,roomsv,
                idnumberv,bed_sizev, floor_sizev,kitchensinkv,toiletv,bedv,chairv,bathroomsinkv,gatev,bathroomv,dustbinv,tablesv,ceilingv,
                matressv,routerv,tilesv,hotshowerv,balconyv,accountno, listener);
    }

    public User getUser() {
        return mUser;
    }
   public void seterror(User error){this.mUser= error ;}
    public void setUser(User user) {
        this.mUser = user;
    }
}

