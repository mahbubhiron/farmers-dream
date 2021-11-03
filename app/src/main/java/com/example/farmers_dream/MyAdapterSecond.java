package com.example.farmers_dream;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterSecond extends RecyclerView.Adapter<MyAdapterSecond.MyViewHolder> {

    private Intent intent;
    Context context;
    private int[] images;
    private String[] description;

    public MyAdapterSecond(Context context, int[] images, String[] description) {
        this.context = context;
        this.images = images;
        this.description = description;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dhan_sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.t2.setText(description[position]);
    }

    @Override
    public int getItemCount() {
        return description.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myImageViewId);
            t2 = itemView.findViewById(R.id.descriptionTextViewId);
        }
    }
}
