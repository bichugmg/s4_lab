package com.example.andlabb.tutorial;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main9Activity extends AppCompatActivity {
    TimePicker tp;
    Button b;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        tp=findViewById(R.id.timepicker);
        b=findViewById(R.id.b);
        tv=findViewById(R.id.tv);
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                tv.setText(tp.getHour()+":"+tp.getMinute());
            }
        });
    }
}
