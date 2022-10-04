package com.example.myapp;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class internetConnect
{
    Context mContext;

    //sets "mContext" to Context of calling Activity
    public internetConnect(Context mContext)
    {
        this.mContext = mContext;
    }

    public void makeRequest()
    {
        //Queue for HTTP requests
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        //placeholder for image
        JSONObject picture = null;
        //HTTP request
        /*first argument is int indicating type of request,
           2nd is url for website,
           3rd is JSONObject representing data sent to website,
           4th is listener for response,
           5th is listener for error
         */
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, "file:///C:/Users/wissm/practiceWebsite/myWebsite.html", picture, null, null);
        //requestQueue.add();
    }
}
