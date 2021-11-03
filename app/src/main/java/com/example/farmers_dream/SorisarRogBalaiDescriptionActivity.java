package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SorisarRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorisar_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("sorisar_jab_poka")){

            imageView.setImageResource(R.drawable.sorisar_jab_poka);
            textView.setText(R.string.sorisar_jab_poka_description);

        }
        if(rog_description.equals("sorisar_bicha_poka")){

            imageView.setImageResource(R.drawable.sorisar_bicha_poka);
            textView.setText(R.string.sorisar_bicha_poka_description);

        }
        if(rog_description.equals("sorisar_white_mold_rog")){

            imageView.setImageResource(R.drawable.sorisar_white_mold_rog);
            textView.setText(R.string.sorisar_white_mold_rog_description);

        }
        if(rog_description.equals("sorisar_korat_machi_poka")){

            imageView.setImageResource(R.drawable.sorisar_korat_machi_poka);
            textView.setText(R.string.sorisar_korat_machi_poka_description);

        }
        if(rog_description.equals("sorisar_pata_jholsano_rog")){

            imageView.setImageResource(R.drawable.sorisar_pata_jholsano_rog);
            textView.setText(R.string.sorisar_pata_jholsano_rog_description);

        }



    }
}