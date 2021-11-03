package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AdarRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adar_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("adar_gach_cidrokari_poka")){

            imageView.setImageResource(R.drawable.adar_gach_cidrokari_poka);
            textView.setText(R.string.adar_gach_cidrokari_poka_description);

        }
        if(rog_description.equals("adar_kondon_poca_rog")){

            imageView.setImageResource(R.drawable.adar_kondon_poca_rog);
            textView.setText(R.string.adar_kondon_poca_rog_description);

        }
        if(rog_description.equals("adar_kondon_cdrokari_poka")){

            imageView.setImageResource(R.drawable.adar_kondon_cdrokari_poka);
            textView.setText(R.string.adar_kondon_cdrokari_poka_description);

        }
    }
}