package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Baboharbidi_Activity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baboharbidi_);

        textView = findViewById(R.id.baboharbidi_details_id);

        textView.setText(R.string.baboharbidi_details);
    }
}