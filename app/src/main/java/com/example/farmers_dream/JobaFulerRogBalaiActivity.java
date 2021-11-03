package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class JobaFulerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    JobaFulAdapter jobaFulAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.jobar_milibag,R.drawable.jobar_patamorano_poka,
            R.drawable.jobar_jab_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joba_fuler_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.jobar_rog_balai);
        description = getResources().getStringArray(R.array.jobar_rog_balai_desc);
        jobaFulAdapter = new JobaFulAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(jobaFulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
