package com.example.farmers_dream;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Square_and_Rectangl_ecalculation extends AppCompatActivity {

    private EditText prothom_dorgo, ditio_dorgo, prothom_prost, ditio_prosto;
    private Button calculate_btn, clear_btn;
    private TextView khetrofol, sotangso, biga, kata;
    private Spinner spinner;
    String[] countryNames;
    private boolean isFirstSelection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_and__rectangl_ecalculation);
        this.setTitle("ভুমি পরিমাপ করুন..!");

        prothom_dorgo = findViewById(R.id.square_and_rectange_prothom_dorgo_id);
        ditio_dorgo = findViewById(R.id.square_and_rectange_ditio_dorgo_id);
        prothom_prost = findViewById(R.id.square_and_rectange_prothom_prosto_id);
        ditio_prosto = findViewById(R.id.square_and_rectange_ditio_prosto_id);
        calculate_btn = findViewById(R.id.calculate_btn_id);
        clear_btn = findViewById(R.id.clear_btn_id);
        khetrofol = findViewById(R.id.khetrofol_textview_id);
        sotangso = findViewById(R.id.sotangsho_textview_id);
        biga = findViewById(R.id.bigha_textview_id);
        kata = findViewById(R.id.katha_textview_id);

        // calculate_btn.setOnClickListener(this);
//        clear_btn.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String akok_value = bundle.getString("key");
//            showDetails(akok_value);

            if (akok_value.equals("ফুট")) {

                calculate_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (view.getId() == R.id.calculate_btn_id) {
                                String prothom_Dorgo = prothom_dorgo.getText().toString();
                                String ditio_Dorgo = ditio_dorgo.getText().toString();
                                String prothom_Prosto = prothom_prost.getText().toString();
                                String ditio_Prosto = ditio_prosto.getText().toString();

                                double prothom1_Dorgo = Double.parseDouble(prothom_Dorgo);
                                double ditio2_Dorgo = Double.parseDouble(ditio_Dorgo);
                                double prothom1_Prosto = Double.parseDouble(prothom_Prosto);
                                double ditio2_Prosto = Double.parseDouble(ditio_Prosto);

                                double avg_dorgo = (prothom1_Dorgo + ditio2_Dorgo) / 2;
                                double avg_prosto = (prothom1_Prosto + ditio2_Prosto) / 2;
                                double area = avg_dorgo * avg_prosto;

                                khetrofol.setText("" + area);

                                double sotangsho = area / 435.6;
                                sotangso.setText("" + sotangsho);

                                double katha = sotangsho / 1.65;
                                kata.setText("" + katha);

                                double bigha = sotangsho / 33.06;
                                biga.setText("" + bigha);

                            }

                        }catch (Exception e){

                        }
                    }
                });

            }

            if (akok_value.equals("হাত")) {

                calculate_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {

                            if (view.getId() == R.id.calculate_btn_id) {
                                String prothom_Dorgo = prothom_dorgo.getText().toString();
                                String ditio_Dorgo = ditio_dorgo.getText().toString();
                                String prothom_Prosto = prothom_prost.getText().toString();
                                String ditio_Prosto = ditio_prosto.getText().toString();

                                double prothom1_Dorgo = Double.parseDouble(prothom_Dorgo);
                                double ditio2_Dorgo = Double.parseDouble(ditio_Dorgo);
                                double prothom1_Prosto = Double.parseDouble(prothom_Prosto);
                                double ditio2_Prosto = Double.parseDouble(ditio_Prosto);

                                double avg_dorgo = (prothom1_Dorgo + ditio2_Dorgo) / 2;
                                double avg_prosto = (prothom1_Prosto + ditio2_Prosto) / 2;
                                double area = avg_dorgo * avg_prosto;

                                khetrofol.setText("" + area);

                                double sotangsho = area / 193.6;
                                sotangso.setText("" + sotangsho);

                                double katha = sotangsho / 1.65;
                                kata.setText("" + katha);

                                double bigha = sotangsho / 33.06;
                                biga.setText("" + bigha);
                            }
                        }catch (Exception e){

                        }
                    }
                });

            }
            if (akok_value.equals("গজ")) {

                calculate_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            if (view.getId() == R.id.calculate_btn_id) {
                                String prothom_Dorgo = prothom_dorgo.getText().toString();
                                String ditio_Dorgo = ditio_dorgo.getText().toString();
                                String prothom_Prosto = prothom_prost.getText().toString();
                                String ditio_Prosto = ditio_prosto.getText().toString();

                                double prothom1_Dorgo = Double.parseDouble(prothom_Dorgo);
                                double ditio2_Dorgo = Double.parseDouble(ditio_Dorgo);
                                double prothom1_Prosto = Double.parseDouble(prothom_Prosto);
                                double ditio2_Prosto = Double.parseDouble(ditio_Prosto);

                                double avg_dorgo = (prothom1_Dorgo + ditio2_Dorgo) / 2;
                                double avg_prosto = (prothom1_Prosto + ditio2_Prosto) / 2;
                                double area = avg_dorgo * avg_prosto;

                                khetrofol.setText("" + area);

                                double sotangsho = area / 48.40;
                                sotangso.setText("" + sotangsho);

                                double katha = sotangsho / 1.65;
                                kata.setText("" + katha);

                                double bigha = sotangsho / 33.06;
                                biga.setText("" + bigha);
                            }
                        }catch (Exception e){

                        }
                    }
                });

            }


        }

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.clear_btn_id){
                    prothom_dorgo.getText().clear();
                    ditio_dorgo.getText().clear();
                    prothom_prost.getText().clear();
                    ditio_prosto.getText().clear();
                    khetrofol.setText("");
                    sotangso.setText("");
                    biga.setText("");
                    kata.setText("");

                }
            }
        });

    }
}



