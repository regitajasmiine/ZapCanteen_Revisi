package com.example.zapcanteen_rev;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    Button btn_regis;
    EditText username,nis,kelas,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_regis = (Button) findViewById(R.id.button3);
        username  = (EditText) findViewById(R.id.editText6);
        nis       = (EditText) findViewById(R.id.editText);
        kelas     = (EditText) findViewById(R.id.editText5);
        password  = (EditText) findViewById(R.id.editText2);



        mAuth = FirebaseAuth.getInstance();

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = username.getText().toString();
                String nis      = nis.getText().toString();
                String kelas    = kelas.getText().toString();
                String password = password.getText().toString();


                if (username.isEmpty()){
                    username.setError("username kosong");
                    username.requestFocus();
                    return;
                }
                if (nis.isEmpty()){
                    nis.setError("username kosong");
                    nis.requestFocus();
                    return;
                }
                if (kelas.isEmpty()){
                    kelas.setError("username kosong");
                    kelas.requestFocus();
                    return;
                }
                if (password.isEmpty()){
                    password.setError("password kosong");
                    password.requestFocus();
                    return;
                }else if(password.length()<6){
                    password.setError("Minimal 6 digit password");
                    password.requestFocus();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(username,nis,kelas,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signup.this, "Berhasil", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup.this, "Sign Up gagal", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }

}

