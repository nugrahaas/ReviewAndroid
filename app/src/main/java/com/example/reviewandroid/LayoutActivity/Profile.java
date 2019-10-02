package com.example.reviewandroid.LayoutActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.reviewandroid.Category.Dapur;
import com.example.reviewandroid.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void CekPost(View view) {
        Intent intent = new Intent(Profile.this, Post.class);
        startActivity(intent);
    }
}
