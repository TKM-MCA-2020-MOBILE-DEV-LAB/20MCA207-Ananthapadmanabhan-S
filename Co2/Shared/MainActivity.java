package com.example.intend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    Button mButton;

    EditText send_text1;
    EditText send_text2;
    EditText send_text3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = (Button) findViewById(R.id.button);
        send_text1=(EditText)findViewById(R.id.editText) ;
        send_text2=(EditText)findViewById(R.id.editText4) ;
        send_text3=(EditText)findViewById(R.id.editText5) ;


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 =send_text1.getText().toString();
                String str2=send_text2.getText().toString();
                String int3=send_text3.getText().toString();

                //you can use anything in place of i
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("name",str1);
                i.putExtra("mail",str2);
                i.putExtra("phone",int3);

                startActivity(i);
                SharedPreferences sharedpref=getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedpref.edit();
                editor.putString("name",str1);
                editor.apply();
                SharedPreferences sharedpref1=getSharedPreferences("pref1",MODE_PRIVATE);
                SharedPreferences.Editor editor1=sharedpref1.edit();
                editor1.putString("mail",str2);
                editor1.apply();
                SharedPreferences sharedpref2=getSharedPreferences("pref2",MODE_PRIVATE);
                SharedPreferences.Editor editor2=sharedpref2.edit();
                editor2.putString("phone",int3);

                editor2.apply();

            }
        });
        SharedPreferences getsharedValue=getSharedPreferences("pref",MODE_PRIVATE);
        String value=getsharedValue.getString("name","default value");
        send_text1.setText(value);
        SharedPreferences getsharedValue1=getSharedPreferences("pref1",MODE_PRIVATE);
        String value1=getsharedValue1.getString("mail","default value");
        send_text2.setText(value1);
        SharedPreferences getsharedValue2=getSharedPreferences("pref2",MODE_PRIVATE);
        String value2=getsharedValue2.getString("phone","default value");
        send_text3.setText(value2);
    }}
