
package com.example.farmers_dream;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SorisaAdapter extends RecyclerView.Adapter<SorisaAdapter.MyViewHolder> {

    private Intent intent;
    Context context;
    private int[] images;
    private String[] title,description;

    public SorisaAdapter(Context context, int[] images, String[] title, String[] description) {
        this.context = context;
        this.images = images;
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.pat_sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.t1.setText(title[position]);
        holder.t2.setText(description[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(),DhanerRogBalaiDescription.class);

                // view.getContext().startActivity(intent);
                if(position == 0){

                    Intent intent = new Intent(view.getContext(), SorisarRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","sorisar_jab_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 1){

                    Intent intent = new Intent(view.getContext(), SorisarRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","sorisar_bicha_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 2){

                    Intent intent = new Intent(view.getContext(), SorisarRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","sorisar_white_mold_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 3){

                    Intent intent = new Intent(view.getContext(), SorisarRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","sorisar_korat_machi_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 4){

                    Intent intent = new Intent(view.getContext(), SorisarRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","sorisar_pata_jholsano_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView t1,t2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.patImageViewId);
            t1 = itemView.findViewById(R.id.patTitleTextViewId);
            t2 = itemView.findViewById(R.id.patDescriptionTextViewId);
        }
    }
}