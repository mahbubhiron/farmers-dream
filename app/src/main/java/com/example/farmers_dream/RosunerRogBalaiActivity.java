package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RosunerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    RosunAdapter rosunAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.rosuner_dauni_mildui_rog,R.drawable.rosuner_aga_mora_rog,
            R.drawable.rosuner_thripos_poka,R.drawable.rosuner_lal_morica_rog,
            R.drawable.rosuner_patamorano_poka,R.drawable.rosuner_leda_poka,R.drawable.rosuner_eriofait_makor};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rosuner_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.rosuner_rog_balai);
        description = getResources().getStringArray(R.array.rosuner_rog_balai_desc);
        rosunAdapter = new RosunAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(rosunAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
