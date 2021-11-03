package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class FulkopirRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    FulcopiAdapter fulcopiAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.fullkopir_yellow_virous_rog,R.drawable.fullkopir_black_rot_rog,
            R.drawable.fullkopir_kard_poca_rog,R.drawable.fullkopir_gora_poca_rog,
            R.drawable.fullkopir_tobako_kyatapilar,R.drawable.fullkopir_fli_bitol_poka,R.drawable.fullkopir_katui_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulkopir_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.fulcopir_rog_balai);
        description = getResources().getStringArray(R.array.fulcopir_rog_balai_desc);
        fulcopiAdapter = new FulcopiAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(fulcopiAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
