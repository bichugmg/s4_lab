package com.example.andlabb.dialog;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Main2Activity extends AppCompatActivity {
    Button bt;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         db = new DatabaseHandler(this);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewAll();
            }
        });


    }

    public void viewAll() {
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = db.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("id :" + res.getString(0) + "\n");
                            buffer.append("name :" + res.getString(1) + "\n");
                            buffer.append("gender :" + res.getString(2) + "\n");
                            buffer.append("courses :" + res.getString(3) + "\n");
                            buffer.append("dob :" + res.getString(4) + "\n\n");
                        }

                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

 public void showMessage(String title,String Message){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setCancelable(true);
    builder.setTitle(title);
    builder.setMessage(Message);
    builder.show();
}
}

