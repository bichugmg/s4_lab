package com.example.andlabb.digitalclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextClock;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    TextClock textClock;
    Button b;
    TimePicker timePicker;
    AlarmManager alarmManager;
    ToggleButton toggleButton;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textClock=findViewById(R.id.textClock);
        timePicker=findViewById(R.id.timepicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        toggleButton=findViewById(R.id.toggle);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                long time;


                if (buttonView.isChecked())
                {
                    Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());

                    Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);

                    time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
                    if(System.currentTimeMillis()>time)
                    {
                        if (calendar.AM_PM == 0)
                            time = time + (1000*60*60*12);
                        else
                            time = time + (1000*60*60*24);
                    }
                        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);

                }
                else
                {
                    alarmManager.cancel(pendingIntent);
                    Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });





        b=findViewById(R.id.tts);

         textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                            || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                    } else {

                    }

                } else {

                }
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = textClock.getText().toString();

                int speechStatus = textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH, null);

                if (speechStatus == TextToSpeech.ERROR) {

                }
            }
        });

    }


}
