package com.example.reviewandroid.LayoutActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.reviewandroid.Category.Dapur;
import com.example.reviewandroid.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    TextView tv_email_profile;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tv_email_profile = findViewById(R.id.tv_email_profile);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        tv_email_profile.setText(user.getEmail().toString());


    }

    public void CekPost(View view) {
        Intent intent = new Intent(Profile.this, Post.class);
        startActivity(intent);
    }
}
