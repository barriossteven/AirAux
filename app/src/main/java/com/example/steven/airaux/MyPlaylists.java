package com.example.steven.airaux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.*;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyPlaylists extends AppCompatActivity {

    public TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_playlists);
        results = (TextView)findViewById(R.id.result);
        populate();

    }

    public void populate() {

        //need auth token

        RequestQueue queue = Volley.newRequestQueue(this);
        String yourUrl = "https://api.spotify.com/v1/me/playlists";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, yourUrl, null ,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    results.setText("Response: " + response.toString());
                }},
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    results.setText("no response ");
                }}
        ) {
          @Override
           public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<>();
                        // Basic Authentication
                        //String auth = "Basic " + Base64.encodeToString(CONSUMER_KEY_AND_SECRET.getBytes(), Base64.NO_WRAP);
                        headers.put("Accept:","application/json");
                        headers.put("Authorization", "Bearer " + "BQAv5goo1An9sKURVP3Z3AwKSqaEtThDjcUup75DbvBojcXVxgJ3c9s9UP4UIyf9QUIDS-21N7WcZF7-dzJsqaSVdlGMk2uso60Hw-w9x8JwL1dU4PEDKfriQJdLO2HTwzNYc8dWl2S61p_5f53RxTIGEFV2IEfw");
                        return headers;
          }
        };
        queue.add(request);






       /* // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String yourUrl = "https://api.spotify.com/v1/me/playlists";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, yourUrl, null ,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("MainActivity", "request WORKEDDDD");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse", error.toString());
                Log.d("MainActivity", "request didnt work");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                // Basic Authentication
                //String auth = "Basic " + Base64.encodeToString(CONSUMER_KEY_AND_SECRET.getBytes(), Base64.NO_WRAP);
                headers.put("Accept:","application/json");
                headers.put("Authorization", "Bearer " + "BQAbzIIYnAzDZdU8xydH0edV4X5VYQ5fhIi1gg0ywESua3aOc5BaXvaYRVaHhEx66_uDOv-o7ub94Blj-A154CWHNpBEGP8MLizD1ur20Q4RKJj0HMLwzUuf1saNdtvu2SXQnkLQPplROcX2cgJqgD6l27drL37T");
                return headers;
            }
        };
        queue.add(request);*/

    }






}
