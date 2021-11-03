package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PuishakerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puishaker_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("puishaker_krishijonito_sikor_git_ba_rutnot_nematid")){

            imageView.setImageResource(R.drawable.puishaker_krishijonito_sikor_git_ba_rutnot_nematid);
            textView.setText(R.string.puishaker_krishijonito_sikor_git_ba_rutnot_nematid_description);

        }
        if(rog_description.equals("puisakher_katui_poka")){

            imageView.setImageResource(R.drawable.puisakher_katui_poka);
            textView.setText(R.string.puisakher_katui_poka_description);

        }
        if(rog_description.equals("puishaker_pathar_dag_rog")){

            imageView.setImageResource(R.drawable.puishaker_pathar_dag_rog);
            textView.setText(R.string.puishaker_pathar_dag_rog_description);

        }


    }
}