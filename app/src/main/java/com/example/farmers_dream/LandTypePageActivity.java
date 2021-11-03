package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class LandTypePageActivity extends AppCompatActivity {

    private GridView gridView;
    private int[] area_img = {
      R.drawable.square_and_rectangle,R.drawable.trapezoid_area,R.drawable.triangle_area,R.drawable.parallelogram_area
    };
    private String[] area_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.land_type_page_activity);
        gridView = findViewById(R.id.gridview_id);

        this.setTitle("ভুমির ধরন নির্দারন করুন...!");

        area_name = getResources().getStringArray(R.array.area_name);

        LandTypeAdapter adapter = new LandTypeAdapter(this,area_img,area_name);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = area_name[i];
                if (value.equals("বর্গক্ষেত্র এবং আয়তক্ষেত্র")){
                    Intent intent = new Intent(LandTypePageActivity.this,Akok_Nirdaron_Activity.class);
                    startActivity(intent);
                }
                if (value.equals("ট্রাপিজিয়াম")){
                    Intent intent = new Intent(LandTypePageActivity.this,Akok_Nirdaron_Activity_2.class);
                    startActivity(intent);
                }
                if (value.equals("ত্রিভুজক্ষেত্র")){
                    Intent intent = new Intent(LandTypePageActivity.this,Akok_Nirdaron_Activity_3.class);
                    startActivity(intent);
                }
                if (value.equals("সামান্তরিকক্ষেত্র")){
                    Intent intent = new Intent(LandTypePageActivity.this,Akok_Nirdaron_Activity_4.class);
                    startActivity(intent);
                }
            }
        });

    }
}