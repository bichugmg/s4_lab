package com.example.andlabb.tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
RadioGroup rg;
RadioButton rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        rg=findViewById(R.id.gender);
        

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = rg.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                rb = (RadioButton) findViewById(selectedId);

                Toast.makeText(Main5Activity.this,
                        rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
