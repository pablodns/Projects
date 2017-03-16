package com.example.location;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MapLocation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button find = (Button) findViewById(R.id.btn_find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt_Location = (TextView) findViewById(R.id.txt_location);
                String address = txt_Location.getText().toString();
                if (!address.equals("")) {
                    try {
                        String map = "http://maps.google.co.in/maps?q=" + address;
                        startActivity(viewOnMap(map));
                    } catch (Exception e) {
                        CharSequence error = e.toString();
                        Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    CharSequence insertAddress = "Inserte la dirección" + address;
                    Toast toast = Toast.makeText(getApplicationContext(), insertAddress, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    public Intent viewOnMap(String map) {
        return new Intent(Intent.ACTION_VIEW, Uri.parse(map));
    }

    public void onClickExit(View v) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
