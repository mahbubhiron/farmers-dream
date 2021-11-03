package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class TometorRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    TometoAdapter tometoAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.tometor_fol_fete_jawa_somossa,R.drawable.tometor_tobako_kyatarpilar,
            R.drawable.tometor_bak_ai_rog,R.drawable.tometor_white_mold_rog,
            R.drawable.tometor_pata_surongokari_poka,R.drawable.tometor_fol_cidrokari_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tometor_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.tometor_rog_balai);
        description = getResources().getStringArray(R.array.tometor_rog_balai_desc);
        tometoAdapter = new TometoAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(tometoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
