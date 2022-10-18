package com.example.myapp;


import android.content.Context;
import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class internetConnect implements Runnable
{
    Context mContext;
    Uri uri;

    //sets "mContext" to Context of calling Activity
    public internetConnect(Context mContext)
    {
        this.mContext = mContext;
    }

    public void setUri(Uri uri)
    {
        this.uri = uri;
    }

    //called when user wants to make HTTP Post request to website with image
    public void makeRequest()
    {
        //Queue for HTTP requests
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);

        try
        {
            URL url = new URL("http://10.0.2.2:8000");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "multipart/form-data");

            //byte array to hold image converted into bytes
            byte[] data = new byte[16384];

            // get input stream for image in asset file
            InputStream ims = mContext.getAssets().open("fountain.jpg");

            //read input stream into byte array
            int nRead;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            while ((nRead = ims.read(data, 0, data.length)) != -1)
            {
                buffer.write(data, 0, nRead);
            }

            OutputStream output = urlConnection.getOutputStream();
            output.write(data);

            /*if (data != null)
            {
                JSONObject picture = new JSONObject();

                picture.put("image", data);


                //HTTP request
                //first argument is int indicating type of request,
                //2nd is url for website,
                //3rd is JSONObject representing data sent to website,
                //4th is listener for response,
                //5th is listener for error

                //JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, "http://10.0.2.2/myWebsite.html", picture, null, null);
                //requestQueue.add(getRequest);
            }*/
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        /*catch(JSONException e)
        {
            e.printStackTrace();
        }*/
    }

    @Override
    public void run()
    {
        makeRequest();
    }
}
