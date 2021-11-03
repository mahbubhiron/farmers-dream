package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class KusumFulerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    KusumFulAdapter kusumFulAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.kusumfuler_mojayek_rog,R.drawable.kusumfuler_pata_surongokari_poka,
            R.drawable.kusumfuler_jab_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kusum_fuler_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.kusumfuler_rog_balai);
        description = getResources().getStringArray(R.array.kusumfuler_rog_balai_desc);
        kusumFulAdapter = new KusumFulAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(kusumFulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
