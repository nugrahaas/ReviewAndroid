package com.example.reviewandroid.LayoutActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.reviewandroid.MainActivity;
import com.example.reviewandroid.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Daftar(View view) {
        Intent intent = new Intent(Register.this, MainActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
}
