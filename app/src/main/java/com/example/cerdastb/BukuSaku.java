package com.example.cerdastb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.cerdastb.Model.MateriModel;
public class BukuSaku extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference table_materi;
    String materiID = "";

    TextView Judul, materi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_saku);

        Judul = (TextView)findViewById(R.id.judul_text);
        materi = (TextView)findViewById(R.id.materi_text);

        database = FirebaseDatabase.getInstance();
        table_materi = database.getReference("Materi");


        //get materiID from intent
        if(getIntent() != null){
            materiID = getIntent().getStringExtra("materiID");
        }
        if (!materiID.isEmpty()){
            getMateri(materiID);
        }
    }
    private void getMateri(final String materiID) {
        table_materi.child(materiID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                MateriModel materiModel = dataSnapshot.getValue(MateriModel.class);

                Judul.setText(materiModel.getJudul());
                materi.setText(materiModel.getMateri());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
