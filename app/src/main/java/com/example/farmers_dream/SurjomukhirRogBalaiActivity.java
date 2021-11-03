package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class SurjomukhirRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    SurjomukhiFulAdapter surjomukhiFulAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.surjomuki_pata_surongokari_poka,R.drawable.surjomukier_free_bitol_poka,
            R.drawable.surjomukier_jadis_poka,R.drawable.surjomuki_milibag,R.drawable.surjomukier_white_mond_rog,
            R.drawable.surjomukier_bicha_poka,R.drawable.surjomukier_dauni_mildiu_rog,R.drawable.surjomukier_leda_poka,
            R.drawable.surjomukier_patar_dag_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surjomukhir_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.surjomukhir_rog_balai);
        description = getResources().getStringArray(R.array.surjomukhir_rog_balai_desc);
        surjomukhiFulAdapter = new SurjomukhiFulAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(surjomukhiFulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
