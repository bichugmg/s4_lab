package com.example.andlabb.speed_dial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class speedDial extends AppCompatActivity implements View.OnLongClickListener {
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bp, bdot, bm, bmu, bdiv, be, clr;
    EditText editText;
    String num = "", operator = "";
    float fno = 0, sno, result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_dial);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);

        b1.setOnLongClickListener(this);
        b2.setOnLongClickListener(this);
        b3.setOnLongClickListener(this);
        b4.setOnLongClickListener(this);
        b5.setOnLongClickListener(this);
        b6.setOnLongClickListener(this);
        b7.setOnLongClickListener(this);
        b8.setOnLongClickListener(this);
        b9.setOnLongClickListener(this);
        b0.setOnLongClickListener(this);

        if (ContextCompat.checkSelfPermission(speedDial.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(speedDial.this, new String[]{Manifest.permission.CALL_PHONE},1);
        }
        else
        {

        }
    }


    @Override
    public boolean onLongClick(View v) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getApplicationContext(),"no permission",Toast.LENGTH_LONG).show();
            return true;
        }
        if (v == b1) {

            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9605709596"));

            startActivity(intent);
        }
        if(v==b2)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "123456789"));

            startActivity(intent);
        }
        if(v==b3)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "987654321"));

            startActivity(intent);
        }
        if(v==b4)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "43534564536"));

            startActivity(intent);
        }
        if(v==b5)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "3463465"));

            startActivity(intent);
        }
        if(v==b6)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9605709596"));

            startActivity(intent);
        }
        if(v==b7)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9605709596"));

            startActivity(intent);
        }
        if(v==b8)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9605709596"));

            startActivity(intent);
        }
        if(v==b9)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9605709596"));

            startActivity(intent);
        }
        if(v==b0)
        {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9605709596"));

            startActivity(intent);
        }
        return false;
    }
}
