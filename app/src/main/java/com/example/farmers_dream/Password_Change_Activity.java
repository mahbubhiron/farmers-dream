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

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Password_Change_Activity extends AppCompatActivity {
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

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    View header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password__change_);

//        ImageShowAndNavigationViewMethod();

    }
}
//close onCreate method


    // start for show the navigation bar and show header image from firebase database
//    public void ImageShowAndNavigationViewMethod() {
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("");
//
//        drawerLayout = findViewById(R.id.drawer_id);
//        navigationView = findViewById(R.id.navigaiton_id);
//        header = navigationView.getHeaderView(0);
//        circleImageView = header.findViewById(R.id.profileimage);
//        profile_name = header.findViewById(R.id.profile_name_id);
//
//        imageList = new ArrayList<>();
//        firebaseAuth = FirebaseAuth.getInstance();
//        firebaseUser = firebaseAuth.getCurrentUser();
//        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
//        storageReference = FirebaseStorage.getInstance().getReference("profile_images");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                usersData = snapshot.getValue(UsersData.class);
//
//                assert usersData != null;
//                profile_name.setText(usersData.getUsername());
//                if (usersData.getImageURL().equals("default")) {
//                    circleImageView.setImageResource(R.drawable.ic_launcher_background);
//                } else {
//                    Glide.with(getApplicationContext()).load(usersData.getImageURL()).into(circleImageView);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(Password_Change_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        circleImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Password_Change_Activity.this);
//                builder.setCancelable(true);
//                View nView = LayoutInflater.from(Password_Change_Activity.this).inflate(R.layout.select_image_layout, null);
//                RecyclerView recyclerView = nView.findViewById(R.id.recyclerview_id);
//                collectOldImages();
//                recyclerView.setLayoutManager(new GridLayoutManager(Password_Change_Activity.this, 3));
//                recyclerView.setHasFixedSize(true);
//                imageRecyclerAdapter = new ImageRecyclerAdapter(imageList, Password_Change_Activity.this);
//                recyclerView.setAdapter(imageRecyclerAdapter);
//                imageRecyclerAdapter.notifyDataSetChanged();
//                final Button openImage = nView.findViewById(R.id.open_image_id);
//                openImage.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        openImage();
//                    }
//                });
//                builder.setView(nView);
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//            }
//        });
//
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Intent intent;
//                if (item.getItemId() == R.id.home_id) {
//                    intent = new Intent(getApplicationContext(), HomePageActivity.class);
//                    startActivity(intent);
//                }
//                if (item.getItemId() == R.id.settings_id) {
//                    intent = new Intent(Password_Change_Activity.this, Settings_Activity.class);
//                    startActivity(intent);
//                }
//                if (item.getItemId() == R.id.jogajog_id) {
//                    intent = new Intent(Password_Change_Activity.this, Jogajog_Activity.class);
//                    startActivity(intent);
//                }
//                if (item.getItemId() == R.id.baboharbidi_id) {
//                    intent = new Intent(Password_Change_Activity.this, Baboharbidi_Activity.class);
//                    startActivity(intent);
//                }
//                if (item.getItemId() == R.id.logout_id) {
//                    FirebaseAuth.getInstance().signOut();
//                    finish();
//                    intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                }
//                return false;
//            }
//        });
//
//
//        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }
//    // close for show the navigation bar and show header image from firebase database
//
//
//    // start for change or update header image
//    private void openImage() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent, IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
//            if (storageTask != null && storageTask.isInProgress()) {
//                Toast.makeText(this, "Uploading in progress", Toast.LENGTH_SHORT).show();
//            } else {
//                uploadImage();
//            }
//        }
//    }
//
//    private void uploadImage() {
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Uploading image");
//        progressDialog.show();
//        if (imageUri != null) {
//            Bitmap bitmap = null;
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            assert bitmap != null;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 25, byteArrayOutputStream);
//            byte[] imageFileToByte = byteArrayOutputStream.toByteArray();
//            final StorageReference imageReference = storageReference.child(usersData.getUsername() + System.currentTimeMillis() + ".jpg");
//            storageTask = imageReference.putBytes(imageFileToByte);
//            storageTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
//                @Override
//                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
//                    if (!task.isSuccessful()) {
//                        throw task.getException();
//
//                    }
//                    return imageReference.getDownloadUrl();
//
//                }
//            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
//                @Override
//                public void onComplete(@NonNull Task<Uri> task) {
//                    if (task.isSuccessful()) {
//                        Uri downloadUri = task.getResult();
//                        String sDownloadUri = downloadUri.toString();
//                        HashMap<String, Object> hasMap = new HashMap<>();
//                        hasMap.put("imageUrl", sDownloadUri);
//                        databaseReference.updateChildren(hasMap);
//                        final DatabaseReference profileImageReference = FirebaseDatabase.getInstance().getReference("profile_images").child(firebaseUser.getUid());
//                        profileImageReference.push().setValue(hasMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                            @Override
//                            public void onComplete(@NonNull Task<Void> task) {
//                                if (task.isSuccessful()) {
//                                    progressDialog.dismiss();
//
//                                } else {
//                                    progressDialog.dismiss();
//                                    Toast.makeText(Password_Change_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                    } else {
//                        Toast.makeText(Password_Change_Activity.this, "Faield", Toast.LENGTH_SHORT).show();
//                        progressDialog.dismiss();
//                    }
//
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(Password_Change_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            });
//        }
//
//    }
//
//    private void collectOldImages() {
//        DatabaseReference imageListReference = FirebaseDatabase.getInstance().getReference("profile_images").child(firebaseUser.getUid());
//        imageListReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                imageList.clear();
//                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
//                    imageList.add(snapshot1.getValue(ImageList.class));
//                }
//                imageRecyclerAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(Password_Change_Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    // start for change or update header image
//
//
//    //Start menu item property
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu_layout, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (toggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        if (item.getItemId() == R.id.motamot_id) {
//            Intent intent = new Intent(Password_Change_Activity.this, Motamot_Activity.class);
//            return true;
//        }
//        if (item.getItemId() == R.id.appsomprokhito_id) {
//            Intent intent = new Intent(Password_Change_Activity.this, Apps_Shomporkhito_Activity.class);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//    //close menu item property
//
//}