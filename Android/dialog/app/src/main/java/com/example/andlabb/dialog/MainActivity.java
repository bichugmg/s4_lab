package com.example.andlabb.dialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listItems;
    Button cButton,mButton;
    String[] courseItems;
    Button b;
    EditText e1;
    Button submit;
    DatabaseHandler db;
    boolean[] Selectedtruefalse = new boolean[]{
            false,
            false,
            false,
            false,
            false
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         db = new DatabaseHandler(this);


        listItems = getResources().getStringArray(R.array.Gender);
        courseItems = getResources().getStringArray(R.array.Course);
        mButton = (Button) findViewById(R.id.button1);
        e1 = (EditText) findViewById(R.id.name);
        cButton = (Button) findViewById(R.id.button2);

        b = (Button) findViewById(R.id.button3);

        submit = (Button) findViewById(R.id.button4);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mButton.setText(listItems[i]);
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cButton.setText("");
                AlertDialog.Builder cBuilder = new AlertDialog.Builder(MainActivity.this);

                cBuilder.setMultiChoiceItems(courseItems, Selectedtruefalse, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {



                    }
                });
                cBuilder.setCancelable(false);

                cBuilder.setTitle("Select Subjects Here");

                cBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        int a = 0;
                        while (a < Selectedtruefalse.length) {
                            boolean value = Selectedtruefalse[a];

                            if (value) {
                                cButton.setText(cButton.getText() + courseItems[a] + "\n");
                            }

                            a++;
                        }

                    }
                });

                cBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });

                AlertDialog dialog = cBuilder.create();

                dialog.show();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final View dialogView = View.inflate(MainActivity.this, R.layout.datetime, null);
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);


                        b.setText(datePicker.getDayOfMonth() + "-" + datePicker.getMonth() + "-" + datePicker.getYear());

                        alertDialog.dismiss();
                    }
                });
                alertDialog.setView(dialogView);
                alertDialog.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setTitle("Submit");
                alertDialogBuilder.setMessage("Click OK to submit!");
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        AddData();
                        Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                        startActivity(i);
                    }

                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }

        });
    }
        public void AddData(){
            boolean isInserted = db.insertData(e1.getText().toString(),
                    mButton.getText().toString(),
                    cButton.getText().toString(),
                    b.getText().toString() );
            if(isInserted == true)
                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
        }



}

