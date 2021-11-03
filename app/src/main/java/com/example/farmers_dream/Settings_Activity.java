package com.example.farmers_dream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Settings_Activity extends AppCompatActivity {

    private TextView profile_name;
    private CircleImageView circleImageView;
    private FirebaseAuth firebaseAuth;
    private ImageRecyclerAdapter imageRecyclerAdapter;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private List<ImageList> imageList;
    private static final int IMAGE_REQUEST = 1;
    private StorageTask storageTask;
    private Uri imageUri;
    private StorageReference storageReference;
    private UsersData usersData;
    private FirebaseFirestore fStore;
    String userId;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    View header;
    private ImageView closeImageView;
    private EditText oldpassword, newpassword;
    private ProgressBar progressBar;
    private EditText user_Name, phone_Number, Email, Password, voter_Id, Division, District, Up, Un, Village;
    private RadioGroup radioGroup;
    private Button profileChangeBtn;

    private LinearLayout linearLayout, linearLayout2;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_);

        linearLayout = findViewById(R.id.linierlayout_password_change_id);
        linearLayout2 = findViewById(R.id.linierlayout_profile_change_id);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Settings_Activity.this);
                dialog.setContentView(R.layout.activity_password__change_);
                closeImageView = dialog.findViewById(R.id.close_buttton_id);
                oldpassword = dialog.findViewById(R.id.old_password);
                newpassword = dialog.findViewById(R.id.new_password);
                progressBar = dialog.findViewById(R.id.progressbar);
                Button passwordChangeButtonId = dialog.findViewById(R.id.password_change_btn_id);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                closeImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                passwordChangeButtonId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String oldPassword = oldpassword.getText().toString().trim();
                        String newPassword = newpassword.getText().toString().trim();
                        if (TextUtils.isEmpty(oldPassword)) {
                            Toast.makeText(Settings_Activity.this, "Enter your current password", Toast.LENGTH_SHORT).show();
                        }
                        if (newPassword.length() <= 6) {
                            Toast.makeText(Settings_Activity.this, "Password length must atlest 6 character", Toast.LENGTH_SHORT).show();
                        }
                        updatePassword(oldPassword, newPassword);
                    }
                });

            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog1 = new Dialog(Settings_Activity.this);
                dialog1.setContentView(R.layout.activity_profile__change_);
                closeImageView = dialog1.findViewById(R.id.close_buttton_id);


                user_Name = dialog1.findViewById(R.id.user_name);
                phone_Number = dialog1.findViewById(R.id.phone_number);
                Email = dialog1.findViewById(R.id.email_id);
                Password = dialog1.findViewById(R.id.password);
                voter_Id = dialog1.findViewById(R.id.voter_id);
                Division = dialog1.findViewById(R.id.division_id);
                District = dialog1.findViewById(R.id.district_id);
                Up = dialog1.findViewById(R.id.up_id);
                Un = dialog1.findViewById(R.id.un_id);
                Village = dialog1.findViewById(R.id.village_id);
                radioGroup = dialog1.findViewById(R.id.radio_button);


                profileChangeBtn = dialog1.findViewById(R.id.profile_change_btn);
                progressBar = dialog1.findViewById(R.id.progressbar);

                dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog1.show();

                firebaseAuth = FirebaseAuth.getInstance();
                firebaseUser = firebaseAuth.getCurrentUser();
                databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        usersData = snapshot.getValue(UsersData.class);

                        assert usersData != null;
                        user_Name.setText(usersData.getUsername());
                        phone_Number.setText(usersData.getPhone_number());
                        Email.setText(usersData.getEmail());
                        Password.setText(usersData.getPassword());
                        voter_Id.setText(usersData.getVoter_id());
                        Division.setText(usersData.getDivision());
                        District.setText(usersData.getDistrict());
                        Up.setText(usersData.getUp());
                        Un.setText(usersData.getUn());
                        Village.setText(usersData.getVillage());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Settings_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                closeImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
                profileChangeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String userName = user_Name.getText().toString().trim();
                        String phoneNumber = phone_Number.getText().toString().trim();
                        String email = Email.getText().toString().trim();
                        String password = Password.getText().toString().trim();
                        String voterId = voter_Id.getText().toString().trim();
                        String division = Division.getText().toString().trim();
                        String district = District.getText().toString().trim();
                        String up = Up.getText().toString().trim();
                        String un = Un.getText().toString().trim();
                        String village = Village.getText().toString().trim();
                        int selectRadioButtonId = radioGroup.getCheckedRadioButtonId();
                        radioButton = dialog1.findViewById(selectRadioButtonId);


                        if (radioButton == null) {
                            Toast.makeText(Settings_Activity.this, "Select gender please", Toast.LENGTH_SHORT).show();
                        } else {
                            final String gender = radioButton.getText().toString();
                            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(phoneNumber) || TextUtils.isEmpty(email) ||
                                    TextUtils.isEmpty(password) || TextUtils.isEmpty(voterId) || TextUtils.isEmpty(division) ||
                                    TextUtils.isEmpty(district) || TextUtils.isEmpty(up) || TextUtils.isEmpty(un) || TextUtils.isEmpty(village)) {
                                Toast.makeText(Settings_Activity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                            } else {
                                if (password.length() <= 6) {
                                    Toast.makeText(Settings_Activity.this, "Password length must atlest 6 character", Toast.LENGTH_SHORT).show();
                                } else {
                                    updateProfileData(userName, phoneNumber, email, password, voterId, division, district, up, un, village, gender);
                                }
                            }
                        }
                    }
                });
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        imageList = new ArrayList<>();
        profile_name = findViewById(R.id.profile_name_id);
        circleImageView = findViewById(R.id.profileimage);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        storageReference = FirebaseStorage.getInstance().getReference("profile_images");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                usersData = snapshot.getValue(UsersData.class);

                assert usersData != null;
                profile_name.setText(usersData.getUsername());
                if (usersData.getImageURL().equals("default")) {
                    circleImageView.setImageResource(R.drawable.ic_launcher_background);
                } else {
                    Glide.with(getApplicationContext()).load(usersData.getImageURL()).into(circleImageView);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Settings_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        // for show the navigation bar

        drawerLayout = findViewById(R.id.drawer_id);
        navigationView = findViewById(R.id.navigaiton_id);
        header = navigationView.getHeaderView(0);
        circleImageView = header.findViewById(R.id.profileimage);
        profile_name = header.findViewById(R.id.profile_name_id);

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Settings_Activity.this);
                builder.setCancelable(true);
                View nView = LayoutInflater.from(Settings_Activity.this).inflate(R.layout.select_image_layout, null);
                RecyclerView recyclerView = nView.findViewById(R.id.recyclerview_id);
                collectOldImages();
                recyclerView.setLayoutManager(new GridLayoutManager(Settings_Activity.this, 3));
                recyclerView.setHasFixedSize(true);
                imageRecyclerAdapter = new ImageRecyclerAdapter(imageList, Settings_Activity.this);
                recyclerView.setAdapter(imageRecyclerAdapter);
                imageRecyclerAdapter.notifyDataSetChanged();
                final Button openImage = nView.findViewById(R.id.open_image_id);
                openImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openImage();
                    }
                });
                builder.setView(nView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                if (item.getItemId() == R.id.home_id) {
                    intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.settings_id) {
                    intent = new Intent(Settings_Activity.this, Settings_Activity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.jogajog_id) {
                    intent = new Intent(Settings_Activity.this, Jogajog_Activity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.baboharbidi_id) {
                    intent = new Intent(Settings_Activity.this, Baboharbidi_Activity.class);
                    startActivity(intent);
                }
                if (item.getItemId() == R.id.logout_id) {
                    FirebaseAuth.getInstance().signOut();
                    finish();
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });


        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


    private void updateProfileData(String userName, String phoneNumber, String email, String password, String voterId, String division, String district, String up, String un, String village, String gender) {

        progressBar.setVisibility(View.VISIBLE);
//       get current user
//        FirebaseUser userId = firebaseAuth.getCurrentUser();
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId.getUid());
//        Map<String, Object> updateData = new HashMap<>();
//        updateData.put("/Users/username", email);
//        updateData.put("/Users/phone_number", phoneNumber);
//        updateData.put("/Users/email", email);
//        updateData.put("/Users/password", password);
//        updateData.put("/Users/voter_id", voterId);
//        updateData.put("/Users/division", division);
//        updateData.put("/Users/district", district);
//        updateData.put("/Users/up", up);
//        updateData.put("/Users/un", un);
//        updateData.put("/Users/village", village);
//        updateData.put("/Users/gender", gender);
//        databaseReference.updateChildren(updateData).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Toast.makeText(Settings_Activity.this,"Update successfull",Toast.LENGTH_SHORT).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Settings_Activity.this,"not successfull"+e,Toast.LENGTH_SHORT).show();
//            }
//        });

        FirebaseUser user = firebaseAuth.getCurrentUser();

        user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                progressBar.setVisibility(View.GONE);
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
                HashMap<String, Object> edited = new HashMap<String, Object>();
                edited.put("username", userName);
                edited.put("phone_number", phoneNumber);
                edited.put("email", email);
                edited.put("password", password);
                edited.put("voter_id", voterId);
                edited.put("division", division);
                edited.put("district", district);
                edited.put("up", up);
                edited.put("un", un);
                edited.put("village", village);
                edited.put("gender", gender);
                databaseReference.updateChildren(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(Settings_Activity.this, "Profile Update", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(Settings_Activity.this, " " + e, Toast.LENGTH_SHORT).show();
                    }
                });
                Toast.makeText(Settings_Activity.this, "Email has changed", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(Settings_Activity.this, " " + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updatePassword(String oldPassword, String newPassword) {
        progressBar.setVisibility(View.VISIBLE);
        // get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        // before changing password re-authenticate the user
        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), oldPassword);
        user.reauthenticate(authCredential)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Successful authenticate , begin update
                        user.updatePassword(newPassword)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        // Password Update
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(Settings_Activity.this, "Password Update", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        //Password update failed , show reason
                                        progressBar.setVisibility(View.GONE);
                                        Toast.makeText(Settings_Activity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Authenticate failed , reason
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(Settings_Activity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            if (storageTask != null && storageTask.isInProgress()) {
                Toast.makeText(this, "Uploading in progress", Toast.LENGTH_SHORT).show();
            } else {
                uploadImage();
            }
        }
    }

    private void uploadImage() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Uploading image");
        progressDialog.show();
        if (imageUri != null) {
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            assert bitmap != null;
            bitmap.compress(Bitmap.CompressFormat.JPEG, 25, byteArrayOutputStream);
            byte[] imageFileToByte = byteArrayOutputStream.toByteArray();
            final StorageReference imageReference = storageReference.child(usersData.getUsername() + System.currentTimeMillis() + ".jpg");
            storageTask = imageReference.putBytes(imageFileToByte);
            storageTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();

                    }
                    return imageReference.getDownloadUrl();

                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful()) {
                        Uri downloadUri = task.getResult();
                        String sDownloadUri = downloadUri.toString();
                        HashMap<String, Object> hasMap = new HashMap<>();
                        hasMap.put("imageUrl", sDownloadUri);
                        databaseReference.updateChildren(hasMap);
                        final DatabaseReference profileImageReference = FirebaseDatabase.getInstance().getReference("profile_images").child(firebaseUser.getUid());
                        profileImageReference.push().setValue(hasMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    progressDialog.dismiss();

                                } else {
                                    progressDialog.dismiss();
                                    Toast.makeText(Settings_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(Settings_Activity.this, "Faield", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Settings_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            });
        }

    }

    private void collectOldImages() {
        DatabaseReference imageListReference = FirebaseDatabase.getInstance().getReference("profile_images").child(firebaseUser.getUid());
        imageListReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                imageList.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    imageList.add(snapshot1.getValue(ImageList.class));
                }
                imageRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Settings_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        if (item.getItemId() == R.id.appsomprokhito_id) {
            Intent intent = new Intent(Settings_Activity.this, Apps_Shomporkhito_Activity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}