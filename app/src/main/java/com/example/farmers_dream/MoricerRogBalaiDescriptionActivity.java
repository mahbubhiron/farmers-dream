package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MoricerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moricer_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("moricer_virusjonito_rog")){

            imageView.setImageResource(R.drawable.moricer_virusjonito_rog);
            textView.setText(R.string.moricer_virusjonito_rog_description);

        }
        if(rog_description.equals("moricer_blayt_rog")){

            imageView.setImageResource(R.drawable.moricer_blayt_rog);
            textView.setText(R.string.moricer_blayt_rog_description);

        }
        if(rog_description.equals("moricer_kyangkar_rog")){

            imageView.setImageResource(R.drawable.moricer_kyangkar_rog);
            textView.setText(R.string.moricer_kyangkar_rog_description);

        }
        if(rog_description.equals("moricer_white_mold_rog")){

            imageView.setImageResource(R.drawable.moricer_white_mold_rog);
            textView.setText(R.string.moricer_white_mold_rog_description);

        }
        if(rog_description.equals("moricer_alfa_mojaik_rog")){

            imageView.setImageResource(R.drawable.moricer_alfa_mojaik_rog);
            textView.setText(R.string.moricer_alfa_mojaik_rog_description);

        }

    }
}