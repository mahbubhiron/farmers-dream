package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PuishakerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    PuishakAdapter puishakAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.puishaker_krishijonito_sikor_git_ba_rutnot_nematid,R.drawable.puisakher_katui_poka,
            R.drawable.puishaker_pathar_dag_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puishaker_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.puishaker_rog_balai);
        description = getResources().getStringArray(R.array.puishaker_rog_balai_desc);
        puishakAdapter = new PuishakAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(puishakAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
