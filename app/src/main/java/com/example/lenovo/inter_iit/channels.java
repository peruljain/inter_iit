package com.example.lenovo.inter_iit;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class channels extends AppCompatActivity {
    String url = "http://192.168.43.232:3000/api/find";
    List<channel> channelList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.channels);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        channelList = new ArrayList<>();

        channelList.add(
                new channel("Game of Thrones","https://st1.bollywoodlife.com/wp-content/uploads/2018/11/game-of-thrones-nouveau-trailer-saison-6.jpeg","5pm to 6pm","2 hours"
                        ));
        channelList.add(
                new channel("BREAKING BAD","https://images.amcnetworks.com/amc.com/wp-content/uploads/2010/12/breaking-bad-S5-400x600-compressedV1.jpg","8pm to 9pm","1 hours"
                        ));
        channelList.add(
                new channel("Sherlock Homes","https://cdn3.movieweb.com/i/article/NHgFRRYq288ZVGuvPSA5Ky5c5gCvSn/798:50/Sherlock-Holmes-3-Story-Details-Jude-Law.jpg","8pm to 10pm","2 hours"
                ));
        channeladapter channeladapter = new channeladapter(this,channelList);
        recyclerView.setAdapter(channeladapter);




    }
}



