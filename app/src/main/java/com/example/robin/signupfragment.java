package com.example.robin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class signupfragment extends Fragment {
    SurfaceControl.Transaction transaction;
Button login;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_register,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login = view.findViewById(R.id.login);



        login.setOnClickListener(v ->{
            AppCompatActivity activity =(AppCompatActivity)view.getContext();
            loginfragment myFragment = new loginfragment();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,myFragment).commit();
        });
    }
}
