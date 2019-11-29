package com.example.reviewandroid.LayoutActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reviewandroid.Entitas.User;
import com.example.reviewandroid.MainActivity;
import com.example.reviewandroid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseUser;
    EditText editTextUsername, editTextPass;
    String email_txt,password_txt;
    FirebaseAuth mAuth;
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        editTextUsername = (EditText) findViewById(R.id.et_username);
        btn_login = (Button) findViewById(R.id.btn_login);
        editTextPass = (EditText) findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_txt = editTextUsername.getText().toString();
                password_txt = editTextPass.getText().toString();
                if (TextUtils.isEmpty(email_txt)) {
                    Toast.makeText(getApplicationContext(), "Masukan Email !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password_txt)) {
                    Toast.makeText(getApplicationContext(), "Masukan Password !!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email_txt, password_txt)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Login sukses, masuk ke Main Activity
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(Login.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(Login.this, "Selamat Datang " + user, Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    // Jika Login gagal, memberikan pesan
                                    Toast.makeText(Login.this, "Proses Login gagal : " +  task.getException(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }

    public void Daftar(View view) {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }


    public void loginUser(){



    }


}
