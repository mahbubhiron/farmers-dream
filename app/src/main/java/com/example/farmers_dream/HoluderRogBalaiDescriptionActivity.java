package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HoluderRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holuder_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("holuder_thrips_poka")){

            imageView.setImageResource(R.drawable.holuder_thrips_poka);
            textView.setText(R.string.holuder_thrips_poka_description);

        }
        if(rog_description.equals("holuder_patar_dagrog")){

            imageView.setImageResource(R.drawable.holuder_patar_dagrog);
            textView.setText(R.string.holuder_patar_dagrog_description);

        }

    }
}