package com.example.myapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    //Object used to formulate HTTP request
    internetConnect connection = new internetConnect(this);

    /*launcher used to launch Intent allowing the user to choose content
    from image folder (ActivityResultContracts.GetContent()/"image/*) and
    returning URI of image and passing to connection.makeRequest()*/
    ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>()
    {
        /*passes uri to connection.makeRequest()
        once Activity returns result*/
        @Override
        public void onActivityResult(Uri uri)
        {
            connection.makeRequest(uri);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button to send image request to website
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                /*launches mGetContent, passing
                "image/* to indicate content should be
                in image folder*/
                mGetContent.launch("image/*");
            }
        });

        //Placeholder text
        TextView text = (TextView) findViewById(R.id.text);
    }
}