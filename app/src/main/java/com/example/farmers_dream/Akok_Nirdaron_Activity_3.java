package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Akok_Nirdaron_Activity_3 extends AppCompatActivity {
    private ListView listView;
    private String[] countryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akok__nirdaron__3);
        listView = findViewById(R.id.listview_id);

        countryNames = getResources().getStringArray(R.array.country_name);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Akok_Nirdaron_Activity_3.this, R.layout.akok_activity_sample, R.id.textview_id, countryNames);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = countryNames[i];
                if (value.equals("ফুট")) {
                    Intent intent = new Intent(Akok_Nirdaron_Activity_3.this, Triangle_ecalculation_Activity.class);
                    intent.putExtra("key", "ফুট");
                    startActivity(intent);
                }
                if (value.equals("হাত")) {
                    Intent intent = new Intent(Akok_Nirdaron_Activity_3.this, Triangle_ecalculation_Activity.class);
                    intent.putExtra("key", "হাত");
                    startActivity(intent);
                }
                if (value.equals("গজ")) {
                    Intent intent = new Intent(Akok_Nirdaron_Activity_3.this, Triangle_ecalculation_Activity.class);
                    intent.putExtra("key", "গজ");
                    startActivity(intent);
                }
            }
        });

    }
}