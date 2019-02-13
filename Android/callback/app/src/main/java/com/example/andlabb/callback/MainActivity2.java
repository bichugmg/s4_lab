package com.example.andlabb.callback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent shabi=getIntent();
        Toast.makeText(getApplicationContext(),shabi.getStringExtra("text") ,Toast.LENGTH_LONG).show();
    }
}
