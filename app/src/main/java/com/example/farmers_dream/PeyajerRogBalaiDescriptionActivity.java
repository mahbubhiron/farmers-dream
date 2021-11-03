package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PeyajerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peyajer_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("peajer_thiripos_poka")){

            imageView.setImageResource(R.drawable.peajer_thiripos_poka);
            textView.setText(R.string.peajer_thiripos_poka_description);

        }
        if(rog_description.equals("peajer_botraitis_blayit_rog")){

            imageView.setImageResource(R.drawable.peajer_botraitis_blayit_rog);
            textView.setText(R.string.peajer_botraitis_blayit_rog_description);

        }
        if(rog_description.equals("peajer_black_stock_rot_rog")){

            imageView.setImageResource(R.drawable.peajer_black_stock_rot_rog);
            textView.setText(R.string.peajer_black_stock_rot_rog_description);

        }
        if(rog_description.equals("peajer_white_rot_rog")){

            imageView.setImageResource(R.drawable.peajer_white_rot_rog);
            textView.setText(R.string.peajer_white_rot_rog_description);

        }
        if(rog_description.equals("peajer_ghora_poka")){

            imageView.setImageResource(R.drawable.peajer_ghora_poka);
            textView.setText(R.string.peajer_ghora_poka_description);

        }

    }
}