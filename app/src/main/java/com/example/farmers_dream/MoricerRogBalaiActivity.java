package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MoricerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    MoricAdapter moricAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.moricer_virusjonito_rog,R.drawable.moricer_blayt_rog,
            R.drawable.moricer_kyangkar_rog,R.drawable.moricer_white_mold_rog,
            R.drawable.moricer_alfa_mojaik_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moricer_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.moricer_rog_balai);
        description = getResources().getStringArray(R.array.moricer_rog_balai_desc);
        moricAdapter = new MoricAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(moricAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
