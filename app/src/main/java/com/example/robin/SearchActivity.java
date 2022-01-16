package com.example.robin;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.List;


public class SearchActivity extends AppCompatActivity {
    private List<Anime> lstAnime;
    private RecyclerView recyclerView;
    Button view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        view = findViewById(R.id.view);

       /* view.setOnClickListener(View ->{
            Intent intent = new Intent(SearchActivity.this,ViewHostelActivity.class);
            startActivity(intent.putExtra("id", user.getId()));
        });
*/

        lstAnime = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Appartments...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        String JSON_URL = "https://robin.herokuapp.com/troj/apis/fetch_house_api.php?5$fgk=hh";
        JSONObject jsonObject = null;

        try {



            Response.Listener<JSONArray> successListener = response -> {


            for (int i = 0; i < response.length(); i++) {

                try {
                    Anime anime=Anime.gethostel(response.getJSONObject(i));
                    anime.setHostelname(anime.getHostelname());
                    anime.setPrice(anime.getPrice());
                    anime.setAvalrooms(anime.getAvalrooms());
                    anime.setLocation(anime.getLocation());
                    anime.setUrl(anime.getUrl());
                    progressDialog.dismiss();
                    lstAnime.add(anime);

                } catch (JSONException e) {
                    Toast.makeText(SearchActivity.this, "There was an error displaying the results,try again later", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();

                }

            }
            setuprecycleview(lstAnime);

        }; Response.ErrorListener errorListener = error ->{
                if (error instanceof com.android.volley.NoConnectionError) {
                    setContentView(R.layout.error);
                    Toast.makeText(SearchActivity.this, "No internet access", Toast.LENGTH_LONG).show();
                }else{
                    setContentView(R.layout.error);
                    Toast.makeText(SearchActivity.this, "No response,Make sure you have a strong internet connection", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            };
            JsonArrayRequest request = new JsonArrayRequest(JSON_URL,successListener,errorListener);
        RequestQueue requestQueue = Volley.newRequestQueue(SearchActivity.this);
        requestQueue.add(request);


    } catch (Exception e) {
            Toast.makeText(SearchActivity.this, "json exception", Toast.LENGTH_LONG).show();
        }

}

    private void setuprecycleview(List<Anime> lstAnime) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
    }
    /*
public class SearchActivity extends AppCompatActivity {
    private List<Anime> lstAnime;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        lstAnime = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        String JSON_URL = "https://eazistey.co.ke/troj/apis/fetch_hostel_api.php?5$fgk=hh";
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, response -> {
            JSONObject jsonObject = null;

            for (int i = 0; i < response.length(); i++) {

                try {

                    jsonObject = response.getJSONObject(i);
                    Anime anime = new Anime();
                    anime.setHostelname(jsonObject.getString("hostelname"));
                    anime.setPrice(jsonObject.getString("price"));
                    anime.setAvalrooms(jsonObject.getString("avalrooms"));
                    anime.setLocation(jsonObject.getString("location"));
                    anime.setUrl(jsonObject.getString("url"));
                    lstAnime.add(anime);

                } catch (JSONException e) {
                  Toast.makeText(SearchActivity.this,"There was an error",Toast.LENGTH_LONG).show();

                }

            }
            setuprecycleview(lstAnime);

        }, error -> {
             Toast.makeText(SearchActivity.this,"No results found",Toast.LENGTH_LONG).show();
        });

        RequestQueue requestQueue = Volley.newRequestQueue(SearchActivity.this);
        requestQueue.add(request);
    }

    private void setuprecycleview(List<Anime> lstAnime) {
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }

}*/

