package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class BegunerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    BegunAdapter begunAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.beguner_gash_foring,R.drawable.beguner_virousjonito_mojaik_rog,
            R.drawable.beguner_pawdari_mildiu_rog,R.drawable.beguner_fomopsis_blait_rog,
            R.drawable.beguner_white_mold_rog,R.drawable.beguner_khudro_lal_makor,R.drawable.beguner_pata_surungokari_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beguner_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.beguner_rog_balai);
        description = getResources().getStringArray(R.array.beguner_rog_balai_desc);
        begunAdapter = new BegunAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(begunAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
