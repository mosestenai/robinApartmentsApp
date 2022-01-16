package com.example.robin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.robin.api.AbstractAPIListener;

public class addhostelActivity extends AppCompatActivity {
private EditText hostelname,location,landmarks,price_month,paybill,password1,password2,email,phone,rooms,idnumber,username,
    bed_size,floor_size,accountno;
private CheckBox kitchensink,toilet,bed,chair,bathroomsink,gate,bathroom,dustbin,tables,ceiling,matress,router,tiles,hotshower,balcony;
private String  kitchensinkv, toiletv,bedv,chairv,bathroomsinkv,gatev, bathroomv,dustbinv, tablesv,ceilingv, matressv, routerv, tilesv,hotshowerv, balconyv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhostel);

        hostelname= findViewById(R.id.hostel_name);
        location= findViewById(R.id.location);
        landmarks =  findViewById(R.id.landmarks);
        price_month =  findViewById(R.id.price_month);
        paybill =  findViewById(R.id.paybill);
        password1 =  findViewById(R.id.password1);
        password2 =  findViewById(R.id.password2);
        email =  findViewById(R.id.email);
        phone =  findViewById(R.id.phone);
        rooms =  findViewById(R.id.rooms);
        idnumber =  findViewById(R.id.idnumber);
        accountno = findViewById(R.id.accountno);

        kitchensink = findViewById(R.id.kitchensink);
        toilet = findViewById(R.id.toilet);
        bed = findViewById(R.id.bed);
        chair = findViewById(R.id.chair);
        bathroomsink = findViewById(R.id.bathroomsink);
        gate = findViewById(R.id.gate);
        bathroom = findViewById(R.id.bathroom);
        dustbin = findViewById(R.id.dustbin);
        tables = findViewById(R.id.tables);
        ceiling = findViewById(R.id.ceiling);
        matress = findViewById(R.id.matress);
        router = findViewById(R.id.router);
        tiles = findViewById(R.id.tiles);
        hotshower = findViewById(R.id.hotshower);
        balcony = findViewById(R.id.balcony);



        username =  findViewById(R.id.username);
        bed_size =  findViewById(R.id.bed_size);
        floor_size =  findViewById(R.id.floor_size);

        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(view ->{

            String usernamev =username.getText().toString();
            String password1v = password1.getText().toString();
            String password2v = password2.getText().toString();
           String hostelnamev= hostelname.getText().toString();
           String locationv= location.getText().toString();
            String landmarksv =  landmarks.getText().toString();
           String price_monthv =  price_month.getText().toString();
            String paybillv =  paybill.getText().toString();
            String emailv =  email.getText().toString();
            String phonev =  phone.getText().toString();
            String roomsv =  rooms.getText().toString();
            String idnumberv =  idnumber.getText().toString();
            String bed_sizev =  bed_size.getText().toString();
            String floor_sizev = floor_size.getText().toString();
            String accountnov = accountno.getText().toString();

           if(kitchensink.isChecked()){ kitchensinkv = kitchensink.getText().toString(); }else {kitchensinkv = "null";}
           if(toilet.isChecked()){ toiletv = toilet.getText().toString();}else {toiletv="null";}
           if(bed.isChecked()){ bedv = bed.getText().toString();}else{ bedv = "null";}
           if(chair.isChecked()){chairv = chair.getText().toString();}else {chairv="null";}
           if(bathroomsink.isChecked()){bathroomsinkv = bathroomsink.getText().toString();}else {bathroomsinkv= "null";}
           if(gate.isChecked()){ gatev = gate.getText().toString();}else{ gatev="null";}
           if(bathroom.isChecked()){ bathroomv = bathroom.getText().toString();}else{ bathroomv="null";}
           if(dustbin.isChecked()){dustbinv = dustbin.getText().toString();}else{dustbinv = "null";}
           if(tables.isChecked()){tablesv = tables.getText().toString();}else{tablesv="null";}
           if(ceiling.isChecked()){ ceilingv = ceiling.getText().toString();}else {ceilingv = "null";}
           if(matress.isChecked()){matressv= matress.getText().toString();}else {matressv="null";}
           if(router.isChecked()){ routerv = router.getText().toString();}else {routerv= "null";}
           if(tiles.isChecked()){ tilesv = tiles.getText().toString();}else {tilesv="null";}
           if(hotshower.isChecked()){ hotshowerv = hotshower.getText().toString();}else{hotshowerv ="null";}
           if(balcony.isChecked()){ balconyv = balcony.getText().toString();}else{balconyv="null";}





            if(usernamev.length() < 1){
                Toast.makeText(addhostelActivity.this,"username is empty",Toast.LENGTH_LONG).show();
            }else{
                if(!password1v.equals(password2v)){
                    Toast.makeText(addhostelActivity.this,"The two passwords do not match",Toast.LENGTH_LONG).show();
                }else{
                    final ProgressDialog progressDialog = new ProgressDialog(addhostelActivity.this);
                    progressDialog.setMessage("Submitting...");
                    progressDialog.show();
                    final Model model = Model.getInstance(addhostelActivity.this.getApplication());
                    model.addhostel(usernamev,password1v,hostelnamev,locationv,landmarksv,price_monthv,paybillv,emailv,
                            phonev,roomsv,idnumberv,bed_sizev,floor_sizev,kitchensinkv,toiletv,bedv,chairv,bathroomsinkv,gatev,bathroomv,
                            dustbinv,tablesv,ceilingv,matressv,routerv,tilesv,hotshowerv,balconyv,accountnov,new AbstractAPIListener() {
                        @Override
                        public void onaddhostel(User user){
                            model.setUser(user);
                            if(user.getResponse().equals("success")){
                                Toast.makeText(addhostelActivity.this,"House added successfully",Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(addhostelActivity.this, user.getError(), Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    });
                }
            }


        });


    }
}