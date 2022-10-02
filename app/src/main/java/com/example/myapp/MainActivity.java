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

        Button button = (Button) findViewById(R.id.button);
        TextView text = (TextView) findViewById(R.id.text);
        internetConnect connection = new internetConnect(this);

        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {

            }
        });
    }
}