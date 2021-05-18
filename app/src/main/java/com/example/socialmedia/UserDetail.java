package com.example.socialmedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class UserDetail extends AppCompatActivity {
    ImageView profileImageView;
    TextView Nameview;
    TextView Email;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        profileImageView = findViewById(R.id.Profilepc);
        Nameview= findViewById(R.id.Name);
        Email = findViewById(R.id.Email);
        String name = getIntent().getStringExtra("Name");
        String email = getIntent().getStringExtra("Email");
        String photourl = getIntent().getStringExtra("Profile");
        Picasso.get().load(photourl).into(profileImageView);
        Nameview.setText(name);
        Email.setText(email);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutitem:
                mAuth.signOut();
                startActivity(new Intent(UserDetail.this, MainActivity.class));
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}