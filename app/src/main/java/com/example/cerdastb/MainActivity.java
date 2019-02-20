package com.example.cerdastb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        tvSplash = (TextView) findViewById(R.id.tvSplash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                Intent bio = new Intent(MainActivity.this, Input_Bio.class);
                startActivity(bio);
            }
        }, 1000L);


    }
}
