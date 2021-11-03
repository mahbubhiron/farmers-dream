package com.example.farmers_dream;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Objects;

public class Register_activity extends AppCompatActivity {

    private MaterialEditText user_Name,phone_Number,Email,Password,voter_Id,Division,District,Up,Un,Village;
    private RadioGroup radioGroup;
    private RadioButton female,male;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("নিবন্ধন ফর্ম");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register_activity.this,MainActivity.class));
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        user_Name = findViewById(R.id.user_name);
        phone_Number = findViewById(R.id.phone_number);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        voter_Id = findViewById(R.id.votar_id);
        Division = findViewById(R.id.division);
        District = findViewById(R.id.district);
        Up = findViewById(R.id.up);
        Un = findViewById(R.id.un);
        Village = findViewById(R.id.village);
        radioGroup = findViewById(R.id.radio_button);
        female = findViewById(R.id.female);
        male = findViewById(R.id.male);
        Button register_btn = findViewById(R.id.register_btn);
        progressBar = findViewById(R.id.progressbar);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user_name = user_Name.getText().toString();
                final String phone_number = phone_Number.getText().toString();
                final String email = Email.getText().toString();
                final String password = Password.getText().toString();
                final String voter_id = voter_Id.getText().toString();
                final String division = Division.getText().toString();
                final String district = District.getText().toString();
                final String up = Up.getText().toString();
                final String un = Un.getText().toString();
                final String village = Village.getText().toString();
                final String feMale = female.getText().toString();
                final String Male = male.getText().toString();

                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton select_gender = radioGroup.findViewById(checkedId);
                if(select_gender == null){
                    Toast.makeText(Register_activity.this,"Select gender please",Toast.LENGTH_SHORT).show();
                }else{
                    final String gender = select_gender.getText().toString();
                    if(TextUtils.isEmpty(user_name) || TextUtils.isEmpty(phone_number) || TextUtils.isEmpty(email) ||
                    TextUtils.isEmpty(password) || TextUtils.isEmpty(voter_id) || TextUtils.isEmpty(division) ||
                    TextUtils.isEmpty(district) || TextUtils.isEmpty(up) || TextUtils.isEmpty(un) || TextUtils.isEmpty(village)){
                        Toast.makeText(Register_activity.this,"All fields are required",Toast.LENGTH_SHORT).show();
                    }else{
                        register(user_name,phone_number,email,password,voter_id,division,district,up,un,village,gender);
                    }
                }
            }
        });
    }

    private void register(final String user_name, final String phone_number, final String email, final String password, final String voter_id,
                          final String division, final String district, final String up, final String un, final String village, final String select_gender) {
        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser rUser = firebaseAuth.getCurrentUser();
                    assert rUser != null;
                    String userId = rUser.getUid();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("userId",userId);
                    hashMap.put("username",user_name);
                    hashMap.put("phone_number",phone_number);
                    hashMap.put("email",email);
                    hashMap.put("password",password);
                    hashMap.put("voter_id",voter_id);
                    hashMap.put("division",division);
                    hashMap.put("district",district);
                    hashMap.put("up",up);
                    hashMap.put("un",un);
                    hashMap.put("village",village);
                    hashMap.put("gender",select_gender);
                    hashMap.put("imageUrl","default");
                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()){
                                Intent intent = new Intent(Register_activity.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register_activity.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(Register_activity.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT);
                }
            }
        });
    }

}

