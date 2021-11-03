package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AdarRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    AdaAdapter adaAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.adar_gach_cidrokari_poka,R.drawable.adar_kondon_poca_rog,
            R.drawable.adar_kondon_cdrokari_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adar_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.adar_rog_balai);
        description = getResources().getStringArray(R.array.adar_rog_balai_desc);
        adaAdapter = new AdaAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(adaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
