package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GolapFulerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golap_fuler_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("golaper_patar_uivil")){

            imageView.setImageResource(R.drawable.golaper_patar_uivil);
            textView.setText(R.string.golaper_patar_uivil_description);

        }
        if(rog_description.equals("golaper_kuri_cidrokari_poka")){

            imageView.setImageResource(R.drawable.golaper_kuri_cidrokari_poka);
            textView.setText(R.string.golaper_kuri_cidrokari_poka_description);

        }
        if(rog_description.equals("golaper_threepos")){

            imageView.setImageResource(R.drawable.golaper_threepos);
            textView.setText(R.string.golaper_threepos_description);

        }

        if(rog_description.equals("golaper_leda_poka")){

            imageView.setImageResource(R.drawable.golaper_leda_poka);
            textView.setText(R.string.golaper_leda_poka_description);

        }
        if(rog_description.equals("golaper_patamorano_poka")){

            imageView.setImageResource(R.drawable.golaper_patamorano_poka);
            textView.setText(R.string.golaper_patamorano_poka_description);

        }
        if(rog_description.equals("golaper_aghamora_rog")){

            imageView.setImageResource(R.drawable.golaper_aghamora_rog);
            textView.setText(R.string.golaper_aghamora_rog_description);

        }
        if(rog_description.equals("golaper_gashforing")){

            imageView.setImageResource(R.drawable.golaper_gashforing);
            textView.setText(R.string.golaper_gashforing_description);

        }
        if(rog_description.equals("golaper_milibag")){

            imageView.setImageResource(R.drawable.golaper_milibag);
            textView.setText(R.string.golaper_milibag_description);

        }
        if(rog_description.equals("golaper_patar_kal_dag_rog")){

            imageView.setImageResource(R.drawable.golaper_patar_kal_dag_rog);
            textView.setText(R.string.golaper_patar_kal_dag_rog_description);

        }
    }
}