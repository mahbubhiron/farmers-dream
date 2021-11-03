package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class KusumFulerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kusum_fuler_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("kusumfuler_mojayek_rog")){

            imageView.setImageResource(R.drawable.kusumfuler_mojayek_rog);
            textView.setText(R.string.kusumfuler_mojayek_rog_description);

        }
        if(rog_description.equals("kusumfuler_pata_surongokari_poka")){

            imageView.setImageResource(R.drawable.kusumfuler_pata_surongokari_poka);
            textView.setText(R.string.kusumfuler_pata_surongokari_poka_description);

        }
        if(rog_description.equals("kusumfuler_jab_poka")){

            imageView.setImageResource(R.drawable.kusumfuler_jab_poka);
            textView.setText(R.string.kusumfuler_jab_poka_description);

        }


    }
}