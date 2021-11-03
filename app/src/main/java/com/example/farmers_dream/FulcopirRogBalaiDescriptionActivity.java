package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FulcopirRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulcopir_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("fullkopir_yellow_virous_rog")){

            imageView.setImageResource(R.drawable.fullkopir_yellow_virous_rog);
            textView.setText(R.string.fullkopir_yellow_virous_rog_description);

        }
        if(rog_description.equals("fullkopir_black_rot_rog")){

            imageView.setImageResource(R.drawable.fullkopir_black_rot_rog);
            textView.setText(R.string.fullkopir_black_rot_rog_description);

        }
        if(rog_description.equals("fullkopir_kard_poca_rog")){

            imageView.setImageResource(R.drawable.fullkopir_kard_poca_rog);
            textView.setText(R.string.fullkopir_kard_poca_rog_description);

        }
        if(rog_description.equals("fullkopir_gora_poca_rog")){

            imageView.setImageResource(R.drawable.fullkopir_gora_poca_rog);
            textView.setText(R.string.fullkopir_gora_poca_rog_description);

        }
        if(rog_description.equals("fullkopir_tobako_kyatapilar")){

            imageView.setImageResource(R.drawable.fullkopir_tobako_kyatapilar);
            textView.setText(R.string.fullkopir_tobako_kyatapilar_description);

        }
        if(rog_description.equals("fullkopir_fli_bitol_poka")){

            imageView.setImageResource(R.drawable.fullkopir_fli_bitol_poka);
            textView.setText(R.string.fullkopir_fli_bitol_poka_description);

        }
        if(rog_description.equals("fullkopir_katui_poka")){

            imageView.setImageResource(R.drawable.fullkopir_katui_poka);
            textView.setText(R.string.fullkopir_katui_poka_description);

        }

    }
}