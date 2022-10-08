package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Object used to formulate HTTP request
        internetConnect connection = new internetConnect(this);

        //Button to send image request to website
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                connection.makeRequest();
            }
        });

        //Placeholder text
        TextView text = (TextView) findViewById(R.id.text);
    }
}