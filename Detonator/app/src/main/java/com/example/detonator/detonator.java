package com.example.detonator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class detonator extends Activity {
    public static final String ACTION_BOOM = "com.example.bomb.boom_action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detonator);

        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.mipmap.ic_launcher);
        img.isShown();

        img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(ACTION_BOOM));
            }
        });

    }
}
