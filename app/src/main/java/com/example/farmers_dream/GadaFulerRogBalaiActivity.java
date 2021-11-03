package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GadaFulerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    GadaFulAdapter gadaFulAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.gadar_pata_surangokari_poka,R.drawable.gadar_patar_dag_rog,
            R.drawable.gadar_mojayek_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gada_fuler_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.gadar_rog_balai);
        description = getResources().getStringArray(R.array.gadar_rog_balai_desc);
        gadaFulAdapter = new GadaFulAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(gadaFulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
