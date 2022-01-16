package com.example.robin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class student extends AppCompatActivity {
Button hostel,hotels,services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        hostel = findViewById(R.id.hostels);
        hotels = findViewById(R.id.hotels);
        services = findViewById(R.id.services);

        hostel.setOnClickListener(View ->{
            Intent intent = new Intent(student.this,SearchActivity.class);
            startActivity(intent);


        });

    }
}