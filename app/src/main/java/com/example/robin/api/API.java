package com.example.robin.api;

public interface API {
    void landlord(String id,APIListener listener);
    void login(String username, String password,APIListener listener);
    void register(String username,String password,String email,APIListener listener);
    void hostels(String id,APIListener listener);
    void addhostel(String usernamev, String password1v, String hostelnamev, String locationv,
                   String landmarksv,String price_monthv, String paybillv, String emailv,
                   String phonev, String roomsv, String idnumberv, String bed_sizev, String floor_sizev, String kitchensinkv,
                   String toiletv, String bedv, String chairv, String bathroomsinkv, String gatev, String bathroomv,
                   String dustbinv, String tablesv, String ceilingv, String matressv, String routerv, String tilesv, String hotshowerv,
                   String balconyv,String accountno,APIListener listener);
}

