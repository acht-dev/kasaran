package com.example.cerdastb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class user_detil extends AppCompatActivity {

    private TextView tvNama, tvPretest, tvPosttest;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detil);
        Intent intent = getIntent();
        String Nama = intent.getExtras().getString("Nama");
        int Pretest = intent.getExtras().getInt("Pretest");
        int Posttest = intent.getExtras().getInt("Posttest");

        tvNama = (TextView) findViewById(R.id.nama_user);
        tvPosttest = (TextView) findViewById(R.id.posttest);
        tvPretest = (TextView) findViewById(R.id.pretest);
        img = (ImageView) findViewById(R.id.gambar_user);

        tvNama.setText(Nama);
        tvPretest.setText(String.valueOf(Pretest));
        tvPosttest.setText(String.valueOf(Posttest));
        img.setImageResource(R.drawable.boy);
    }
}
