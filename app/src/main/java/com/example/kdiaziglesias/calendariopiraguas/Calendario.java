package com.example.kdiaziglesias.calendariopiraguas;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.net.URI;


public class Calendario extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        Cursor cur = null;
        ContentResolver cr = getContentResolver();
        Uri uri = CalendarContract.Calendars.CONTENT_URI;

       /* public static final String[] Campos;
        Campos = new String[]{
                CalendarContract.Calendars._ID,
                CalendarContract.Calendars.ACCOUNT_NAME,
                CalendarContract.Calendars.CALENDAR_DISPLAY_NAME
        };*/


        ContentValues cv = new ContentValues();
        cv.put(CalendarContract.Reminders.MINUTES,15);
        cv.put(CalendarContract.Reminders.EVENT_ID,R.id.checkbox);
        cv.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);

        CheckBox timeCheckBox = (CheckBox)findViewById(R.id.checkbox);

        timeCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            String salutation="";
            String Fecha="";

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int visibility =isChecked? View.VISIBLE:View.GONE;
                View view = findViewById(R.id.timePicker);
                view.setVisibility(visibility);
                view= findViewById(R.id.datePicker);
                view.setVisibility(visibility);
                DatePicker date = (DatePicker)findViewById(R.id.datePicker);
                String dateToShow = date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear();
                TimePicker time = (TimePicker)findViewById(R.id.timePicker);
                dateToShow += " " + time.getCurrentHour() + ":" + time.getCurrentMinute();
                Fecha = salutation + " " +dateToShow;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calender, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
