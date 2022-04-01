package com.example.regindent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4,ed5;
    Button bts1;
    Pattern patterns;
    Matcher matches;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.name);
        ed3 = (EditText) findViewById(R.id.email);
        ed4 = (EditText) findViewById(R.id.phno);
        ed5 = (EditText) findViewById(R.id.pswrd);
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        bts1 = (Button) findViewById(R.id.bt);
        bts1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REGISTER();
            Intent i = new Intent(getApplicationContext(), Regindent2.class);
            startActivity(i);
        }
        });
    }
    public void REGISTER() {
        String email = ed3.getText().toString().trim();
        if (ed3.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_SHORT).show();
            ed3.requestFocus();
            ed3.setError("Enter valid email");
            return;
        }
        if (!email.matches(emailPattern)) {
            ed3.requestFocus();
            ed3.setError("Invalid email");

        } else {
            Toast.makeText(getApplicationContext(), "validation succesful!!!", Toast.LENGTH_SHORT).show();
        }
        if (ed4.getText().toString().length() <8 ) {
            ed4.requestFocus();
            ed4.setError("Enter  a valid phone no");
            return;
        }
            if (ed5.getText().toString().length() == 0) {
                ed5.requestFocus();
                ed5.setError("Enter valid password");
                return;
            }
            if (ed5.getText().toString().length() < 8) {
                ed5.requestFocus();
                ed5.setError("Enter minimum 8 digit password");
                return;
            }
        }

    }
