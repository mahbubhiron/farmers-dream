package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PeyajerRogBalaiActivity extends AppCompatActivity{
    private RecyclerView recyclerView;

    PeyasAdapter peyasAdapter;

    private String[]  title,description;
    int[] images = {R.drawable.peajer_thiripos_poka,R.drawable.peajer_botraitis_blayit_rog,
            R.drawable.peajer_black_stock_rot_rog,R.drawable.peajer_white_rot_rog,
            R.drawable.peajer_ghora_poka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peyajer_rog_balai);

        recyclerView = findViewById(R.id.reCyclerViewId);


        title = getResources().getStringArray(R.array.peyajer_rog_balai);
        description = getResources().getStringArray(R.array.peyajer_rog_balai_desc);
        peyasAdapter = new PeyasAdapter(getApplicationContext(),images,title,description);

        recyclerView.setAdapter(peyasAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}
