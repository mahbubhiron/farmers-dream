package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LauerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    LauAdapter lauAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.lawer_gre_mold_rog,R.drawable.lawer_lif_kalr_rog,
            R.drawable.lawer_skyab_rog,R.drawable.lawer_patapora_rog,
            R.drawable.lawer_thrips_poka,R.drawable.lawer_pestisaid_injuri,R.drawable.lawer_blowjom_and_rot_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lauer_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.lauer_rog_balai);
        description = getResources().getStringArray(R.array.lauer_rog_balai_desc);
        lauAdapter = new LauAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(lauAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
