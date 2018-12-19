package com.example.lenovo.inter_iit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

public class req extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private String api = "http://192.168.43.232:3000/api/find";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //ProgressDialog.show(getApplicationContext(),"Fetching","please Wait....");
        progressDialog = new ProgressDialog(this);
        progressDialog.show();
      //  Intent p = getIntent();
      //  String v = p.getStringExtra("check");
      //  Log.i("test", "onCreate: " + v);
        final Intent intent  = getIntent();
        final String p = intent.getStringExtra("check");
        RequestQueue queue = Volley.newRequestQueue(req.this);
        final Map<String, String> postParam= new HashMap<String, String>();
        Log.i("check", "onActivityResult: " +p);
        postParam.put("url", p);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                api, new JSONObject(postParam),
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            Boolean n = response.getBoolean("recognised");
                            String j = Boolean.toString(n);
                            Log.i("jaan", j);

                            if(n){
                                Log.i("result", response.toString());
                                Intent intent2 = new Intent(req.this,channels.class);
                                intent.putExtra("checks",postParam.get("url"));

                                startActivity(intent2);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //   msgResponse.setText(response.toString());
                        // hideProgressDialog();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //  VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hideProgressDialog();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }



        };

        // jsonObjReq.setTag(TAG);
        // Adding request to request queue
        queue.add(jsonObjReq);

        }
}
