package com.example.robin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.robin.api.AbstractAPIListener;

public class landlordActivity extends AppCompatActivity {

    private TextView hostel,price,rooms,avalrooms,location,profile_url,landmarks;
   private TextView slot1,bathroomsink,kitchensink,bathroom,balcony,toilet,bed,matress,hotshower,rooter, dustbin,gate,chair,tiles,ceiling,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord);
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching items...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        hostel = findViewById(R.id.hostel_name);
        price= findViewById(R.id.price);
        rooms= findViewById(R.id.textView6);
        avalrooms= findViewById(R.id.textView8);
        location= findViewById(R.id.textView7);
        profile_url= findViewById(R.id.textView9);
        landmarks= findViewById(R.id.textView10);
        slot1= findViewById(R.id.textView11);
        bathroomsink = findViewById(R.id.textView12);
        kitchensink= findViewById(R.id.textView13);
        bathroom = findViewById(R.id.textView14);
        balcony= findViewById(R.id.textView15);
        toilet= findViewById(R.id.textView16);
        bed= findViewById(R.id.textView17);
        matress= findViewById(R.id.textView18);
        hotshower= findViewById(R.id.textView19);
        dustbin= findViewById(R.id.textView20);
        gate= findViewById(R.id.textView21);



            final Model model = Model.getInstance(landlordActivity.this.getApplication());
            model.landlord(id, new AbstractAPIListener() {
                @Override
                public void landlordview(User user) {
                    model.setUser(user);
                    hostel.setText(user.getHostel()); price.setText(user.getPrice());rooms.setText(user.getRooms());balcony.setText(user.getBalcony());
                   gate.setText(user.getGate());dustbin.setText(user.getDustbin());hotshower.setText(user.getHotshower());
                   matress.setText(user.getMatress());bed.setText(user.getBed());toilet.setText(user.getToilet());bathroom.setText(user.getBathroom());
          kitchensink.setText(user.getKitchensink());bathroomsink.setText(user.getBathroomsink());landmarks.setText(user.getLandmarks());
          avalrooms.setText(user.getAvalrooms());location.setText(user.getLocation());

                    progressDialog.dismiss();


                }


            });


    }
}