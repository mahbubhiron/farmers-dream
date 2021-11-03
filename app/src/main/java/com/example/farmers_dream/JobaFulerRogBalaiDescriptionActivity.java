package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class JobaFulerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joba_fuler_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("jobar_milibag")){

            imageView.setImageResource(R.drawable.jobar_milibag);
            textView.setText(R.string.jobar_milibag_description);

        }
        if(rog_description.equals("jobar_patamorano_poka")){

            imageView.setImageResource(R.drawable.jobar_patamorano_poka);
            textView.setText(R.string.jobar_patamorano_poka_description);

        }
        if(rog_description.equals("jobar_jab_poka")){

            imageView.setImageResource(R.drawable.jobar_jab_poka);
            textView.setText(R.string.jobar_jab_poka_description);

        }


    }
}