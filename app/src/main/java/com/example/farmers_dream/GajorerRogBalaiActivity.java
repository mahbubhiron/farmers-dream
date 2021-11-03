package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GajorerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    GajorAdapter gajorAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.gajorer_sawdan_blait_rog,R.drawable.gajorer_dad_rog,
            R.drawable.gajorer_kalo_poca_rog,R.drawable.gajor_fete_jawa_somossa,
            R.drawable.gajorer_urcunga_poka,R.drawable.gajorer_vaiolet_sikor_poca_rog};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gajorer_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.gajorer_rog_balai);
        description = getResources().getStringArray(R.array.gajorer_rog_balai_desc);
        gajorAdapter = new GajorAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(gajorAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
