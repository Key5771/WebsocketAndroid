package com.sslab.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;


import java.net.URI;
import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {

    public Client client;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);

        Handler handler = new Handler();

        try {
            client = new Client(new URI("ws://117.17.102.164:8000/client/T1/"));
            client.connect();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    client.close();
                }
            }, 3000);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
