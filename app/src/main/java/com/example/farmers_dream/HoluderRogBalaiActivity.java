package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HoluderRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    HoludAdapter holudAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.holuder_thrips_poka,R.drawable.holuder_patar_dagrog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holuder_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.holuder_rog_balai);
        description = getResources().getStringArray(R.array.holuder_rog_balai_desc);
        holudAdapter = new HoludAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(holudAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
