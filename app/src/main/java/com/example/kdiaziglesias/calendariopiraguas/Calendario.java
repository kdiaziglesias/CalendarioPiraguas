package com.example.kdiaziglesias.calendariopiraguas;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TimePicker;


public class Calendario extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


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
