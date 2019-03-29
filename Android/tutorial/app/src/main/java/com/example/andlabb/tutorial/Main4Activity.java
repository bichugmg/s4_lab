package com.example.andlabb.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main4Activity extends AppCompatActivity {
ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tb=findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Toast.makeText(getApplicationContext(),"on",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"off",Toast.LENGTH_LONG).show();
            }
        });
    }
}
