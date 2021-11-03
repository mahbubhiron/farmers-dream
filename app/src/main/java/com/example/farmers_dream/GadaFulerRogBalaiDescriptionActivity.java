package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GadaFulerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gada_fuler_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("gadar_pata_surangokari_poka")){

            imageView.setImageResource(R.drawable.gadar_pata_surangokari_poka);
            textView.setText(R.string.gadar_pata_surangokari_poka_description);

        }
        if(rog_description.equals("gadar_patar_dag_rog")){

            imageView.setImageResource(R.drawable.gadar_patar_dag_rog);
            textView.setText(R.string.gadar_patar_dag_rog_description);

        }
        if(rog_description.equals("gadar_mojayek_rog")){

            imageView.setImageResource(R.drawable.gadar_mojayek_rog);
            textView.setText(R.string.gadar_mojayek_rog_description);

        }


    }
}