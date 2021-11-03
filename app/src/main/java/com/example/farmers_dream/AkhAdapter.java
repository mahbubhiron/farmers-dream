
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

public class AkhAdapter extends RecyclerView.Adapter<AkhAdapter.MyViewHolder> {

    private Intent intent;
    Context context;
    private int[] images;
    private String[] title,description;

    public AkhAdapter(Context context, int[] images, String[] title, String[] description) {
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

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_kalo_pata_foring");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 1){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_patar_lal_dag_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 2){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_mojaik_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 3){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_patar_surongokari_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 4){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_pata_kheko_uindil_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 5){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_cokkhu_dag_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 6){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_ui_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 7){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_thrips_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 8){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_sada_pata_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 9){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_sada_makor");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 10){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_kalo_shis_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 11){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_sutimold_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 12){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_poshomi_jab_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 13){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_jab_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 14){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_bij_poca_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 15){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_wild_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 16){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_lal_poca_rog");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 17){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_kander_majra_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 18){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_gorar_majra_poka");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().startActivity(intent);

                }
                if(position == 19){

                    Intent intent = new Intent(view.getContext(), AkherRogBalaiDescriptionActivity.class);
                    intent.putExtra("key","akher_agar_majra_poka");
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