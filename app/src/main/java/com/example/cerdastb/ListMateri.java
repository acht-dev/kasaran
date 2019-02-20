package com.example.cerdastb;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.cerdastb.Interface.ItemClickListener;
import com.example.cerdastb.Model.MateriModel;
import com.example.cerdastb.ViewHolder.ListMateriHolder;

public class ListMateri extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference materi;

    RecyclerView recycler_materi;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<MateriModel,ListMateriHolder> adapter;

    String materiID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi);

        database = FirebaseDatabase.getInstance();
        materi = database.getReference("Materi");


        //load List Materi
        recycler_materi = (RecyclerView) findViewById(R.id.Recycle_materi);
        recycler_materi.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recycler_materi.setLayoutManager(layoutManager);

        loadMateri();
    }

    private void loadMateri() {
        adapter = new FirebaseRecyclerAdapter<MateriModel, ListMateriHolder>(
                MateriModel.class, R.layout.materi_cardview,ListMateriHolder.class,materi
        ) {
            @Override
            protected void onBindViewHolder(@NonNull ListMateriHolder holder, int position, @NonNull MateriModel model) {
                holder.TxtJudul.setText(model.getJudul());
                final MateriModel clickItem = model;
                final Intent intent1 = new Intent(ListMateri.this,BukuSaku.class);
                final Intent intent2 = new Intent(ListMateri.this,MateriVideoActivity.class);

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        if(clickItem.getType().equals("text")){
                            intent1.putExtra("materiID",adapter.getRef(position).getKey());
                            startActivity(intent1);
                        }
                        else if(clickItem.getType().equals("video")){
                            startActivity(intent2);
                        }
                    }
                });
            }

            @NonNull
            @Override
            public ListMateriHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return null;
            }
        };
        recycler_materi.setAdapter(adapter);

    }
}