package com.example.andlabb.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main7Activity extends AppCompatActivity {
ImageView iv;
Button b;
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        iv=findViewById(R.id.image);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0)
                {
                    iv.setImageResource(R.drawable.android1);
                    i=1;
                }else if(i==1)
                {
                    iv.setImageResource(R.drawable.android2);
                    i=0;
                }

            }
        });

    }
}
