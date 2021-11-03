package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GajorerRogBalaiDescriptionActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gajorer_rog_balai_description);

        imageView = findViewById(R.id.rogBalaiDescriptionImageViewId);
        textView = findViewById(R.id.rogBalaiDescriptionTextViewId);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            String rog_description = bundle.getString("key");
            showDetails(rog_description);
        }

    }
    void showDetails(String rog_description){

        if(rog_description.equals("gajorer_sawdan_blait_rog")){

            imageView.setImageResource(R.drawable.gajorer_sawdan_blait_rog);
            textView.setText(R.string.gajorer_sawdan_blait_rog_description);

        }
        if(rog_description.equals("gajorer_dad_rog")){

            imageView.setImageResource(R.drawable.gajorer_dad_rog);
            textView.setText(R.string.gajorer_dad_rog_description);

        }
        if(rog_description.equals("gajorer_kalo_poca_rog")){

            imageView.setImageResource(R.drawable.gajorer_kalo_poca_rog);
            textView.setText(R.string.gajorer_kalo_poca_rog_description);

        }
        if(rog_description.equals("gajor_fete_jawa_somossa")){

            imageView.setImageResource(R.drawable.gajor_fete_jawa_somossa);
            textView.setText(R.string.gajor_fete_jawa_somossa_description);

        }
        if(rog_description.equals("gajorer_urcunga_poka")){

            imageView.setImageResource(R.drawable.gajorer_urcunga_poka);
            textView.setText(R.string.gajorer_urcunga_poka_description);

        }
        if(rog_description.equals("gajorer_vaiolet_sikor_poca_rog")){

            imageView.setImageResource(R.drawable.gajorer_vaiolet_sikor_poca_rog);
            textView.setText(R.string.gajorer_vaiolet_sikor_poca_rog_description);

        }

    }
}