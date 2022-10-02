package com.example.myapp;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class internetConnect
{
    Context mContext;

    public internetConnect(Context mContext)
    {
        this.mContext = mContext;
    }

    public void makeRequest()
    {
        RequestQueue volleyQueue = Volley.newRequestQueue(mContext);
    }
}
