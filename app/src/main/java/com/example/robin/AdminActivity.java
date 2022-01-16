package com.example.robin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {
    Button addhostel, addhotel,viewusers,blockusers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        addhostel = findViewById(R.id.addhostel);
        addhotel = findViewById(R.id.addhotel);
        viewusers = findViewById(R.id.viewusers);
        blockusers = findViewById(R.id.blockusers);


        //go to add hostel  page
        addhostel.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this, addhostelActivity.class);
            startActivity(intent);
        });
        //go to add hotel page
        addhotel.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this, addhostelActivity.class);
            startActivity(intent);
        });
        //go to view users page
        viewusers.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this, addhostelActivity.class);
            startActivity(intent);
        });
        //go to block users page
        blockusers.setOnClickListener(view -> {
            Intent intent = new Intent(AdminActivity.this, addhostelActivity.class);
            startActivity(intent);
        });
    }
}