package com.example.myapplication0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nomal_some);

        DatePicker picker = findViewById(R.id.datePicker);

        //月份起始为0
        picker.init(1992, 11, 21, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Toast.makeText(getApplicationContext(),year + "年"+(monthOfYear + 1)+"月"+dayOfMonth + "日",Toast.LENGTH_LONG).show();
            }
        });

        TimePicker timerPicker = findViewById(R.id.timerPicker);

        timerPicker.setIs24HourView(true);

        timerPicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Toast.makeText(getApplicationContext(),hourOfDay + "h" + minute + "min",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
