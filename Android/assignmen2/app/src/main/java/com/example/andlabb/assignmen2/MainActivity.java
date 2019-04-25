package com.example.andlabb.assignmen2;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    Button b1;
    LinearLayout ll;
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.fcolor);
        t2=findViewById(R.id.bcolor);
        b1=findViewById(R.id.b1);
        ll=findViewById(R.id.ll);

        SharedPreferences prefs = getSharedPreferences("color", MODE_PRIVATE);
        String bcolor = prefs.getString("bcolor", null);
        String fcolor = prefs.getString("fcolor", null);
        if (bcolor != null) {
            ll.setBackground(new ColorDrawable(Color.parseColor(bcolor)));
            //ll.setForeground(new ColorDrawable(Color.parseColor(fcolor)));
            
        }
        else
        {
            ll.setBackground(new ColorDrawable(Color.parseColor("#000000")));
           // ll.setForeground(new ColorDrawable(Color.parseColor("#ffffff")));
        }


        b1.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                ll.setBackground(new ColorDrawable(Color.parseColor(t1.getText().toString())));
               // ll.setForeground(new ColorDrawable(Color.parseColor(t2.getText().toString())));
                SharedPreferences.Editor editor = getSharedPreferences("color", MODE_PRIVATE).edit();
                editor.putString("fcolor", t1.getText().toString());
                editor.putString("bcolor", t2.getText().toString());
                editor.apply();
            }
        });
    }
}
