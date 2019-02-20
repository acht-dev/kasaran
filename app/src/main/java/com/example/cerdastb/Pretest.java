package com.example.cerdastb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Pretest extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pretest);

        btn = (Button) findViewById(R.id.btndia);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tgldiagnosa = new Intent(Pretest.this, TglDia.class);
                startActivity(tgldiagnosa);
            }
        });
    }
}
