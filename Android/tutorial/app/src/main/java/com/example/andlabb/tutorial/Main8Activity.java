package com.example.andlabb.tutorial;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Main8Activity extends Activity {
RelativeLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        tl=findViewById(R.id.abc);
// initiate view's
        ImageButton simpleImageButtonHome = (ImageButton)findViewById(R.id.simpleImageButtonHome);
        ImageButton simpleImageButtonYouTube = (ImageButton)findViewById(R.id.simpleImageButtonYouTube);

// perform click event on button's
        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tl.setBackgroundResource(R.drawable.home);
            }
        });
        simpleImageButtonYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tl.setBackgroundResource(R.drawable.utube);
            }
        });
    }


}