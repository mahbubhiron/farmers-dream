package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RojonigondharRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojonigondhar_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("rojonigondhar_brotritis_rog")){

            imageView.setImageResource(R.drawable.rojonigondhar_brotritis_rog);
            textView.setText(R.string.rojonigondhar_brotritis_rog_description);

        }
        if(rog_description.equals("rojonigondhar_kuri_pocha_rog")){

            imageView.setImageResource(R.drawable.rojonigondhar_kuri_pocha_rog);
            textView.setText(R.string.rojonigondhar_kuri_pocha_rog_description);

        }
        if(rog_description.equals("rojonigondhar_kando_pocha_rog")){

            imageView.setImageResource(R.drawable.rojonigondhar_kando_pocha_rog);
            textView.setText(R.string.rojonigondhar_kando_pocha_rog_description);

        }

        if(rog_description.equals("rojonigondhar_patar_dag_rog")){

            imageView.setImageResource(R.drawable.rojonigondhar_patar_dag_rog);
            textView.setText(R.string.rojonigondhar_patar_dag_rog_description);

        }
        if(rog_description.equals("rojonigondhar_patar_khalo_rekha_rog")){

            imageView.setImageResource(R.drawable.rojonigondhar_patar_khalo_rekha_rog);
            textView.setText(R.string.rojonigondhar_patar_khalo_rekha_rog_description);

        }
        if(rog_description.equals("rojonigondhar_milibag")){

            imageView.setImageResource(R.drawable.rojonigondhar_milibag);
            textView.setText(R.string.rojonigondhar_milibag_description);

        }
        if(rog_description.equals("rojonigondhar_moricha_rog")){

            imageView.setImageResource(R.drawable.rojonigondhar_moricha_rog);
            textView.setText(R.string.rojonigondhar_moricha_rog_description);

        }

    }
}