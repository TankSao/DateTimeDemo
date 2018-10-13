package com.example.administrator.datetimedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnDateTimelistener{

    private TextView date,time,week;
    private DateTimeUtil dateTimeUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = (TextView)findViewById(R.id.date);
        time = (TextView)findViewById(R.id.time);
        week = (TextView)findViewById(R.id.week);
        dateTimeUtil = DateTimeUtil.getInstance();
        new DateTimeThread(this).start();
    }

    @Override
    public void onDateTime() {
        date.setText(dateTimeUtil.getCurrentDate());
        week.setText(dateTimeUtil.getCurrentWeekDay(0));
        time.setText(dateTimeUtil.getCurrentTimeHHMM());
    }
}
