package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BegunerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beguner_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("beguner_gash_foring")){

            imageView.setImageResource(R.drawable.beguner_gash_foring);
            textView.setText(R.string.beguner_gash_foring_description);

        }
        if(rog_description.equals("beguner_virousjonito_mojaik_rog")){

            imageView.setImageResource(R.drawable.beguner_virousjonito_mojaik_rog);
            textView.setText(R.string.beguner_virousjonito_mojaik_rog_description);

        }
        if(rog_description.equals("beguner_pawdari_mildiu_rog")){

            imageView.setImageResource(R.drawable.beguner_pawdari_mildiu_rog);
            textView.setText(R.string.beguner_pawdari_mildiu_rog_description);

        }
        if(rog_description.equals("beguner_fomopsis_blait_rog")){

            imageView.setImageResource(R.drawable.beguner_fomopsis_blait_rog);
            textView.setText(R.string.beguner_fomopsis_blait_rog_description);

        }
        if(rog_description.equals("beguner_white_mold_rog")){

            imageView.setImageResource(R.drawable.beguner_white_mold_rog);
            textView.setText(R.string.beguner_white_mold_rog_description);

        }
        if(rog_description.equals("beguner_khudro_lal_makor")){

            imageView.setImageResource(R.drawable.beguner_khudro_lal_makor);
            textView.setText(R.string.beguner_khudro_lal_makor_description);

        }
        if(rog_description.equals("beguner_pata_surungokari_poka")){

            imageView.setImageResource(R.drawable.beguner_pata_surungokari_poka);
            textView.setText(R.string.beguner_pata_surungokari_poka_description);

        }

    }
}