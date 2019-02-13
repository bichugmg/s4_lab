package com.example.andlabb.callback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button b;
EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b=(Button)findViewById(R.id.button );
    t=(EditText)findViewById(R.id.editText);

    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent shabi=new Intent(MainActivity.this,MainActivity2.class);
            shabi.putExtra("text",t.getText().toString());
            startActivity(shabi);
        }
    });


    }
}
