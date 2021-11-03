package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RosunerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosuner_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("rosuner_dauni_mildui_rog")){

            imageView.setImageResource(R.drawable.rosuner_dauni_mildui_rog);
            textView.setText(R.string.rosuner_dauni_mildui_rog_description);

        }
        if(rog_description.equals("rosuner_aga_mora_rog")){

            imageView.setImageResource(R.drawable.rosuner_aga_mora_rog);
            textView.setText(R.string.rosuner_aga_mora_rog_description);

        }
        if(rog_description.equals("rosuner_thripos_poka")){

            imageView.setImageResource(R.drawable.rosuner_thripos_poka);
            textView.setText(R.string.rosuner_thripos_poka_description);

        }
        if(rog_description.equals("rosuner_lal_morica_rog")){

            imageView.setImageResource(R.drawable.rosuner_lal_morica_rog);
            textView.setText(R.string.rosuner_lal_morica_rog_description);

        }
        if(rog_description.equals("rosuner_patamorano_poka")){

            imageView.setImageResource(R.drawable.rosuner_patamorano_poka);
            textView.setText(R.string.rosuner_patamorano_poka_description);

        }
        if(rog_description.equals("rosuner_leda_poka")){

            imageView.setImageResource(R.drawable.rosuner_leda_poka);
            textView.setText(R.string.rosuner_leda_poka_description);

        }
        if(rog_description.equals("rosuner_eriofait_makor")){

            imageView.setImageResource(R.drawable.rosuner_eriofait_makor);
            textView.setText(R.string.rosuner_eriofait_makor_description);

        }

    }
}