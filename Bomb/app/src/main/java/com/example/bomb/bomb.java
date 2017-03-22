package com.example.bomb;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class bomb extends Activity {
    //STEP 4: String to represent the dangerous action.
    public static final String ACTION_BOOM= "com.example.bomb.boom_action";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bomb);

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        img.setImageResource(R.mipmap.ic_launcher);
        img.isShown();

    }
}
