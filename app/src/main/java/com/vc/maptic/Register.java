package com.vc.maptic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText iFullName,iEmail,iPassword;
    Button iRegisterButton;
    TextView iLoginText;
    ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        iFullName = findViewById(R.id.fullNameField);
        iEmail    = findViewById(R.id.emailField);
        iPassword = findViewById(R.id.passwordField);
        iRegisterButton = findViewById(R.id.loginButton);
        iLoginText = findViewById(R.id.registerText);
        progressBar = findViewById(R.id.progressBar);

        fAuth = FirebaseAuth.getInstance();


        if(fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        iRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = iEmail.getText().toString().trim();
                String password = iPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    iEmail.setError("Email Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    iPassword.setError("Password Required");
                }
                if(password.length() < 7){
                    iPassword.setError("Password must be at least 8 Characters in length");
                }

                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else{
                            Toast.makeText(Register.this, "Error: "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    public void onBackPressed(){

    }

    public void toLogout(View view) {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}

