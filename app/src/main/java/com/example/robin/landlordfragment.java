package com.example.robin;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.robin.api.AbstractAPIListener;

public class landlordfragment extends Fragment {
   private ProgressDialog progressDialog;
    private TextView hostel,price,rooms,avalrooms,location,profile_url,landmarks;
    private TextView slot1,bathroomsink,kitchensink,bathroom,balcony,toilet,bed,matress,hotshower,rooter, dustbin,gate,chair,tiles,ceiling,id;
public ProgressDialog setProgress(){
    if(progressDialog == null){
        progressDialog = new ProgressDialog(landlordfragment.this.getActivity());
    }
    progressDialog.setCancelable(false);
    progressDialog.show();
    return progressDialog;
}
public void dismissDialog(){
    if(progressDialog != null && progressDialog.isShowing())progressDialog.dismiss();
}
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      ProgressDialog progressDialog = setProgress();
        progressDialog.setMessage("Fetching items...");
        progressDialog.show();
        return inflater.inflate(R.layout.activity_landlord,container,false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        hostel = view.findViewById(R.id.hostel_name);
        price= view.findViewById(R.id.price);
        rooms= view.findViewById(R.id.textView6);
        avalrooms= view.findViewById(R.id.textView8);
        location= view.findViewById(R.id.textView7);
        profile_url= view.findViewById(R.id.textView9);
        landmarks= view.findViewById(R.id.textView10);
        slot1= view.findViewById(R.id.textView11);
        bathroomsink = view.findViewById(R.id.textView12);
        kitchensink= view.findViewById(R.id.textView13);
        bathroom = view.findViewById(R.id.textView14);
        balcony= view.findViewById(R.id.textView15);
        toilet= view.findViewById(R.id.textView16);
        bed= view.findViewById(R.id.textView17);
        matress= view.findViewById(R.id.textView18);
        hotshower= view.findViewById(R.id.textView19);
        dustbin= view.findViewById(R.id.textView20);
        gate= view.findViewById(R.id.textView21);



        final Model model = Model.getInstance(landlordfragment.this.getActivity().getApplication());
        model.landlord(id, new AbstractAPIListener() {
            @Override
            public void landlordview(User user) {
                model.setUser(user);
                hostel.setText(user.getHostel()); price.setText(user.getPrice());rooms.setText(user.getRooms());balcony.setText(user.getBalcony());
                gate.setText(user.getGate());dustbin.setText(user.getDustbin());hotshower.setText(user.getHotshower());
                matress.setText(user.getMatress());bed.setText(user.getBed());toilet.setText(user.getToilet());bathroom.setText(user.getBathroom());
                kitchensink.setText(user.getKitchensink());bathroomsink.setText(user.getBathroomsink());landmarks.setText(user.getLandmarks());
                avalrooms.setText(user.getAvalrooms());location.setText(user.getLocation());
               dismissDialog();



            }


        });

    }

}
