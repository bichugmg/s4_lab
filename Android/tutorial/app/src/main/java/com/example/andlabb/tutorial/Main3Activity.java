package com.example.andlabb.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    EditText et;
    CheckBox cb1,cb2,cb3;
    ArrayList<String> s = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        et=findViewById(R.id.tv);
        cb1=findViewById(R.id.india);
        cb2=findViewById(R.id.sri);
        cb3=findViewById(R.id.paki);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    s.add("INDIA");
                    et.setText(s.toString());
                }
                else {
                    s.remove("INDIA");
                    et.setText(s.toString());
                }


            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    s.add("SRILANKA");
                    et.setText(s.toString());
                }
                else {
                    s.remove("SRILANKA");
                    et.setText(s.toString());
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    s.add("PAKISTAN");
                    et.setText(s.toString());
                }
                else {
                    s.remove("PAKISTAN");
                    et.setText(s.toString());
                }
            }
        });

    }
}
