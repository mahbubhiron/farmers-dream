package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LauerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauer_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("lawer_gre_mold_rog")){

            imageView.setImageResource(R.drawable.lawer_gre_mold_rog);
            textView.setText(R.string.lawer_gre_mold_rog_description);

        }
        if(rog_description.equals("lawer_lif_kalr_rog")){

            imageView.setImageResource(R.drawable.lawer_lif_kalr_rog);
            textView.setText(R.string.lawer_lif_kalr_rog_description);

        }
        if(rog_description.equals("lawer_skyab_rog")){

            imageView.setImageResource(R.drawable.lawer_skyab_rog);
            textView.setText(R.string.lawer_skyab_rog_description);

        }
        if(rog_description.equals("lawer_patapora_rog")){

            imageView.setImageResource(R.drawable.lawer_patapora_rog);
            textView.setText(R.string.lawer_patapora_rog_description);

        }
        if(rog_description.equals("lawer_thrips_poka")){

            imageView.setImageResource(R.drawable.lawer_thrips_poka);
            textView.setText(R.string.lawer_thrips_poka_description);

        }
        if(rog_description.equals("lawer_pestisaid_injuri")){

            imageView.setImageResource(R.drawable.lawer_pestisaid_injuri);
            textView.setText(R.string.lawer_pestisaid_injuri_description);

        }
        if(rog_description.equals("lawer_blowjom_and_rot_rog")){

            imageView.setImageResource(R.drawable.lawer_blowjom_and_rot_rog);
            textView.setText(R.string.lawer_blowjom_and_rot_rog_description);

        }

    }
}