package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GolapFulerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    GolapFulAdapter golapFulAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.golaper_patar_uivil,R.drawable.golaper_kuri_cidrokari_poka,
            R.drawable.golaper_threepos,R.drawable.golaper_leda_poka,R.drawable.golaper_patamorano_poka,
            R.drawable.golaper_aghamora_rog,R.drawable.golaper_gashforing,R.drawable.golaper_milibag,
            R.drawable.golaper_patar_kal_dag_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golap_fuler_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.golaper_rog_balai);
        description = getResources().getStringArray(R.array.golaper_rog_balai_desc);
        golapFulAdapter = new GolapFulAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(golapFulAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
