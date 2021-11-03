package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RojonigondharRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    RojonigondhaFulAdapter golapFulAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.rojonigondhar_brotritis_rog,R.drawable.rojonigondhar_kuri_pocha_rog,
            R.drawable.rojonigondhar_kando_pocha_rog,R.drawable.rojonigondhar_patar_dag_rog,R.drawable.rojonigondhar_patar_khalo_rekha_rog,
            R.drawable.rojonigondhar_milibag,R.drawable.rojonigondhar_moricha_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rojonigondhar_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.rojonigondhar_rog_balai);
        description = getResources().getStringArray(R.array.rojonigondhar_rog_balai_desc);
        golapFulAdapter = new RojonigondhaFulAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(golapFulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
