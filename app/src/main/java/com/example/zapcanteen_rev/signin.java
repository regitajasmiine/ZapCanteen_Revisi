package com.example.zapcanteen_rev;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zapcanteen_rev.MainActivity;
import com.example.zapcanteen_rev.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class signin extends AppCompatActivity {
        private EditText mEmailField;
        private EditText mPasswordField;
        private Button mloginBtn;
        private FirebaseAuth mAuth;

        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);
            //Membuat FullScreen

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            mEmailField = (EditText) findViewById(R.id.editText3);
            mPasswordField = (EditText) findViewById(R.id.editText4);
            mloginBtn = (Button) findViewById(R.id.button);

            mAuth = FirebaseAuth.getInstance();
            mloginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Login();
                }
            });

        }


        private void Login() {
            String email = mEmailField.getText().toString();
            String password = mPasswordField.getText().toString();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(signin.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
