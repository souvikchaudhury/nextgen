package com.example.dhritiman.yugyugjiyo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    int mFlipping = 0;
    RequestQueue queue;
    String url = "http://192.168.1.5:81/androidApi/fetchalbum.php";
    //String url="https://api.myjson.com/bins/w86a";
    RecyclerView recyclerView;
    List<DataModel> feedsList = new ArrayList<DataModel>();
    singleitem_recycler_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.flipper1);

        if (mFlipping == 0) {
            /** Start Flipping */
            flipper.startFlipping();
        }
      //  Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner Drop down elements
       /* List<String> categories = new ArrayList<String>();
        categories.add("Kolkata");
        categories.add("Delhi");
        categories.add("Mumbai");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,R.layout.custom_spinner,categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.custom_spinner);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);*/
        //ib.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new singleitem_recycler_adapter(this, feedsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        recyclerView.setAdapter(adapter);
        //Getting Instance of Volley Request Queue
        queue = NetworkController.getInstance(this).getRequestQueue();
        //Volley's inbuilt class to make Json array request
        JsonArrayRequest newsReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //  Toast.makeText(getApplicationContext(),"",Toast.LENGTH_SHORT).show();
                for (int i = 0; i < response.length(); i++) {
                    try {

                        JSONObject obj = response.getJSONObject(i);
                        //String res=obj.toString();
                        //Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
                        //Log.d("output",res);
                        DataModel feeds = new DataModel(obj.getString("id"),obj.getString("name"),obj.getString("banner_image"),obj.getString("hospname"),obj.getString("price"));

                        // adding movie to movies array
                        feedsList.add(feeds);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    } finally {
                        //Notify adapter about data changes
                        adapter.notifyItemChanged(i);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        //Adding JsonArrayRequest to Request Queue
        queue.add(newsReq);

    }
    }

