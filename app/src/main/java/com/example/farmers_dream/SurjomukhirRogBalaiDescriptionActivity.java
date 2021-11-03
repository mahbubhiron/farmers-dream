package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SurjomukhirRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surjomukhir_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("surjomuki_pata_surongokari_poka")){

            imageView.setImageResource(R.drawable.surjomuki_pata_surongokari_poka);
            textView.setText(R.string.surjomuki_pata_surongokari_poka_description);

        }
        if(rog_description.equals("surjomukier_free_bitol_poka")){

            imageView.setImageResource(R.drawable.surjomukier_free_bitol_poka);
            textView.setText(R.string.surjomukier_free_bitol_poka_description);

        }
        if(rog_description.equals("surjomukier_jadis_poka")){

            imageView.setImageResource(R.drawable.surjomukier_jadis_poka);
            textView.setText(R.string.surjomukier_jadis_poka_description);

        }

        if(rog_description.equals("surjomuki_milibag")){

            imageView.setImageResource(R.drawable.surjomuki_milibag);
            textView.setText(R.string.surjomuki_milibag_description);

        }
        if(rog_description.equals("surjomukier_white_mond_rog")){

            imageView.setImageResource(R.drawable.surjomukier_white_mond_rog);
            textView.setText(R.string.surjomukier_white_mond_rog_description);

        }
        if(rog_description.equals("surjomukier_bicha_poka")){

            imageView.setImageResource(R.drawable.surjomukier_bicha_poka);
            textView.setText(R.string.surjomukier_bicha_poka_description);

        }
        if(rog_description.equals("surjomukier_dauni_mildiu_rog")){

            imageView.setImageResource(R.drawable.surjomukier_dauni_mildiu_rog);
            textView.setText(R.string.surjomukier_dauni_mildiu_rog_description);

        }
        if(rog_description.equals("surjomukier_leda_poka")){

            imageView.setImageResource(R.drawable.surjomukier_leda_poka);
            textView.setText(R.string.surjomukier_leda_poka_description);

        }
        if(rog_description.equals("surjomukier_patar_dag_rog")){

            imageView.setImageResource(R.drawable.surjomukier_patar_dag_rog);
            textView.setText(R.string.surjomukier_patar_dag_rog_description);

        }
    }
}