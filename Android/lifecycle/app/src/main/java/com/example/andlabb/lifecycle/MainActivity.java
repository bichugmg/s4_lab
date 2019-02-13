package com.example.andlabb.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("cycle","Oncreate");
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("cycle","onstart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("cycle","onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("cycle","ondestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("cycle","onpause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("cycle","onresume");
    }

}

