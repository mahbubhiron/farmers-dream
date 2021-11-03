package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class KalojirarRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    KalojiraAdapter kalojiraAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.kolojirar_kando_poca_rog,R.drawable.kalojirar_fol_cidrokari_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalojirar_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.kalojirar_rog_balai);
        description = getResources().getStringArray(R.array.kalojirar_rog_balai_desc);
        kalojiraAdapter = new KalojiraAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(kalojiraAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
