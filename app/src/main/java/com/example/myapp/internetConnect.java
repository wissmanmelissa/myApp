package com.example.myapp;


import android.content.Context;
import android.net.Uri;

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

    //sets image uri
    public void setUri(Uri uri)
    {
        this.uri = uri;
    }

    //called when user wants to make HTTP Post request to website with image
    public void makeRequest()
    {

        try
        {
            //create HTTP connection to local server
            URL url = new URL("http://10.0.2.2:80");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //indicate connection will be used for POST request
            urlConnection.setRequestMethod("POST");
            //indicate request will contain multipart data
            urlConnection.setRequestProperty("Content-Type", "multipart/form-data");

            //byte array to hold image converted into bytes
            byte[] data = new byte[16384];

            // get input stream for image chosen by user
            InputStream ims = mContext.getContentResolver().openInputStream(uri);

            //read input stream into byte array
            int nRead;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            while ((nRead = ims.read(data, 0, data.length)) != -1)
            {
                buffer.write(data, 0, nRead);
            }

            try(OutputStream os = urlConnection.getOutputStream())
            {
                os.write(data, 0, data.length);
            }
        }
        catch(MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        makeRequest();
    }
}
