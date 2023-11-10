package com.example.fyptommynorman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET,  pwordET;
    private FirebaseAuth authUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.emailET);
        pwordET = findViewById(R.id.pwordET);
        authUser = FirebaseAuth.getInstance();

        Button loginButton = findViewById(R.id.loginBtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString();
                String password = pwordET.getText().toString();

                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(LoginActivity.this, "Please enter a email", Toast.LENGTH_SHORT).show();
                    emailET.setError("Your email is required to login");
                    emailET.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(LoginActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
                    emailET.setError("Please enter a valid email");
                    emailET.requestFocus();
                } else if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginActivity.this, "Please Enter a password", Toast.LENGTH_SHORT).show();
                    pwordET.setError("Password cannot be left blank");
                    pwordET.requestFocus();
                } else {
                    LoginUser(email, password);
                }





            }
        });

    }

    private void LoginUser(String email, String password) {
        authUser.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Login Succsesfull", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Somthing went wrong, make sure your details are correct", Toast.LENGTH_LONG).show();
                    }

            }
        });
    }
}