package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TometorRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tometor_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("tometor_fol_fete_jawa_somossa")){

            imageView.setImageResource(R.drawable.tometor_fol_fete_jawa_somossa);
            textView.setText(R.string.tometor_fol_fete_jawa_somossa_description);

        }
        if(rog_description.equals("tometor_tobako_kyatarpilar")){

            imageView.setImageResource(R.drawable.tometor_tobako_kyatarpilar);
            textView.setText(R.string.tometor_tobako_kyatarpilar_description);

        }
        if(rog_description.equals("tometor_bak_ai_rog")){

            imageView.setImageResource(R.drawable.tometor_bak_ai_rog);
            textView.setText(R.string.tometor_bak_ai_rog_description);

        }
        if(rog_description.equals("tometor_white_mold_rog")){

            imageView.setImageResource(R.drawable.tometor_white_mold_rog);
            textView.setText(R.string.tometor_white_mold_rog_description);

        }
        if(rog_description.equals("tometor_pata_surongokari_poka")){

            imageView.setImageResource(R.drawable.tometor_pata_surongokari_poka);
            textView.setText(R.string.tometor_pata_surongokari_poka_description);

        }
        if(rog_description.equals("tometor_fol_cidrokari_poka")){

            imageView.setImageResource(R.drawable.tometor_fol_cidrokari_poka);
            textView.setText(R.string.tometor_fol_cidrokari_poka_description);

        }

    }
}