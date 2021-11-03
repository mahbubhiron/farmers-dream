package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Apps_Shomporkhito_Activity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps__shomporkhito_);

        textView = findViewById(R.id.appsomprokhito_details_id);

        textView.setText(R.string.appsomprokhito_details);
    }
}