package com.example.cerdastb;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> users;

    public MyAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.card_view_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.Nama.setText(users.get(i).getNama());
        myViewHolder.Gambar.setImageResource(R.drawable.user);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,user_detil.class);
                intent.putExtra("Nama",users.get(i).getNama());
                intent.putExtra("Pretest",users.get(i).getPosttest());
                intent.putExtra("Posttest",users.get(i).getPretest());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Nama;
        ImageView Gambar;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Nama = (TextView)itemView.findViewById(R.id.nama_user);
            Gambar = (ImageView)itemView.findViewById(R.id.gambar_user);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }
}
