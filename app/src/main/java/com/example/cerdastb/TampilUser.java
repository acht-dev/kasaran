package com.example.cerdastb;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TampilUser extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;
    ArrayList<User> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_user);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        list = new ArrayList<User>();
        recyclerView.setHasFixedSize(true);
        reference = FirebaseDatabase.getInstance().getReference().child("User");
        reference.keepSynced(true);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    User p = dataSnapshot1.getValue(User.class);
                    list.add(p);
                }
                adapter = new MyAdapter(TampilUser.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
