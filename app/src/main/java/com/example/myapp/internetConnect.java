package com.example.myapp;


import android.content.Context;
import android.graphics.drawable.Drawable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class internetConnect
{
    Context mContext;

    //sets "mContext" to Context of calling Activity
    public internetConnect(Context mContext)
    {
        this.mContext = mContext;
    }


    //called when user wants to make HTTP Post request to website with image
    public void makeRequest()
    {
        //Queue for HTTP requests
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        //byte array to hold image converted into bytes
        byte[] data = new byte[16384];

        try
        {
            // get input stream for image in asset file
            InputStream ims = mContext.getAssets().open("src/main/assets/fountain.jpg");

            //read input stream into byte array
            int nRead;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            while ((nRead = ims.read(data, 0, data.length)) != -1)
            {
                buffer.write(data, 0, nRead);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(data != null)
        {
            JSONObject picture = new JSONObject();

            try
            {
                picture.put("image", data);
            }
            catch(JSONException e)
            {
                e.printStackTrace();
            }


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
}
