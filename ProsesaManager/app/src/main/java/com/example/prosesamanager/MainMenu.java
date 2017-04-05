package com.example.prosesamanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import EmployeeData.DataBaseHelper;
import EmployeeData.Employee;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainMenu extends Activity implements AdapterView.OnItemSelectedListener {
    DataBaseHelper myDb;
    /********SPINNERS*******/
    public static Spinner spDay, spMonth, spYear;
    ArrayList<String> days = new ArrayList<String>();
    ArrayList<String> years = new ArrayList<String>();
    /********SPINNERS*******/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /***CREATING ARRAYS FOR LISTENERS***/
        spDay = (Spinner) findViewById(R.id.sp_day);
        spMonth= (Spinner) findViewById(R.id.sp_month);
        spYear = (Spinner) findViewById(R.id.sp_year);

        spDay.setOnItemSelectedListener(this);
        spMonth.setOnItemSelectedListener(this);
        spYear.setOnItemSelectedListener(this);

        ArrayAdapter<String> aaDays, aaMonth, aaYear;
        /**SET DAYS*/
        days.add(0,"Day");
        for(int i = 1; i <=31;i++){days.add(i, ""+i);}
        /**SET MONTHS*/
        String [] months = new String[]{"Month","January","February","March","April",
                "May","June","July","August","September","October","November","December"};
        /**SET YEARS*/
        years.add(0,"Year");
        int actYr = Calendar.getInstance().get(Calendar.YEAR);
        int i=0;
        for(int minYear = actYr-30; minYear < actYr;minYear++){years.add(i, ""+minYear); i++;}
        /*SET ArrayAdapters*/
        aaDays = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, days);
        aaYear = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, years);
        aaMonth = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, months);

        /**INITIALIZE SPINNERS**/
        spDay.setAdapter(aaDays);
        spMonth.setAdapter(aaMonth);
        spYear.setAdapter(aaYear);
        /***CREATING ARRAYS FOR LISTENERS***/

        TextView mWelcome = (TextView) findViewById(R.id.txt_welcome);

        Intent intent = this.getIntent();

        if (intent != null){
            Employee employee = (Employee)intent.getSerializableExtra(Employee.EMPLOYEE_KEY);
            String welcome = "Welcome "+employee.getName()+" "+employee.getLastName()+". User "+employee.getUser()+".";
            //mWelcome.setText(employee.toString());
            mWelcome.setText(welcome);
        }
        else {
            mWelcome.setText("The employe is null");
        }

    }

    Employee dummy = null;

    public void exitMainMenu(View v){
        this.finish();
    }

    public void addEmployee(View v){
        //if(myDb.insertEmployee(employee));


    }

    public void setDateSpinners(View v){

    }





    /*****implements OnItemSelectedListener*****/
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == spMonth.getId()){/*
            int days = getDaysOfMonth(parent.getSelectedItemPosition());
            if((spDay.getCount()-1) > days){*/
                Toast.makeText(this, "MONTH SELECTED", Toast.LENGTH_SHORT).show();
                //resetSpinners();
            }
        //}
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int getDaysOfMonth(int month){
        int days = 0;
        switch (month){
            case 0: days = 31; break;
            case 1: days = 31; break;
            case 2: days = 28; break;
            case 3: days = 31; break;
            case 4: days = 30; break;
            case 5: days = 31; break;
            case 6: days = 30; break;
            case 7: days = 31; break;
            case 8: days = 31; break;
            case 9: days = 31; break;
            case 10: days = 31; break;
            case 11: days = 30; break;
            case 12: days = 31; break;
        }
        return days;
    }

    public void resetSpinners(){
        spDay.setSelection(0);
        spMonth.setSelection(0);
        spYear.setSelection(0);
    }
}
